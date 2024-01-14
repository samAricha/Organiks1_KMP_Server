package com.joelkanyi.focusbloom.feature.egg_dashboard


import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.joelkanyi.focusbloom.core.data.local_remote_sync.RemoteDataUpdater
import com.joelkanyi.focusbloom.core.data.local_remote_sync.UpdateResult
import com.joelkanyi.focusbloom.core.domain.model.EggCollectionModel
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggCollectionsRepository
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggTypeRepository
import com.joelkanyi.focusbloom.core.utils.UiEvents
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

data class SnackbarData(val message: String)


class ProductionHomeViewModel (
    private val eggCollectionsRepository: EggCollectionsRepository,
): ScreenModel {

    private val remoteDataUpdater: RemoteDataUpdater = RemoteDataUpdater()

    private val _eventsFlow = Channel<UiEvents>(Channel.UNLIMITED)
    val eventsFlow = _eventsFlow.receiveAsFlow()


    private val _eggCollections = MutableStateFlow<List<EggCollectionModel>>(emptyList())
    val eggCollections: StateFlow<List<EggCollectionModel>> = _eggCollections.asStateFlow()


    private val _isSyncing = MutableStateFlow(false)
    val isSyncing: StateFlow<Boolean> = _isSyncing

    val eggSnackbarMessage = mutableStateOf<String?>(null)
    val milkSnackbarMessage = mutableStateOf<String?>(null)
    val fruitSnackbarMessage = mutableStateOf<String?>(null)

    private val _snackbarData = MutableStateFlow<SnackbarData?>(null)
    val snackbarData: StateFlow<SnackbarData?> = _snackbarData



    init {
        viewModelInitialization()
    }

    fun viewModelInitialization(){
        fetchEggCollections()
    }

    // Fetch and update milk collections in your ViewModel
    private fun fetchEggCollections() {
        screenModelScope.launch {
            eggCollectionsRepository.getEggCollections().collectLatest { eggCollections ->
                _eggCollections.value = eggCollections
            }
        }
    }

    // Function to trigger a Snackbar
    fun showSnackbar(message: String) {
        _snackbarData.value = SnackbarData(message)
    }

    // Function to clear the Snackbar
    fun clearSnackbar() {
        _snackbarData.value = null
    }




    fun syncRoomDbToRemote() {

        screenModelScope.launch {
            _eventsFlow.trySend(UiEvents.ShowSnackbar("Data backed up!"))

            _isSyncing.value = true // Set isSyncing to true when synchronization starts
            try {
                // Filter and get eggCollections with status backedUp == false
                val notBackedUpEggCollections = eggCollections.value.filter { eggCollection ->
                    !eggCollection.isBackedUp
                }

                val result =remoteDataUpdater.updateRemoteEggCollectionData(notBackedUpEggCollections, eggCollectionsRepository)

                // Synchronization completed successfully
                when (result) {
                    is UpdateResult.Success -> {
                        eggSnackbarMessage.value = result.message
                        showSnackbar(eggSnackbarMessage.value!!)
                    }
                    is UpdateResult.Failure -> {
                        eggSnackbarMessage.value = result.errorMessage
                        showSnackbar(eggSnackbarMessage.value!!)
                    }

                    else -> {}
                }
            } catch (e: Exception) {
                // Handle synchronization failure
            } finally {
                _isSyncing.value = false // Set isSyncing back to false when synchronization is done
            }
        }
    }
}
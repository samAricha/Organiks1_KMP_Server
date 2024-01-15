package com.teka.organiks.feature.dashborad


import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.teka.organiks.core.domain.model.EggCollectionModel
import com.teka.organiks.core.domain.repository.egg_collections.EggCollectionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DashboardViewModel  (
    private val eggCollectionsRepository: EggCollectionsRepository,
    ): ScreenModel {


    private val _eggCollections = MutableStateFlow<List<EggCollectionModel>>(emptyList())
    val eggCollections: StateFlow<List<EggCollectionModel>> = _eggCollections.asStateFlow()


    private val _isSyncing = MutableStateFlow(false)
    val isSyncing: StateFlow<Boolean> = _isSyncing

    private val _totalNotBackedUpCount = MutableStateFlow(0)
    val totalNotBackedUpCount: StateFlow<Int> = _totalNotBackedUpCount

    init {
        viewModelInitialization()
    }

    fun viewModelInitialization() {
        fetchEggCollections()
        refreshNotBackedUpCollections()
    }

    // Fetch and update milk collections in your ViewModel
    private fun fetchEggCollections() {
        screenModelScope.launch {
            eggCollectionsRepository.getEggCollections().collectLatest { eggCollections ->
                _eggCollections.value = eggCollections
            }
        }
    }


    private suspend fun fetchNotBackedUpCollections() {
        val notBackedUpEggCollections = eggCollectionsRepository.getEggCollections()
            .map { eggCollections ->
                eggCollections.filter { !it.isBackedUp }
            }


        val totalNotBackedUp =
            combine(notBackedUpEggCollections) { eggs ->
                eggs.size
            }

        val total = totalNotBackedUp.first()
        _totalNotBackedUpCount.value = total
    }

    fun refreshNotBackedUpCollections() {
        screenModelScope.launch {
            fetchNotBackedUpCollections()
        }
    }

}

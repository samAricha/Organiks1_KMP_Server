package com.joelkanyi.focusbloom.feature.egg_collection

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.joelkanyi.focusbloom.core.domain.model.EggCollectionModel
import com.joelkanyi.focusbloom.core.domain.model.EggTypeModel
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggCollectionsRepository
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggTypeRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

class ProductionRecordingViewModel (
    private val eggCollectionsRepository: EggCollectionsRepository,
    private val eggTypeRepository: EggTypeRepository,

    ): ScreenModel{

    // Mutable state for eggCollectionId
    private val _eggCollectionId = mutableStateOf(-1)
    val eggCollectionId: State<Int> get() = _eggCollectionId


    var screenState by mutableStateOf(ProductionRecordingState())
        private set

    init {
        getEggTypes()
    }

    init {
        screenState = if (eggCollectionId.value != -1){
            screenState.copy(isUpdatingItem = true)
        }else{
            screenState.copy(isUpdatingItem = false)
        }
    }

    //methods for modifying state
    fun onEggTypeChange(newValue: String){
        screenState = screenState.copy(eggTypeName = newValue)
    }


    fun onQtyChange(newValue: String){
        screenState = screenState.copy(eggCollectionModel = screenState.eggCollectionModel.copy(qty = newValue))
    }
    fun onCrackedQtyChange(newValue: String){
        screenState = screenState.copy(eggCollectionModel = screenState.eggCollectionModel.copy(cracked = newValue))
    }

    fun onDateChange(newValue: Date){
        screenState = screenState.copy(date = newValue)
    }

    fun onScreenDialogDismissed(newValue: Boolean){
        screenState = screenState.copy(isScreenDialogDismissed = newValue)
    }

    fun onSaveEggCollection() {
        screenModelScope.launch {
            eggCollectionsRepository.addEggCollection(
                EggCollectionModel(
                    uuid = UUID.randomUUID().toString(),
                    date = screenState.eggCollectionModel.date,
                    qty = screenState.eggCollectionModel.qty,
                    cracked = screenState.eggCollectionModel.cracked,
                    eggTypeId = screenState.eggTypes.find {
                        it.name == screenState.eggTypeName
                    }?.id ?: 0,
                    isBackedUp = false
                )
            )
            screenState = ProductionRecordingState()
        }
    }


        fun updateEggCollection(id: Int) {
            screenModelScope.launch {
                eggCollectionsRepository.updateEggCollection(
                    EggCollectionModel(
                        uuid = screenState.eggCollectionModel.uuid,
                        date = screenState.eggCollectionModel.date,
                        qty = screenState.eggCollectionModel.qty,
                        cracked = screenState.eggCollectionModel.cracked,
                        eggTypeId = screenState.eggTypes.find {
                            it.name == screenState.eggTypeName
                        }?.id ?: 0,
                        isBackedUp = false
                    )
                )
            }
        }

        fun addEggType() {
            screenModelScope.launch {
                eggTypeRepository.addEggType(
                    EggTypeModel(
                        name = screenState.eggTypeName
                    )
                )
            }
        }

        fun getEggTypes() {
            screenModelScope.launch {
                eggTypeRepository.getEggTypes().collectLatest {
                    screenState = screenState.copy(eggTypes = it)
                }
            }
        }



}
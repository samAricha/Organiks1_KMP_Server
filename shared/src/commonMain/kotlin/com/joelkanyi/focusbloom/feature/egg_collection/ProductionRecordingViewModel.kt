package com.joelkanyi.focusbloom.feature.egg_collection

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.joelkanyi.focusbloom.core.domain.model.EggCollectionModel
import com.joelkanyi.focusbloom.core.domain.model.EggTypeModel
import com.joelkanyi.focusbloom.core.domain.repository.DbRepository
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggCollectionsRepository
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggTypeRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

class ProductionRecordingViewModel (
    private val repository: DbRepository,
    private val eggCollectionsRepository: EggCollectionsRepository,
    private val eggTypeRepository: EggTypeRepository,

    ): ScreenModel{

    // Mutable state for eggCollectionId
    private val _eggCollectionId = mutableStateOf(-1)
    val eggCollectionId: State<Int> get() = _eggCollectionId

    private val _milkCollectionQtyEntered = mutableStateOf("")
    val milkCollectionQtyEntered: State<String> get() = _milkCollectionQtyEntered

    var state by mutableStateOf(ProductionRecordingState())
        private set

    init {
        getEggTypes()
    }

    init {
        state = if (eggCollectionId.value != -1){
            state.copy(isUpdatingItem = true)
        }else{
            state.copy(isUpdatingItem = false)
        }
    }

    //methods for modifying state
    fun onEggTypeChange(newValue: String){
        state = state.copy(eggTypeName = newValue)
    }


    fun onQtyChange(newValue: String){
        state = state.copy(eggCollectionQty = newValue)
    }
    fun onCrackedQtyChange(newValue: String){
        state = state.copy(eggsCracked = newValue)
    }

    fun onDateChange(newValue: Date){
        state = state.copy(date = newValue)
    }

    fun onScreenDialogDismissed(newValue: Boolean){
        state = state.copy(isScreenDialogDismissed = newValue)
    }

    fun onSaveEggCollection() {
        screenModelScope.launch {
            eggCollectionsRepository.addEggCollection(
                EggCollectionModel(
                    uuid = state.eggCollectionModel.uuid,
                    date = state.eggCollectionModel.date,
                    qty = state.eggCollectionModel.qty,
                    cracked = state.eggCollectionModel.cracked,
                    eggTypeId = state.eggTypes.find {
                        it.name == state.eggTypeName
                    }?.id ?: 0,
                    isBackedUp = false
                )
            )
        }
    }


        fun updateEggCollection(id: Int) {
            screenModelScope.launch {
                eggCollectionsRepository.updateEggCollection(
                    EggCollectionModel(
                        uuid = state.eggCollectionModel.uuid,
                        date = state.eggCollectionModel.date,
                        qty = state.eggCollectionModel.qty,
                        cracked = state.eggCollectionModel.cracked,
                        eggTypeId = state.eggTypes.find {
                            it.name == state.eggTypeName
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
                        name = state.eggTypeName
                    )
                )
            }
        }

        fun getEggTypes() {
            screenModelScope.launch {
                eggTypeRepository.getEggTypes().collectLatest {
                    state = state.copy(eggTypes = it)
                }
            }
        }



}
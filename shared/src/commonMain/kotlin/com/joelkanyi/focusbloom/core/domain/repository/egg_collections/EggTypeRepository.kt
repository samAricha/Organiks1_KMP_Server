package com.joelkanyi.focusbloom.core.domain.repository.egg_collections

import com.joelkanyi.focusbloom.core.domain.model.EggTypeModel
import kotlinx.coroutines.flow.Flow

interface EggTypeRepository {
    fun getEggTypes(): Flow<List<EggTypeModel>>

    fun getEggType(id: Int): Flow<EggTypeModel?>

    suspend fun addEggType(eggType: EggTypeModel)

    suspend fun updateEggType(eggType: EggTypeModel)

    suspend fun deleteEggType(id: Int)

    suspend fun deleteAllEggTypes()
}

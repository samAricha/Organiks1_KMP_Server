package com.teka.organiks.core.domain.repository.egg_collections

import com.teka.organiks.core.domain.model.EggCollectionModel
import kotlinx.coroutines.flow.Flow

interface EggCollectionsRepository {
    fun getEggCollections(): Flow<List<EggCollectionModel>>
    fun getEggCollection(id: Int): Flow<EggCollectionModel?>
    fun getEggCollectionByUuid(uuid: String): Flow<EggCollectionModel?>
    suspend fun addEggCollection(eggCollection: EggCollectionModel)
    suspend fun updateEggCollectionByUUId(eggCollection: EggCollectionModel)
    suspend fun updateEggCollection(eggCollection: EggCollectionModel)
    suspend fun deleteEggCollection(id: Int)
    suspend fun deleteAllEggCollections()
}
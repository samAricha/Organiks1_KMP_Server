package com.joelkanyi.focusbloom.core.data.repository.egg_collections

import com.joelkanyi.focusbloom.core.domain.model.EggCollectionModel
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggCollectionsRepository
import com.joelkanyi.focusbloom.database.BloomDatabase
import kotlinx.coroutines.flow.Flow

class EggCollectionsRepositoryImpl(
    bloomDatabase: BloomDatabase,
) : EggCollectionsRepository {
    private val dbQuery = bloomDatabase.taskQueries

//    override fun getEggCollections(): Flow<List<EggCollectionModel>> {
//        return dbQuery
//            .getAllEggCollections()
//            .asFlow()
//            .mapToList()
//            .map { eggCollections ->
//                eggCollections.map {
//                    it.toEggCollection()
//                }
//            }
//    }
//
//    override fun getEggCollection(id: Int): Flow<EggCollectionModel?> {
//        return dbQuery
//            .getEggCollectionById(id)
//            .asFlow()
//            .mapToOneOrNull()
//            .map { eggCollectionEntity ->
//                eggCollectionEntity?.toEggCollection()
//            }
//    }
//
//    override suspend fun addEggCollection(eggCollection: EggCollectionModel) {
//        eggCollection.toEggCollectionEntity().let {
//            dbQuery.insertEggCollection(
//                uuid = it.uuid,
//                qty = it.qty,
//                cracked = it.cracked,
//                eggTypeId = it.eggTypeId,
//                date = it.date,
//                isBackedUp = it.isBackedUp,
//                createdAt = it.createdAt
//            )
//        }
//    }
//
//    override suspend fun updateEggCollection(eggCollection: EggCollectionModel) {
//        eggCollection.toEggCollectionEntity().let {
//            dbQuery.updateEggCollection(
//                egg_collection_id = it.id,
//                uuid = it.uuid,
//                qty = it.qty,
//                cracked = it.cracked,
//                eggTypeId = it.eggTypeId,
//                date = it.date,
//                isBackedUp = it.isBackedUp,
//                createdAt = it.createdAt
//            )
//        }
//    }
//
//    override suspend fun deleteEggCollection(id: Int) {
//        dbQuery.deleteEggCollectionById(id)
//    }
//
//    override suspend fun deleteAllEggCollections() {
//        dbQuery.deleteAllEggCollections()
//    }
}
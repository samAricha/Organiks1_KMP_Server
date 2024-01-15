package com.teka.organiks.core.data.repository.egg_collections

import app.cash.sqldelight.coroutines.asFlow
import com.teka.organiks.core.data.mapper.toEggCollectionModel
import com.teka.organiks.core.data.mapper.toEggCollectionEntity
import com.teka.organiks.core.data.utils.mapToList
import com.teka.organiks.core.data.utils.mapToOneOrNull
import com.teka.organiks.core.domain.model.EggCollectionModel
import com.teka.organiks.core.domain.repository.egg_collections.EggCollectionsRepository
import com.teka.organiks.database.OrganiksDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class EggCollectionsRepositoryImpl(
    organiksDatabase: OrganiksDatabase,
) : EggCollectionsRepository {
    private val dbQuery = organiksDatabase.egg_collectionQueries

    override fun getEggCollections(): Flow<List<EggCollectionModel>> {
        return dbQuery
            .getAllEggCollections()
            .asFlow()
            .mapToList()
            .map { eggCollections ->
                eggCollections.map {
                    it.toEggCollectionModel()
                }
            }
    }

    override fun getEggCollection(id: Int): Flow<EggCollectionModel?> {
        return dbQuery
            .getEggCollectionById(id.toLong())
            .asFlow()
            .mapToOneOrNull()
            .map { eggCollectionEntity ->
                eggCollectionEntity?.toEggCollectionModel()
            }
    }

    override fun getEggCollectionByUuid(uuid: String): Flow<EggCollectionModel?> {
        return dbQuery
            .getEggCollectionByUUId(uuid)
            .asFlow()
            .mapToOneOrNull()
            .map { eggCollectionEntity ->
                eggCollectionEntity?.toEggCollectionModel()
            }
    }

    override suspend fun addEggCollection(eggCollection: EggCollectionModel) {
        eggCollection.toEggCollectionEntity().let {
            dbQuery.insertEggCollection(
                uuid = it.uuid,
                qty = it.qty,
                cracked = it.cracked,
                eggTypeId = it.eggTypeId,
                date = it.date,
                isBackedUp = it.isBackedUp,
                createdAt = it.createdAt
            )
        }
    }

    override suspend fun updateEggCollectionByUUId(eggCollection: EggCollectionModel) {
//        val existingEntity: EggCollectionModel? = getEggCollectionByUuid(eggCollection.uuid).firstOrNull()
//        println("ExistingEntity $existingEntity")

        eggCollection.toEggCollectionEntity().let {
            dbQuery.updateEggCollectionByUUId(
                uuid = it.uuid,
                qty = it.qty,
                cracked = it.cracked,
                eggTypeId = it.eggTypeId,
                date = it.date,
                isBackedUp = 1,
                createdAt = it.createdAt
            )
        }
    }

    override suspend fun updateEggCollection(eggCollection: EggCollectionModel) {
        val existingEntity: EggCollectionModel? = getEggCollectionByUuid(eggCollection.uuid).firstOrNull()
        println("ExistingEntity $existingEntity")

        existingEntity?.toEggCollectionEntity()?.let {
            dbQuery.updateEggCollection(
                egg_collection_id = it.egg_collection_id,
                uuid = it.uuid,
                qty = it.qty,
                cracked = it.cracked,
                eggTypeId = it.eggTypeId,
                date = it.date,
                isBackedUp = 1,
                createdAt = it.createdAt
            )
        }
    }

    override suspend fun deleteEggCollection(id: Int) {
        dbQuery.deleteEggCollectionById(id.toLong())
    }

    override suspend fun deleteAllEggCollections() {
        dbQuery.deleteAllEggCollections()
    }

}
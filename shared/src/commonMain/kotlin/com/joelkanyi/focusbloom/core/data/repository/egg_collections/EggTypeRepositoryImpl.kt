package com.joelkanyi.focusbloom.core.data.repository.egg_collections

import app.cash.sqldelight.coroutines.asFlow
import com.joelkanyi.focusbloom.core.data.mapper.toEggTypeEntity
import com.joelkanyi.focusbloom.core.data.mapper.toEggTypeModel
import com.joelkanyi.focusbloom.core.data.utils.mapToList
import com.joelkanyi.focusbloom.core.data.utils.mapToOneOrNull
import com.joelkanyi.focusbloom.core.domain.model.EggTypeModel
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggTypeRepository
import com.joelkanyi.focusbloom.database.BloomDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EggTypeRepositoryImpl(
    private val bloomDatabase: BloomDatabase
) : EggTypeRepository {
    private val dbQuery = bloomDatabase.egg_typeQueries

    override fun getEggTypes(): Flow<List<EggTypeModel>> {
        return dbQuery
            .getAllEggTypes()
            .asFlow()
            .mapToList()
            .map { eggTypes ->
                eggTypes.map {
                    it.toEggTypeModel()
                }
            }
    }

    override fun getEggType(id: Int): Flow<EggTypeModel?> {
        return dbQuery
            .getEggTypeById(id.toLong())
            .asFlow()
            .mapToOneOrNull()
            .map { eggTypeEntity ->
                eggTypeEntity?.toEggTypeModel()
            }
    }

    override suspend fun addEggType(eggType: EggTypeModel) {
        eggType.toEggTypeEntity().let {
            dbQuery.insertEggType(
                name = it.name
            )
        }
    }

    override suspend fun updateEggType(eggType: EggTypeModel) {
        eggType.toEggTypeEntity().let {
            dbQuery.updateEggType(
                egg_type_id = it.egg_type_id,
                name = it.name
            )
        }
    }

    override suspend fun deleteEggType(id: Int) {
        dbQuery.deleteEggTypeById(id.toLong())
    }

    override suspend fun deleteAllEggTypes() {
        dbQuery.deleteAllEggTypes()
    }
}

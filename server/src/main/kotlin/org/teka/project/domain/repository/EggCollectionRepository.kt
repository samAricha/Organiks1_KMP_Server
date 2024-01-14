package org.teka.project.domain.repository

import com.example.data.remote.dto.egg_collection.CreateEggCollectionDto
import com.example.data.remote.dto.egg_collection.EggCollectionDTO
import org.jetbrains.exposed.sql.transactions.transaction
import org.teka.project.data.mysql.mysql_models.egg_collection.EggCollectionEntity
import org.teka.project.data.mysql.mysql_models.egg_collection.EggCollectionTable

class EggCollectionRepository {

    fun findAll(): List<EggCollectionDTO> = transaction {
        EggCollectionEntity
            .all()
            .map {
                EggCollectionDTO(
                    it.uuid,
                    it.qty,
                    it.cracked,
                    it.eggTypeId,
                    it.date,
                    it.isBackedUp,
                    it.createdAt
                )
            }
    }

    fun find(uuid: String): EggCollectionDTO? = transaction {
        EggCollectionEntity
            .find { EggCollectionTable.uuid eq uuid }
            .singleOrNull()
            ?.let {
                EggCollectionDTO(
                    it.uuid,
                    it.qty,
                    it.cracked,
                    it.eggTypeId,
                    it.date,
                    it.isBackedUp,
                    it.createdAt
                )
            }
    }


    fun create(createEggCollectionDTO: CreateEggCollectionDto): String = transaction {
        val newEntity = EggCollectionEntity.new {
            uuid = createEggCollectionDTO.uuid
            qty = createEggCollectionDTO.qty
            cracked = createEggCollectionDTO.cracked
            eggTypeId = createEggCollectionDTO.eggTypeId
            date = createEggCollectionDTO.date
            isBackedUp = createEggCollectionDTO.isBackedUp
            createdAt = createEggCollectionDTO.createdAt
        }
        newEntity.uuid
    }

    fun delete(uuid: String): Unit = transaction {
        EggCollectionEntity
            .find { EggCollectionTable.uuid eq uuid }
            .forEach { it.delete() }
    }

    fun update(uuid: String, eggCollectionDTO: EggCollectionDTO): Unit = transaction {
        EggCollectionEntity
            .find { EggCollectionTable.uuid eq uuid }
            .singleOrNull()
            ?.let {
                it.uuid = eggCollectionDTO.uuid
                it.qty = eggCollectionDTO.qty
                it.cracked = eggCollectionDTO.cracked
                it.eggTypeId = eggCollectionDTO.eggTypeId
                it.date = eggCollectionDTO.date
                it.isBackedUp = eggCollectionDTO.isBackedUp
                it.createdAt = eggCollectionDTO.createdAt
        }
    }


}


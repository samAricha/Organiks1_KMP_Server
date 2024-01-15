package com.teka.organiks.core.data.mapper

import com.teka.organiks.core.data.remote.EggCollectionDTO
import com.teka.organiks.core.domain.model.EggCollectionModel
import com.teka.organiks.core.domain.model.EggTypeModel
import com.teka.organiks.core.utils.dateTimeToString
import database.EggCollectionEntity
import database.EggTypeEntity
import kotlinx.datetime.toLocalDateTime

// Assuming date conversion functions and other necessary utilities are available
fun EggCollectionEntity.toEggCollectionModel() = EggCollectionModel(
    uuid = uuid,
    qty = qty,
    cracked = cracked,
    eggTypeId = eggTypeId.toInt(), // Assuming eggTypeId is a Long in the entity
    date = date.toLocalDateTime(), // Convert date to LocalDateTime
    isBackedUp = isBackedUp == 1L, // Assuming isBackedUp is a Long in the entity
    createdAt = createdAt
)

fun EggCollectionModel.toEggCollectionEntity() = EggCollectionEntity(
    egg_collection_id = 0,
    uuid = uuid,
    qty = qty,
    cracked = cracked,
    eggTypeId = eggTypeId.toLong(), // Assuming eggTypeId is an Int in the model
    date = date.dateTimeToString(), // Convert LocalDateTime to formatted string
    isBackedUp = if (isBackedUp) 1L else 0L, // Convert Boolean to Long
    createdAt = createdAt
)

fun EggCollectionModel.toEggCollectionDTO() = EggCollectionDTO(

    uuid = uuid,
    qty = qty,
    cracked = cracked,
    eggTypeId = eggTypeId.toLong(),
    date = date.dateTimeToString(),
    isBackedUp = if (isBackedUp) 1L else 0L,
    createdAt = createdAt
)

fun EggTypeEntity.toEggTypeModel(): EggTypeModel {
    return EggTypeModel(
        id = egg_type_id.toInt(),
        name = name
    )
}

fun EggTypeModel.toEggTypeEntity(): EggTypeEntity {
    return EggTypeEntity(
        egg_type_id = id.toLong(),
        name = name
    )
}


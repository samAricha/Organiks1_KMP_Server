package com.joelkanyi.focusbloom.core.data.mapper

import com.joelkanyi.focusbloom.core.data.remote.EggCollectionDTO
import com.joelkanyi.focusbloom.core.domain.model.EggCollectionModel
import com.joelkanyi.focusbloom.core.domain.model.EggTypeModel
import com.joelkanyi.focusbloom.core.domain.model.Task
import com.joelkanyi.focusbloom.core.utils.dateTimeToString
import database.EggCollectionEntity
import database.EggTypeEntity
import database.TaskEntity
import kotlinx.datetime.toLocalDateTime

fun TaskEntity.toTask() = Task(
    id = id,
    name = name,
    description = description,
    type = type,
    start = start.toLocalDateTime(),
    color = color,
    current = current,
    date = date.toLocalDateTime(),
    focusSessions = focusSessions,
    completed = completed,
    consumedFocusTime = consumedFocusTime,
    consumedShortBreakTime = consumedShortBreakTime,
    consumedLongBreakTime = consumedLongBreakTime,
    inProgressTask = inProgressTask,
    currentCycle = currentCycle,
    active = active,
)

fun Task.toTaskEntity() = TaskEntity(
    id = id,
    name = name,
    description = description,
    type = type,
    start = start.dateTimeToString(),
    color = color,
    current = current,
    date = date.dateTimeToString(),
    focusSessions = focusSessions,
    completed = completed,
    consumedFocusTime = consumedFocusTime,
    consumedShortBreakTime = consumedShortBreakTime,
    consumedLongBreakTime = consumedLongBreakTime,
    inProgressTask = inProgressTask,
    currentCycle = currentCycle,
    active = active,
)

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


package com.joelkanyi.focusbloom.core.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


data class EggCollectionModel(
    val uuid: String = "",  // Add default values for other properties as needed
    val qty: String = "",
    val cracked: String = "",
    val eggTypeId: Int = 0,
    val date: LocalDateTime = getCurrentLocalDateTime(),
    val isBackedUp: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

fun getCurrentLocalDateTime(): LocalDateTime {
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
}
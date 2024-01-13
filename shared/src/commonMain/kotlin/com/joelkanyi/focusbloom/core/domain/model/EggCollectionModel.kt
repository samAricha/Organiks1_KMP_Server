package com.joelkanyi.focusbloom.core.domain.model

import kotlinx.datetime.LocalDateTime

data class EggCollectionModel(
    val id: Int = 0,
    val uuid: String,
    val qty: String,
    val cracked: String,
    val eggTypeId: Int,
    val date: LocalDateTime,
    val isBackedUp: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
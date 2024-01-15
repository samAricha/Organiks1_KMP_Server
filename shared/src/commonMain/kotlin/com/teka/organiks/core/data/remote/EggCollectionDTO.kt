package com.teka.organiks.core.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class EggCollectionDTO(
    val uuid: String,
    val qty: String,
    val cracked: String,
    val eggTypeId: Long,
    val date: String,
    val isBackedUp: Long,
    val createdAt: Long
)

package com.example.data.remote.dto.egg_collection

import kotlinx.serialization.Serializable

@Serializable
data class UpdateEggCollectionDto(
    val egg_collection_id: Long,
    val uuid: String,
    val qty: String,
    val cracked: String,
    val eggTypeId: Long,
    val date: String,
    val isBackedUp: Long,
    val createdAt: Long
)

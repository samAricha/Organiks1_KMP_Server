package com.example.data.remote.dto.egg_collection

data class EggCollectionDTO(
    val uuid: String,
    val qty: String,
    val cracked: String,
    val eggTypeId: Long,
    val date: String,
    val isBackedUp: Long,
    val createdAt: Long
)
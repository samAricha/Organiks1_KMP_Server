package org.teka.project.data.remote.dto.egg_collection

import kotlinx.serialization.Serializable

@Serializable
data class CreateEggCollectionDto(
    val uuid: String,
    val qty: String,
    val cracked: String,
    val eggTypeId: Long,
    val date: String,
    val isBackedUp: Long,
    val createdAt: Long
)

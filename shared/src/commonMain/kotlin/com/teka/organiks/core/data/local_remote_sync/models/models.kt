package com.teka.organiks.core.data.local_remote_sync.models

import kotlinx.serialization.Serializable

@Serializable
data class RemoteEggCollectionResponse(
    val success: Boolean,
    val message: String?,
)

@Serializable
data class SaveCollectionResponse(
    val success: Boolean,
    val message: String?,
)

@Serializable
data class OpenAiSearchResponse(
    val result: String?,
)
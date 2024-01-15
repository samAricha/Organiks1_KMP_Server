package com.teka.organiks.core.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class GenericApiResponse<out T>(
    val isSuccess:Boolean,
    val data: T
)
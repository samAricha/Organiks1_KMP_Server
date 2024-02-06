package com.teka.organiks.domain.repository

import com.teka.organiks.domain.model.ChatStatusModel


interface GeminiRepository {
    suspend fun generate(prompt: String, images: List<ByteArray> = emptyList()): ChatStatusModel

    fun getApiKey(): String

    fun setApiKey(key: String)
}

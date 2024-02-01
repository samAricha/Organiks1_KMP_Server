package com.teka.organiks.core.data.repository.gemini

import com.teka.organiks.core.data.remote.GeminiService
import com.teka.organiks.domain.model.ChatStatusModel
import com.teka.organiks.domain.repository.GeminiRepository
import io.ktor.utils.io.errors.IOException

class GeminiRepositoryImpl : GeminiRepository {

    private val geminiService = GeminiService()

    override suspend fun generate(prompt: String, images: List<ByteArray>): ChatStatusModel {
        return try {
            val response = when {
                images.isEmpty() -> geminiService.generateContent(prompt)
                else -> geminiService.generateContentWithMedia(prompt, images)
            }

            val status = response.error?.let {
                ChatStatusModel.Error(it.message)
            } ?: response.getText()?.let {
                ChatStatusModel.Success(it)
            } ?: ChatStatusModel.Error("An error occurred, please retry.")

            status

        } catch (e: IOException) {
            ChatStatusModel.Error("Unable to connect to the server. Please check your internet connection and try again.")
        } catch (e: Exception) {
            ChatStatusModel.Error("An error occurred, please retry.")
        }
    }

    override fun getApiKey(): String {
        return geminiService.getApiKey()
    }

    override fun setApiKey(key: String) {
        geminiService.setApiKey(key)
    }


}
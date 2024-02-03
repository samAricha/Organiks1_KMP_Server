package com.teka.organiks.core.data.remote


import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

const val TIMEOUT = 30000L

@OptIn(ExperimentalSerializationApi::class, InternalAPI::class)
class GeminiService {

    // region Setup
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                explicitNulls = false
                encodeDefaults = true
                ignoreUnknownKeys = true
            })
        }
        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT
            socketTimeoutMillis = TIMEOUT
            requestTimeoutMillis = TIMEOUT
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    private val baseUrl = "https://generativelanguage.googleapis.com/v1/models"
    private var apiKey: String = ""

    fun getApiKey(): String {
        return apiKey
    }

    fun setApiKey(key: String) {
        apiKey = key
    }

    suspend fun generateContent(prompt: String): Response {
        return makeApiRequest("$baseUrl/gemini-pro:generateContent?key=$apiKey") {
            addText(prompt)
        }
    }

    suspend fun generateContentWithMedia(prompt: String, images: List<ByteArray>): Response {
        return makeApiRequest("$baseUrl/gemini-pro-vision:generateContent?key=$apiKey") {
            addText(prompt)
            addImages(images)
        }
    }

    private suspend fun makeApiRequest(url: String, requestBuilder: Request.RequestBuilder.() -> Unit): Response {
        val request = Request.RequestBuilder().apply(requestBuilder).build()

        val response: String = client.post(url) {
            body = Json.encodeToString(request)
        }.bodyAsText()

        return Json.decodeFromString(response)
    }
}
package com.teka.organiks.core.data.remote


import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class BackendApi {
    private val baseUrl = "https://generativelanguage.googleapis.com/v1/models"
    private val apiKey = "AIzaSyAPN3pRJqLIiSALpvs_vdehFQPEcAJZih4"

    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                isLenient = true;
                ignoreUnknownKeys = true;
                explicitNulls = false}
            )
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

//    suspend fun generateContentWithMedia(prompt: String, image: ByteArray): Response {
//        return makeApiRequest("$baseUrl/gemini-pro-vision:generateContent?key=$apiKey") {
//            addText(prompt)
//            addImage(image)
//        }
//    }

//    @OptIn(InternalAPI::class)
//    private suspend fun makeApiRequest(url: String, requestBuilder: Request.RequestBuilder.() -> Unit): Response {
//        val request = Request.RequestBuilder().apply(requestBuilder).build()
//
//        val response: String = client.post(url) {
//            body = Json.encodeToString(request)
//        }.bodyAsText()
//
//        return Json.decodeFromString(response)
//    }
}
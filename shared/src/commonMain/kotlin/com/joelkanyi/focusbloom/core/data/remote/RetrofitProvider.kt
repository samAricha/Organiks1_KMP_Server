package com.joelkanyi.focusbloom.core.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


object RetrofitProvider {
    private const val TEST_URL = "https://1661-41-81-202-217.ngrok-free.app/api"
    private const val BASE_URL = "http://191.101.0.246:8081"

    //here we provide the HTTP client
     private fun provide(): HttpClient{
        @OptIn(ExperimentalSerializationApi::class)
        val client: HttpClient = HttpClient {
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
        return client
    }



    @OptIn(InternalAPI::class)
    suspend fun createEggCollectionBackup(eggCollectionDTO: EggCollectionDTO): GenericApiResponse<String> {
        try {
            val client: HttpClient = provide()
            val response: String = client.post("$TEST_URL/eggs/create") {
                header("Content-Type", ContentType.Application.Json.toString())  // Set the Content-Type header
                body = Json.encodeToString(eggCollectionDTO)
            }.bodyAsText()

            println("ApiResponse: $response")


            return Json.decodeFromString(response)

            // Assuming the response contains a string data
//            return GenericApiResponse(isSuccess = true, data = response)
        } catch (e: ClientRequestException) {
            // Handle HTTP status codes indicating failure
            val errorMessage = when (e.response.status) {
                HttpStatusCode.BadRequest -> "Bad request: ${e.response.bodyAsText()}"
                else -> "HTTP ${e.response.status.value}"
            }
            return GenericApiResponse(isSuccess = false, data = errorMessage)
        } catch (e: Exception) {
            // Handle other exceptions (e.g., network issues)
            return GenericApiResponse(isSuccess = false, data = "Error: ${e.message}")
        }
    }


}
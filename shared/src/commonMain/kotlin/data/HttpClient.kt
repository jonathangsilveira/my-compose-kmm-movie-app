package data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(json: Json) = HttpClient {
    install(ContentNegotiation) {
        json(json)
    }
}

fun createJson() = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
}
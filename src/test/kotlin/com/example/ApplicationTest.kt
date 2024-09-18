package com.example

import com.example.domain.Task
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun tasksCanBeFoundByPriority() = testApplication {
        install(ContentNegotiation){
            json()
        }
        val client = createClient {  }

        val response = client.get("/tasks/byPriority/MEDIUM")
        val results = response.body<List<Task>>()


    }

}
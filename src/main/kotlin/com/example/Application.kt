package com.example

import com.example.application.FakeTaskRepository
import com.example.application.configureSerialization
import com.example.configuration.configureDatabases
import com.example.plugins.*
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.defaultheaders.DefaultHeaders
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondText
import kotlinx.serialization.json.Json

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(DefaultHeaders)

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }

    install(StatusPages) {
        exception<Throwable> { call, cause->
            call.respondText(text = "A[[ om o;;ega; stae as ${cause.message}", status = HttpStatusCode.InternalServerError)
        }
    }

    val repository = FakeTaskRepository()

    configureRouting()
    configureDatabases()
    configureSerialization(repository = repository)
}

package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondText

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(StatusPages) {
        exception<IllegalStateException> { call: ApplicationCall, cause->
            call.respondText("A[[ om o;;ega; stae as ${cause.message}")
        }
    }
    configureRouting()
}

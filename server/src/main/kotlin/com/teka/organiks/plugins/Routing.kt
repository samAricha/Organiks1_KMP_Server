package com.teka.organiks.plugins

import com.teka.organiks.routes.eggsRoute
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        eggsRoute()
    }
}

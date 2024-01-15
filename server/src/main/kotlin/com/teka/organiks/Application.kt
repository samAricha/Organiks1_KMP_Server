package com.teka.organiks

import Greeting
import SERVER_PORT
import io.github.cdimascio.dotenv.dotenv
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.teka.organiks.plugins.configureDataBase
import com.teka.organiks.plugins.configureRouting
import com.teka.organiks.plugins.configureSerialization


val dotenv = dotenv {
    ignoreIfMissing = true
}
fun main() {

    val env = applicationEngineEnvironment {
        envConfig()
    }
    embeddedServer(Netty, env)
        .start(wait = true)
}


fun Application.module() {
    configureDataBase()
    configureSerialization()
    configureRouting()
}

fun ApplicationEngineEnvironmentBuilder.envConfig() {
    SERVER_PORT
    module {
        module()
    }
    connector {
        host = "127.0.0.1"
        port = SERVER_PORT
    }
}



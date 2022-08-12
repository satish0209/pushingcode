package com.example

import com.example.DatabseConnection.databasefactory
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.repository.userrepository
import com.example.repository.userrepositoryImpl
import com.example.routes.authroutes
import com.example.service.userservice
import com.example.service.userserviceImpl
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*

fun main() {
    embeddedServer(Netty, port = 8083, host = "0.0.0.0") {

        databasefactory.init()
        install(ContentNegotiation){
            jackson()
        }



        val Service: userservice = userserviceImpl()
        val repository: userrepository = userrepositoryImpl(Service)

        authroutes(repository)

    }.start(wait = true)
}

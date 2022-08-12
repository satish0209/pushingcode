package com.example.routes

import com.example.repository.userrepository
import com.example.service.CreateUserParams
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Application.authroutes(repository: userrepository){

    routing {
        route("/auth"){
            post("/register"){
                val params=call.receive<CreateUserParams>()
                val result=repository.registeruser(params)
                call.respond(result.statusCode,result)

            }
            post("/login/{qw}"){
                val qw =call.parameters["qw"]
                call.respondText ("login $qw" )
            }
        }
    }


}
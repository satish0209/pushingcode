package com.example.repository

import com.example.service.CreateUserParams
import com.example.service.userservice
import com.example.utils.baseresponse

class userrepositoryImpl( private val userservice: userservice) : userrepository {


    override suspend fun registeruser(params: CreateUserParams): baseresponse<Any> {
        val user= userservice.registeruser(params)
        return if (user!=null){
            baseresponse.Successresponse(data=user)
        }else{
            baseresponse.ErrorResponse("error")
        }

    }

    override suspend fun loginuser(email: String, password: String): baseresponse<Any> {
        TODO("Not yet implemented")
    }
}
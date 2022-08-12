package com.example.repository

import com.example.service.CreateUserParams
import com.example.utils.baseresponse

interface userrepository {

    suspend fun registeruser(params: CreateUserParams): baseresponse<Any>
    suspend fun loginuser(email:String, password:String): baseresponse<Any>

}
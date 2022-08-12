package com.example.service

import com.example.models.user


interface userservice {
    suspend fun registeruser(params:CreateUserParams): user?
//    suspend fun finduserbymail(mail:String): user?
//    companion object

}
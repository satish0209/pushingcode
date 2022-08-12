package com.example.service


data class CreateUserParams (
    val fullname: String,
    val mail: String,
    val password: String,
    val avatar: String,
    val id: Int

)
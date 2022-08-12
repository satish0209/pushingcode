package com.example.utils

import io.ktor.http.*

sealed class baseresponse<t>(

    val statusCode: HttpStatusCode = HttpStatusCode.OK

) {

    data class Successresponse<T>(
        val data: T? = null,
        val message: String?=null

    ): baseresponse<T>()

    data class ErrorResponse<T>(
//  val exception: T? = null,
        val message: String?=null

    ): baseresponse<T>()
}
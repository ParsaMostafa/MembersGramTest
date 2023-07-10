package com.example.membersgramtest.models.v1

data class MyResponse(
    val status: String,
    val data: ResponseData?,
    val message: String?,
    val code: Int,
    val method: Int
) {
    data class ResponseData(
        val added_coin: Int
    )
}
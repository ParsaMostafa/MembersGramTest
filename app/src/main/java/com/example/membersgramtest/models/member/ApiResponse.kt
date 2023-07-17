package com.example.membersgramtest.models.member

data class ApiResponse (
    val status: String,
    val data: ResponseData,
    val message: String?,
    val code: Int,
    val methode: Int
)
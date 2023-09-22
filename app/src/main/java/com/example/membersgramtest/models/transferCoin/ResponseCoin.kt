package com.example.membersgramtest.models.transferCoin

data class ResponseCoin(
    val code: Int,
    var `data`: Data?,
    val message: String,
    val messageErrors: List<ErrorResponse>,
    val methode: String,
    val status: String
)
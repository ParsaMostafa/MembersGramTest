package com.example.membersgramtest.models.Transaction

data class TransactionResponse(
    val code: Int,
    val `data`: Data,
    val message: Any,
    val methode: Int,
    val status: String
)
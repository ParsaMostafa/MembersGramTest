package com.example.membersgramtest.models.getcoins

data class GetCoins(
    val code: Int,
    val `data`: Data,
    val message: Any,
    val methode: Int,
    val status: String
)
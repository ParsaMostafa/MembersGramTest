package com.example.membersgramtest.models.v2

data class VerifyRegisterResponse(
    val status: String,
    val data: Data,
    val message: String?,
    val code: Int,
    val methode: Int
) {
    data class Data(val data: TokenData, val user: UserData) {
        data class TokenData(val token: String)
        data class UserData(val coins: Int)
    }
}

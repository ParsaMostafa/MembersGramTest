package com.example.membersgramtest.models.memberresponse

data class MemberResponse(
    val code: Int,
    val `data`: Data,
    val message: Any,
    val methode: Int,
    val status: String
)
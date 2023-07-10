package com.example.membersgramtest.models.v2

data class VerifyRegisterRequest(val data: Data) {
    data class Data(val phonenumber: String, val verifyCode: Int)
}
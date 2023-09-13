package com.example.membersgramtest.models.transferCoin

class TransferCoinRequest(val data: Data) {
    data class Data(val phonenumber: String, val coin: Int)
}
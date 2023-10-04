package com.example.membersgramtest.models.Transaction

data class Doc(
    val _id: String,
    val coin: Int,
    val date: String,
    val dateTime: Long,
    val id: String,
    val itemType: String,
    val market: String,
    val member_count: Int,
    val pay_member: Boolean,
    val pay_view: Boolean,
    val price: Float,
    val purchaseState: String,
    val time: String,
    val token: String,

)
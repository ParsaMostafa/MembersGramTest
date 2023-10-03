package com.example.membersgramtest.models.paymentchips

import com.example.membersgramtest.models.memberresponse.RV1Member

sealed class RVChips {


    data class RV1ChipsData (
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
        val price: Int,
        val purchaseState: String,
        val time: String,
        val token: String,
        var isSelected: Boolean = false // Adding the isSelected field with a default value
    ) : RVChips()



}
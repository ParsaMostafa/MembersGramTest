package com.example.membersgramtest.models.v1

import com.example.membersgramtest.utillity.Consts.TG_ID

data class MyRequest(
    val data: RequestData
) {
    data class RequestData(
        val phonenumber: String,
        val market: String  ,
        val tg_id: Int
    )
}

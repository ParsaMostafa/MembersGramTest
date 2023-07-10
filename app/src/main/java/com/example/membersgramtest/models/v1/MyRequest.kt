package com.example.membersgramtest.models.v1

import com.example.membersgramtest.utillity.Consts.TG_ID

data class MyRequest(
    val data: RequestData
) {
    data class RequestData(
        val phoneNumber: String,
        val market: String = "zarinpal" ,
        val tg_id: Int = TG_ID
    )
}

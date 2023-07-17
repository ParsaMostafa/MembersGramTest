package com.example.membersgramtest.models.member

data class DataDetail(
    val purchase_getmember: List<PurchaseMember>,
    val coin_getmember: List<CoinMember>,
    val daily_getmember: List<DailyMember>,
    val purchase_hiddengetmember: List<Any> // You should replace Any with the correct class when the structure is known
)

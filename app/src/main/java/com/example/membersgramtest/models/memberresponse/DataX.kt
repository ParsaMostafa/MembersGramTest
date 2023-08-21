package com.example.membersgramtest.models.memberresponse

data class DataX(
    val buyCountries: BuyCountries,
    val coin_getmember: List<CoinGetmember>,
    val daily_getmember: List<Any>,
    val purchase_getmember: List<PurchaseGetmember>,
    val purchase_hiddengetmember: List<Any>
)
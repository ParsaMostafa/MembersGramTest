package com.example.membersgramtest.models.member

data class PurchaseMember(
    val by_coin: Boolean,
    val is_active: Boolean,
    val shop_type: Int,
    val animationMode: Int,
    val memberTypeNumber: Int,
    val hidden: Boolean,
    val dayCount: Int?, // This can be null
    val daily: Boolean,
    val buyCountries: String,
    val country: Boolean,
    val world: Boolean,
    val ABtest: Int?, // This can be null
    val _id: String,
    val __v: Int,
    val Id: Int,
    val coin: Int,
    val onvan: String,
    val member_count: Int,
    val member_count_real: Int,
    val discount_member_count: Int,
    val discountString: String,
    val darsad: String,
    val sku: String,
    val type: String,
    val market: String,
    val image: String,
    val price: Double,
    val discount: Int,
    val id: String
)

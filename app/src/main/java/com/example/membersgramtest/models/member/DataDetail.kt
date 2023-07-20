package com.example.membersgramtest.models.member

import com.google.gson.annotations.SerializedName

data class DataDetail(
    @SerializedName("Id") var Id: Int,
    @SerializedName("by_coin") val by_coin: Boolean,
    @SerializedName("coin") val coin: Int,
    @SerializedName("onvan") val onvan: String?,
    @SerializedName("discountString") val discountString: String?,
    @SerializedName("market") val market: String,
    @SerializedName("member_count") val member_count: Int,
    @SerializedName("discount_member_count") val discount_member_count: Int,
    @SerializedName("price") val price: Float,
    @SerializedName("discount") val discount: Int,
    @SerializedName("sku") val sku: String,
    @SerializedName("type") val type: String,
    @SerializedName("image") val image: String,
    val image_l_fa: String?,
    val image_d_fa: String?,
    val image_l_en: String?,
    val image_d_en: String?,
    @SerializedName("animationMode") val animationMode: Int,
    @SerializedName("hidden") val isHidden: Boolean,
    @SerializedName("daily") val daily: Boolean,
    @SerializedName("dayCount") val dayCount: Int


)

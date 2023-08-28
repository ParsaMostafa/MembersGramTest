package com.example.membersgramtest.models.getcoins

sealed class RVBuyCoin {


    data class  HeaderModel (
        val Id: Int,
        val __v: Int,
        val _id: String,
        val background: String?,
        val coincount: Int,
        val darsad: String?,
        val date: String,
        val description: String?,
        val discount: Float,
        val discount_coin: Int,
        val discount_image: String?,
        val disprice: Int?,
        val hour: Int?,
        val id: String?,
        val image: String?,
        val is_active: Boolean?,
        val market: String?,
        val onvan: String?,
        val price: Int?,
        val promotion_counter: Int?,
        val remain_time: Int?,
        val sku: String?,
        val title_image: String?,
        val type: String?
            ) : RVBuyCoin()

    data  class Title (val title: String) : RVBuyCoin()


    data class BodyModel(
        val Id: Int,
        val __v: Int,
        val _id: String,
        val background: String?,
        val coincount: Int,
        val darsad: String?,
        val date: String,
        val description: String?,
        val discount: Float,
        val discount_coin: Int,
        val discount_image: String?,
        val disprice: Int?,
        val hour: Int?,
        val id: String?,
        val image: String?,
        val is_active: Boolean?,
        val market: String?,
        var onvan: String?,
        val price: Int?,
        val promotion_counter: Int?,
        val remain_time: Int?,
        val sku: String?,
        val title_image: String?,
        val type: String?

    ) : RVBuyCoin()
}
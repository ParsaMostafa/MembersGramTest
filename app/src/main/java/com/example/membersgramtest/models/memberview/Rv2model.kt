package com.example.membersgramtest.models.memberview

sealed class Rv2model {

    object Rv2HeaderModel :Rv2model()
    data class Rv2BodyModel (
        val Id: Int,
        val __v: Int,
        val _id: String,
        val animationMode: Int,
        val by_coin: Boolean,
        val coin: Int,
        val count_post: Int,
        val discount: Int,
        val discountString: String,
        val discount_view_count: Int,
        val id: String,
        val image: String,
        val image_view: String?,
        val is_active: Boolean,
        val market: String,
        val onvan: String,
        val price: Int,
        val shop_type: Int,
        val sku: String,
        val type: String,
        val view_count: Int,
        val view_count_real: Int

            ):Rv2model()

}
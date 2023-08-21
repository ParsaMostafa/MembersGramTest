package com.example.membersgramtest.models.memberresponse

import com.example.membersgramtest.models.ViewTabModel.Rv2model

sealed class RV2MEMBER {


    data  class Rv2HeaderModel(val title: String) : RV2MEMBER()


     data class Rv2BodyModel(
        var ABtest: Any?,
        val Id: Int?,
        val __v: Int?,
        val _id: String?,
        val animationMode: Int?,
        val buyCountries: String?,
        val by_coin: Boolean,
        val coin: Int?,
        val country: Boolean,
        val daily: Boolean,
        val darsad: String?,
        val dayCount: Any?,
        val discount: Int,
        val discountString: String?,
        val discount_member_count: Int?,
        val hidden: Boolean,
        val id: String?,
        val image: String?,
        val is_active: Boolean,
        val market: String?,
        val memberTypeNumber: Int?,
        val member_count: Int?,
        val member_count_real: Int?,
        val onvan: String?,
        val price: Double,
        val shop_type: Int?,
        val sku: String?,
        val sortCountry: Int?,
        val type: String?,
        val world: Boolean,
    ) : RV2MEMBER()


   object FooterModel : RV2MEMBER()

}



















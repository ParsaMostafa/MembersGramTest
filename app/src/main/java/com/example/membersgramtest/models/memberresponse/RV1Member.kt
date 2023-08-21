package com.example.membersgramtest.models.memberresponse

sealed class RV1Member{



    data class RV1Model (
        val countryCode: String?,
        val flag: String?,
        val flagEmoji: String?,
        var name: String?,
        val nameEn: String?,
        val nameFa: String?,
        var isSelected: Boolean = false // Adding the isSelected field with a default value
            ) : RV1Member()




}

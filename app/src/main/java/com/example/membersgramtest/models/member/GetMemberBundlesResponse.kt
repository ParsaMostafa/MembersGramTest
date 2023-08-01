package com.example.membersgramtest.models.member

import com.google.gson.annotations.SerializedName

data class GetMemberBundlesResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("data") val `data`: GetMemberBundlesData,
    @SerializedName("message") val message: Any,
    @SerializedName("methode") val methode: Int,
    @SerializedName("status") val status: String
)

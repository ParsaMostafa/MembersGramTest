package com.example.membersgramtest.models.member

import com.google.gson.annotations.SerializedName

data class GetMemberBundlesDataData(
    @SerializedName("purchase_getmember") val purchase_getMember: List<MemberBundle>,
    @SerializedName("coin_getmember") val coin_getMember: List<MemberBundle>,
    @SerializedName("daily_getmember") val daily_getMember: List<MemberBundle>,
    @SerializedName("purchase_hiddengetmember") val purchase_hiddengetmember: List<MemberBundle>

)

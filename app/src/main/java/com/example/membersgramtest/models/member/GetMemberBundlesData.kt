package com.example.membersgramtest.models.member

import com.google.gson.annotations.SerializedName

data class GetMemberBundlesData(
    @SerializedName("data") val `data`: List<GetMemberBundlesDataData>,


)

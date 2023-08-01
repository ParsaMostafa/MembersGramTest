package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.member.GetMemberBundlesResponse
import com.example.membersgramtest.models.member.MemberBundle
import com.example.membersgramtest.models.member.RvItemTypes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelMember : ViewModel() {
    val newsApi = RetrofitInstance.api
    private val _memberBundles = MutableStateFlow<List<RvItemTypes>>(emptyList())
    val memberBundles: StateFlow<List<RvItemTypes>> = _memberBundles
    init {
        fetchAndSetMemberBundles()
    }

    private fun fetchAndSetMemberBundles() = viewModelScope.launch {
        val response =
            newsApi.getMembers().body() // you need to implement this method in your API
        updateMemberBundles(response)
    }

    // this function is called when API response is received
    fun updateMemberBundles(response: GetMemberBundlesResponse?) {
        val rvItems = mutableListOf<RvItemTypes>()

        rvItems.add(RvItemTypes.HeaderModel)
        response?.data?.data?.forEach { data ->
            val purchaseGetMemberSize = data.purchase_getMember.size
            val coingetmemberSize = data.coin_getMember.size
            Log.d("MemberBundleSize", "Size of PurchaseGetMember: $purchaseGetMemberSize")
            Log.d("CoinBundleSize", "Size of CoinGetMember: $coingetmemberSize")


            data.purchase_getMember.forEach { memberBundle ->
                Log.d("MemberBundle", "MemberBundle Data: $memberBundle")
                rvItems.add(transformMemberBundleToRvItem(memberBundle))
            }


             data.coin_getMember.forEach { memberBundle ->
                 Log.d("MemberBundle", "MemberBundle Data: $memberBundle")
                rvItems.add(transformMemberBundleToRvItem(memberBundle))
            }



        }

        rvItems.add(RvItemTypes.FooterModel)

        _memberBundles.value = rvItems
    }

    private fun transformMemberBundleToRvItem(memberBundle: MemberBundle): RvItemTypes {
        return RvItemTypes.Apiresponse(
            Id = memberBundle.Id,
            by_coin = memberBundle.by_coin,
            coin = memberBundle.coin,
            onvan = memberBundle.onvan,
            discountString = memberBundle.discountString,
            market = memberBundle.market,
            member_count = memberBundle.member_count,
            discount_member_count = memberBundle.discount_member_count,
            price = memberBundle.price,
            discount = memberBundle.discount,
            sku = memberBundle?.sku,
            type = memberBundle.type,
            image = memberBundle.image,
            image_l_fa = memberBundle.image_l_fa,
            image_d_fa = memberBundle.image_d_fa,
            image_l_en = memberBundle.image_l_en,
            image_d_en = memberBundle.image_d_en,
            animationMode = memberBundle.animationMode,
            isHidden = memberBundle.isHidden,
            daily = memberBundle.daily,
            dayCount = memberBundle.dayCount
        )
    }
}
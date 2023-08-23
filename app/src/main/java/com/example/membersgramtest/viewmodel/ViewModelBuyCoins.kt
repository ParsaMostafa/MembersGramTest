package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.getcoins.GetCoins
import com.example.membersgramtest.models.getcoins.RVBuyCoin
import com.example.membersgramtest.models.memberresponse.RV1Member
import com.example.membersgramtest.models.memberresponse.RV2MEMBER
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelBuyCoins : ViewModel() {
    val Apicalls = RetrofitInstance.api

    val _RVCoin = MutableStateFlow<List<RVBuyCoin>>(emptyList())
    val RVCoin: StateFlow<List<RVBuyCoin>> = _RVCoin




    init {
        getHeaderItems()

    }

    private fun getHeaderItems() {
        viewModelScope.launch {
            try {

                val response = Apicalls.getCoins()
                Log.d("getCoins", "$response")
                if (response.isSuccessful) {
                    Log.d("getCoins1", "${response.body()}")
                    headerResponse(response.body())
                } else {
                    Log.e("getCoins", "API call failed with code: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("getCoins", "Exception: ${e.message}")
            }
        }
    }

    private fun headerResponse(body: GetCoins?) {
        val RvHeader = mutableListOf<RVBuyCoin>()

        body?.data?.data?.forEach {
            RvHeader.add(
                RVBuyCoin.HeaderModel(
                    Id = it.Id,
                    __v = it.__v,
                    _id = it._id,
                    background = it.background,
                    coincount = it.coincount,
                    darsad = it.darsad,
                    date = it.date,
                    description = it.description,
                    discount = it.discount,
                    discount_coin = it.discount_coin,
                    discount_image = it.discount_image,
                    disprice = it.disprice,
                    hour = it.hour,
                    id = it.id,
                    image = it.image,
                    is_active = it.is_active,
                    market = it.market,
                    onvan = it.onvan,
                    price = it.price,
                    promotion_counter = it.promotion_counter,
                    remain_time = it.remain_time,
                    sku = it.sku,
                    title_image = it.title_image,
                    type = it.type
                )
            )

            // Add a title between HeaderModel and BodyModel
            RvHeader.add(RVBuyCoin.Title("Normal Package"))

            // You can also add BodyModel here
            RvHeader.add(
                RVBuyCoin.BodyModel(
                    Id = it.Id,
                    __v = it.__v,
                    _id = it._id,
                    background = it.background,
                    coincount = it.coincount,
                    darsad = it.darsad,
                    date = it.date,
                    description = it.description,
                    discount = it.discount,
                    discount_coin = it.discount_coin,
                    discount_image = it.discount_image,
                    disprice = it.disprice,
                    hour = it.hour,
                    id = it.id,
                    image = it.image,
                    is_active = it.is_active,
                    market = it.market,
                    onvan = it.onvan,
                    price = it.price,
                    promotion_counter = it.promotion_counter,
                    remain_time = it.remain_time,
                    sku = it.sku,
                    title_image = it.title_image,
                    type = it.type
                )
            )
        }

        _RVCoin.value = RvHeader
    }


}
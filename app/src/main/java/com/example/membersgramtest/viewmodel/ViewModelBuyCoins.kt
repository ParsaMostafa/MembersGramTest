package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.getcoins.RVBuyCoin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModelBuyCoins : ViewModel() {
    private val apicalls = RetrofitInstance.api

    val Items = MutableStateFlow<List<RVBuyCoin>>(emptyList())

    init {
        getHeaderItems()


    }


    private fun getHeaderItems() {
        viewModelScope.launch {
            try {
                val response = apicalls.getCoins().body()?.data?.data
                Log.d("ViewModelBuyCoinsR", "Body List: $response")

                val headerList = response?.filter { it.type == "daily"  }
                val bodyList = response?.filter { it.type == "normal" }

                val Header = headerList?.map { RVBuyCoin.HeaderModel(it.Id, it.__v, it._id, it.background, it.coincount, it.darsad, it.date, it.description, it.discount, it.discount_coin, it.discount_image, it.disprice, it.hour, it.id, it.image, it.is_active, it.market, it.onvan, it.price, it.promotion_counter, it.remain_time, it.sku, it.title_image, it.type)}

                val body = bodyList?.map { RVBuyCoin.BodyModel(it.Id, it.__v, it._id, it.background, it.coincount, it.darsad, it.date, it.description, it.discount, it.discount_coin, it.discount_image, it.disprice, it.hour, it.id, it.image, it.is_active, it.market, it.onvan, it.price, it.promotion_counter, it.remain_time, it.sku, it.title_image, it.type) }

                Log.d("ViewModelBuyCoinsH", "Header List: $Header")
                Log.d("ViewModelBuyCoinsB", "Body List: $body")


                val combinedList = mutableListOf<RVBuyCoin>()
                if (headerList != null) {
                    if (Header != null) {
                        combinedList.addAll(Header)
                    }
                }
                combinedList.add(RVBuyCoin.Title("Normal package"))

                if (bodyList != null) {
                    if (body != null) {
                        combinedList.addAll(body)
                    }
                }

                Items.emit(combinedList)
            } catch (e: Exception) {
                // Handle the exception
            }
        }
    }
}

package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.memberview.Getview
import com.example.membersgramtest.models.memberview.Rv1Model
import com.example.membersgramtest.models.memberview.Rv2model
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelViewTab : ViewModel() {
    val newsApi = RetrofitInstance.api



      val _RV1objects = MutableStateFlow<List<Rv1Model>>(emptyList())
      val RV1objects: StateFlow<List<Rv1Model>> = _RV1objects


      val _RV2objects = MutableStateFlow<List<Rv2model>>(emptyList())
      val RV2objects: StateFlow<List<Rv2model>> = _RV2objects


    init {
        SetViews()
    }

    private fun SetViews() = viewModelScope.launch {
        val response = newsApi.getViews()
        if (response.isSuccessful) {
            Log.d("ViewmodelMain", "Received response: ${response.body()}")
            rv1Response(response.body())

        } else {
            Log.e("ResponseError", "Error: ${response.code()}")
        }
    }


    private fun rv1Response(response: Getview?) {
        val rv1ModelItems = mutableListOf<Rv1Model>()


        response?.data?.data?.forEach {
            val countPost = it.count_post
            Log.d("GetViewSize", "Size of Posts: $countPost")

            rv1ModelItems.add(Rv1Model.Rv1BodyModel(

                count_post = it.count_post

            ))
        }

        _RV1objects.value = rv1ModelItems
    }


    //Recylerview2 fnictions

    fun filterDataX(count_post: Int) = viewModelScope.launch {
        val response = newsApi.getViews() // Replace with your actual API call
        if (response.isSuccessful) {
            Log.d("ViewModelViewTab", "Received response: ${response.body()}")
            rv2Response(response.body(), count_post)
        } else {
            Log.e("ResponseError", "Error: ${response.code()}")
        }
    }

    private fun rv2Response(response: Getview?, count_post: Int) {
        val rv2ModelItems = mutableListOf<Rv2model>()




        rv2ModelItems.add(Rv2model.Rv2HeaderModel)

        response?.data?.data?.filter { it.count_post == count_post }?.forEach { dataX ->
            dataX.coin.forEach { coin ->
                rv2ModelItems.add(Rv2model.Rv2BodyModel(
                    Id = coin.Id,
                    __v = coin.__v,
                    _id = coin._id,
                    animationMode = coin.animationMode,
                    by_coin = coin.by_coin,
                    coin = coin.coin,
                    count_post = coin.count_post,
                    discount = coin.discount,
                    discountString = coin.discountString,
                    discount_view_count = coin.discount_view_count,
                    id = coin.id,
                    image = coin.image,
                    image_view = coin.image_view?: "",
                    is_active = coin.is_active,
                    market = coin.market,
                    onvan = coin.onvan,
                    price = coin.price,
                    shop_type = coin.shop_type,
                    sku = coin.sku,
                    type = coin.type,
                    view_count = coin.view_count,
                    view_count_real = coin.view_count_real
                ))
            }

            dataX.purchase.forEach { purchase ->
                rv2ModelItems.add(Rv2model.Rv2BodyModel(
                    Id = purchase.Id,
                    __v = purchase.__v,
                    _id = purchase._id,
                    animationMode = purchase.animationMode,
                    by_coin = purchase.by_coin,
                    coin = purchase.coin,
                    count_post = purchase.count_post,
                    discount = purchase.discount,
                    discountString = purchase.discountString,
                    discount_view_count = purchase.discount_view_count,
                    id = purchase.id,
                    image = purchase.image,
                    image_view = purchase.image_view,
                    is_active = purchase.is_active,
                    market = purchase.market,
                    onvan = purchase.onvan,
                    price = purchase.price,
                    shop_type = purchase.shop_type,
                    sku = purchase.sku,
                    type = purchase.type,
                    view_count = purchase.view_count,
                    view_count_real = purchase.view_count_real
                ))
            }
        }

        _RV2objects.value = rv2ModelItems
    }


}














package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.member.RvItemTypes
import com.example.membersgramtest.models.v1.MyRequest
import com.example.membersgramtest.models.v1.MyResponse
import com.example.membersgramtest.models.v2.VerifyRegisterRequest
import com.example.membersgramtest.models.v2.VerifyRegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Response

class VeryfiViewModel() : ViewModel() {
    val newsApi = RetrofitInstance.api

    fun verifyPhoneNumber(phoneNumber: String, verificationCode: Int): Flow<Response<VerifyRegisterResponse>> = flow {
        val request = VerifyRegisterRequest(VerifyRegisterRequest.Data(phoneNumber, verificationCode))
        val response = newsApi.verifyRegister(request)
        emit(response)
    }.flowOn(Dispatchers.IO)

    fun PhoneNumberv1( phonenumber: String,
                       market: String  ,
                       tg_id: Int
    ): Flow<Response<MyResponse>> = flow {
        val request = MyRequest(MyRequest.RequestData(phonenumber,market,tg_id))
        val response = newsApi.register(request)
        emit(response)
    }.flowOn(Dispatchers.IO)


    //ResponseApiCall
    val listflow  = MutableStateFlow<List<RvItemTypes>>(emptyList())

    init {
        getApiResponseFlow()
    }

    fun getApiResponseFlow() {
        viewModelScope.launch {
            val response = newsApi.getMembers()
            Log.d("VeryfiViewModel", "API response: $response")
            if (response.isSuccessful) {
                val apiresponedata = response.body()?.data?.data
                Log.d("VeryfiViewModel", "API response data: $apiresponedata") // Added logging here
                val list = mutableListOf<RvItemTypes>()
                list.add(RvItemTypes.HeaderModel)
                apiresponedata?.forEach {
                    list.add(
                        RvItemTypes.Apiresponse(
                            Id = it.Id ,
                            by_coin = it.by_coin,
                            coin = it.coin,
                            onvan = it.onvan,
                            discountString = it.discountString,
                            market = it.market,
                            member_count = it.member_count,
                            discount_member_count = it.discount_member_count,
                            price = it.price,
                            discount = it.discount,
                            sku = it.sku,
                            type = it.image,
                            image = it.image,
                            image_l_fa = it.image_l_fa,
                            image_d_fa = it.image_d_fa,
                            image_l_en = it.image_l_en,
                            image_d_en = it.image_d_en,
                            animationMode = it.animationMode,
                            isHidden = it.isHidden,
                            daily = it.daily ,
                            dayCount = it.dayCount
                        )
                    )
                }
                list.add(RvItemTypes.FooterModel)
                listflow.emit(list)
            } else {
                Log.e("1408", "API Error: ${response.message()}")
                // Handle API error if needed
            }
        }
    }
}

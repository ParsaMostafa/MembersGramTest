package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.member.MemberBundle
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




}
package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import kotlinx.coroutines.launch

class PaymentViemodel :ViewModel() {
     val Api = RetrofitInstance.api

    init {

              testLogtransaction()


    }


    private fun testLogtransaction() {
        viewModelScope.launch {
            val respoonse = Api.UserTransActions().body()

            Log.d("CyberWolf", respoonse.toString())
        }

    }


}
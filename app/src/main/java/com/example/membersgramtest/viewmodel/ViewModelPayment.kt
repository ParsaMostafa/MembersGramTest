package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.Transaction.Doc
import com.example.membersgramtest.models.Transaction.TransactionResponse
import com.example.membersgramtest.paging.TransactionPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModelPayment : ViewModel () {
    val api = RetrofitInstance.api


    // StateFlow to hold the response data
    val transactionResponse = MutableStateFlow<TransactionResponse?>(null)



    init {

        testLogTransaction()
    }

    private fun testLogTransaction() {
        viewModelScope.launch {
            try {
                val response = api.UserTransActions().body()?.data?.data
                Log.d("CyberWolfl490" , response.toString())

                // Update the LiveData with the response data
//                transactionResponse.emit(response)
            } catch (e: Exception) {
                Log.e("CyberWolfl490", "", e )
                // Handle any exceptions or errors here

            }
        }
    }


    //PagingTransaction



    fun getTransactionResponseFlow(): Flow<PagingData<Doc>> {
        val pagingConfig = PagingConfig(
            pageSize = 20,
            prefetchDistance = 1,
            enablePlaceholders = false
        )

        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { TransactionPagingSource(api) }
        ).flow
    }
}
package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.Transaction.ChipsModel
import com.example.membersgramtest.models.Transaction.Doc
import com.example.membersgramtest.models.Transaction.TransactionResponse
import com.example.membersgramtest.paging.TransactionPagingSource
import com.example.membersgramtest.utillity.Consts.DEFAULT_QUERY
import com.example.membersgramtest.utillity.Consts.MEMBER_QUERY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
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
                val response = api.UserTransActions(1 , MEMBER_QUERY ).body()?.data?.data?.pages
                Log.d("Mostafa" , response.toString())

                // Update the LiveData with the response data
              // transactionResponse.emit(response)
            } catch (e: Exception) {
                Log.e("Mostafa", "", e )
                // Handle any exceptions or errors here

            }
        }
    }




    //PagingTransaction



    object QueryConstants {
        const val DEFAULT_QUERY = "all"
        const val MEMBER_QUERY = "member"
        const val COIN_QUERY = "coin"
        const val VIEW_QUERY = "view"
    }

    val FlowChipsList = MutableStateFlow(
        listOf(
            ChipsModel(QueryConstants.DEFAULT_QUERY),
            ChipsModel(QueryConstants.MEMBER_QUERY),
            ChipsModel(QueryConstants.COIN_QUERY),
            ChipsModel(QueryConstants.VIEW_QUERY)
        )
    )



    val flowCurrentQuarry = MutableStateFlow(DEFAULT_QUERY)

    val list = flowCurrentQuarry.flatMapLatest { query ->
        val pagingConfig = PagingConfig(
            pageSize = 20,
            prefetchDistance = 1,
            enablePlaceholders = false
        )

        Pager(
            config = pagingConfig,
            pagingSourceFactory = { TransactionPagingSource(api, query) }
        ).flow
    }





}
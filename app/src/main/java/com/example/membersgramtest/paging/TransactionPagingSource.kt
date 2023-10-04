package com.example.membersgramtest.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.membersgramtest.api.ApiCalls
import com.example.membersgramtest.models.Transaction.Doc
import retrofit2.HttpException
import java.io.IOException

class TransactionPagingSource(
    private val api: ApiCalls,
    private val status: String
) : PagingSource<Int, Doc>() {

    override fun getRefreshKey(state: PagingState<Int, Doc>): Int? {
        // You can implement this if needed
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Doc> {
        val currentPage = params.key ?: 1

        try {
            val response = api.UserTransActions(currentPage, status)
            if (response.isSuccessful) {
                val data = response.body()?.data?.data?.docs ?: emptyList()
                Log.d("Paging", "class TransactionPagingSource: ${data.toString()}")
                return LoadResult.Page(
                    data = data,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (data.isEmpty()) null else currentPage + 1
                )
            } else {
                return LoadResult.Error(Exception("خطا در بارگیری داده"))
            }
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}

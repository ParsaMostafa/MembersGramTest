package com.example.membersgramtest.paging
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.membersgramtest.api.ApiCalls
import com.example.membersgramtest.models.Transaction.Doc
import retrofit2.HttpException
import java.io.IOException

class TransactionPagingSource(
    private val api: ApiCalls
) : PagingSource<Int, Doc>() {

    override fun getRefreshKey(state: PagingState<Int, Doc>): Int? {

        // پیاده سازی در صورت نیاز

        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Doc> {
        val pageNumber = params.key ?: 1

        try {
            val response = api.UserTransActions()
            if (response.isSuccessful) {
                val data = response.body()?.data?.data?.docs ?: emptyList()
                Log.d("CyberPaging" , data.toString())
                return LoadResult.Page(
                    data = data,
                    prevKey = if (pageNumber == 1) null else pageNumber - 1,
                    nextKey = if (data.isEmpty()) null else pageNumber + 1
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

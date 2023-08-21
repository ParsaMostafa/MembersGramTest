import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.ViewTabModel.Getview
import com.example.membersgramtest.models.ViewTabModel.Rv2model
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelViewTab : ViewModel() {
    val newsApi = RetrofitInstance.api

    private val rv1LogTag = "RV1_LOG"
    private val rv2LogTag = "RV2_LOG"

    val _RV1objects = MutableStateFlow<List<Rv1Model>>(emptyList())
    val RV1objects: StateFlow<List<Rv1Model>> = _RV1objects

    val _RV2objects = MutableStateFlow<List<Rv2model>>(emptyList())
    val RV2objects: StateFlow<List<Rv2model>> = _RV2objects

    // Property to store the count_post value of the default item
    private val defaultCountPost = 1

    init {
        SetViews()
        // Simulate click on the default button (count_post == 1) for RV1
        filterDataX(defaultCountPost)
    }
    private fun SetViews() =
        viewModelScope.launch {
            val response = newsApi.getViews()
            if (response.isSuccessful) {
                Log.d(rv1LogTag, "Received response: ${response.body()}")
                rv1Response(response.body())

            } else {
                Log.e("ResponseError", "Error: ${response.code()}")
            }
        }

    private fun rv1Response(response: Getview?) {
        val rv1ModelItems = mutableListOf<Rv1Model>()

        response?.data?.data?.forEach {
            val countPost = it.count_post
            Log.d(rv1LogTag, "Size of Posts: $countPost")

            rv1ModelItems.add(Rv1Model.Rv1BodyModel(
                count_post = it.count_post
            ))
        }

        _RV1objects.value = rv1ModelItems
    }

    // Recyclerview2 functions

    fun filterDataX(count_post: Int) =
        viewModelScope.launch {
            val response = newsApi.getViews() // Replace with your actual API call
            if (response.isSuccessful) {
                rv2Response(response.body(), count_post)
            } else {
                Log.e("ResponseError", "Error: ${response.code()}")
            }
        }

    private fun rv2Response(response: Getview?, count_post: Int) {
        val rv2ModelItems = mutableListOf<Rv2model>()

        rv2ModelItems.add(Rv2model.Rv2HeaderModel("Order view"))

        response?.data?.data?.filter { it.count_post == count_post }?.forEach { dataX ->
            Log.d(rv2LogTag, "Filtering data for count_post: $count_post")

            dataX.purchase.forEach { purchase ->
                Log.d(rv2LogTag, "Processing purchase: ${purchase.by_coin}")

                rv2ModelItems.add(
                    Rv2model.Rv2BodyModel(
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
                    )
                )
            }

            rv2ModelItems.add(Rv2model.Rv2HeaderModel("Order with coin "))

            dataX.coin.forEach { coin ->
                Log.d(rv2LogTag, "Processing coin: ${coin.by_coin}")

                rv2ModelItems.add(
                    Rv2model.Rv2BodyModel(
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
                        image_view = coin.image_view,
                        is_active = coin.is_active,
                        market = coin.market,
                        onvan =coin.onvan,
                        price = coin.price,
                        shop_type = coin.shop_type,
                        sku = coin.sku,
                        type = coin.type,
                        view_count = coin.view_count,
                        view_count_real = coin.view_count_real
                    )
                )
            }
        }

        _RV2objects.value = rv2ModelItems
    }

}

package com.example.membersgramtest.adaptor

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.R
import com.example.membersgramtest.models.getcoins.RVBuyCoin
import com.example.membersgramtest.ui.layout.ItemBodyBuyCoin
import com.example.membersgramtest.ui.layout.ItemHeaderBuyCoin
import com.example.membersgramtest.ui.layout.Rv2Headeritem
import com.example.membersgramtest.utillity.CryptUtil
import org.json.JSONObject


const val headercoin_viewtype = 0
const val bodycoin_viewtype = 1
const val title_viewtype = 2
class AdaptorBuyCoin :   ListAdapter<RVBuyCoin, RecyclerView.ViewHolder>(AdaptorBuyCoin.MyDiffCallback()){


    inner class HeaderBuyCoinViewHolder(val itemHeaderBuyCoin: ItemHeaderBuyCoin) :
        RecyclerView.ViewHolder(itemHeaderBuyCoin) {

        private var countDownTimer: CountDownTimer? = null

        fun bind(header: RVBuyCoin.HeaderModel) {
            // Update your header view based on the model
            Glide.with(MyApp.appContext)
                .load(header.image)
                .placeholder(R.drawable.person_bue_24dp__2_) // Placeholder image resource
                .error(R.drawable.icons8_globe_showing_europe_africa_1) // Error image resource
                .into(itemHeaderBuyCoin.imageView)

            // محاسبه زمان باقی‌مانده
            val currentTime = System.currentTimeMillis()
            val endTime = header.remain_time

            // شروع محاسبات باقی‌مانده
            countDownTimer?.cancel() // اگر تایمر قبلی وجود دارد، لغو شود
            if (endTime != null) {
                countDownTimer = object : CountDownTimer(endTime.toLong(), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        val remainingTime = millisUntilFinished / 1000
                        val hours = remainingTime / 3600
                        val minutes = (remainingTime % 3600) / 60
                        val seconds = remainingTime % 60

                        val remainingTimeString = String.format("%02d : %02d : %02d", hours, minutes, seconds)
                        itemHeaderBuyCoin.textviewtime.text = remainingTimeString
                    }

                    override fun onFinish() {
                        itemHeaderBuyCoin.textviewtime.text = "Expired" // یا مقدار دلخواه دیگر
                    }
                }.start()
            }



            itemHeaderBuyCoin.textviewcoin.text = "${header.coincount} Coins"

            itemHeaderBuyCoin.backColor = Color.parseColor("${header.background}")

            itemHeaderBuyCoin.todayText.text = header.onvan

            itemHeaderBuyCoin.textviewtime.text = header.date

            itemHeaderBuyCoin.button.text =   "${header.price } $"

            // Calculate original price before discount
            fun calculateOriginalPrice(price: Int, discount: Float): Float {
                return price * 100 / discount
            }

            val originalPrice = header?.price?.let { calculateOriginalPrice(it, header.discount) }

            if (header.discount == 0f || header.discount == null) {
                itemHeaderBuyCoin.textviewdiscountprice.visibility = View.GONE
            }
            itemHeaderBuyCoin.textviewdiscountprice.text = originalPrice.toString()




            itemHeaderBuyCoin.button.setOnClickListener {
                Log.d("Myddd", "Button clicked")
                orderCoinHeaderWithProvidedData("https://api.membersgram.com/api/v2/zarinpal/coin/gateway?data=", MyApp.appContext,header)
            }

        }









    }

    private fun orderCoinHeaderWithProvidedData(
        s: String, appContext: Context,
        header: RVBuyCoin.HeaderModel
    ) {
        val versionCode = 30180
        val packageName = "com.example.membersgramtest"

        val jsonData = mapOf(
            "coin" to header.coincount,
            "price" to header.price,
            "sku" to header.sku,
            "phonenumber" to "989373449122",
            "market" to "zarinpal",
            "lan" to "EN",
            "versionc" to versionCode.toString(),
            "packageName" to  packageName,
            "_id" to header._id

        )
        Log.d("jasondata", "Opening URL: $jsonData")
        val context = MyApp.appContext
        val encryptedData = CryptUtil.encrypt(JSONObject(jsonData).toString())
        Log.d("MyCoinbuy", "Opening URL: $s$encryptedData")
        // Add the FLAG_ACTIVITY_NEW_TASK flag here
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("$s$encryptedData")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        appContext.startActivity(intent)
    }




    inner class BodyBuyCoinViewHolder(val itemBodyBuyCoin: ItemBodyBuyCoin) :
        RecyclerView.ViewHolder(itemBodyBuyCoin) {


        fun bind(header: RVBuyCoin.BodyModel) {
            // Update your header view based on the model
            Glide.with(MyApp.appContext)
                .load(header.image)
                .placeholder(R.drawable.person_bue_24dp__2_) // Placeholder image resource
                .error(R.drawable.icons8_globe_showing_europe_africa_1) // Error image resource
                .into(itemBodyBuyCoin.imageView)


            itemBodyBuyCoin.button.text = "${header.price }$"

            itemBodyBuyCoin.textCoin.text = "${header.coincount } Coins"

            if (header.onvan == null || header.onvan == ""  ){
                itemBodyBuyCoin.discountStringCoin.visibility = View.INVISIBLE
            }
            itemBodyBuyCoin.discountStringCoin.text = header.onvan.toString()




            itemBodyBuyCoin.button.setOnClickListener {
                Log.d("MyCoinbuy", "Button clicked")
                orderCoinBodyWithProvidedData("https://api.membersgram.com/api/v2/zarinpal/coin/gateway?data=", MyApp.appContext,header)
            }
        }
    }


    private fun orderCoinBodyWithProvidedData(
        s: String, appContext: Context,
        header: RVBuyCoin.BodyModel
    ) {
        val versionCode = 30180
        val packageName = "com.example.membersgramtest"

        val jsonData = mapOf(
            "coin" to header.coincount,
            "price" to header.price,
            "sku" to header.sku,
            "phonenumber" to "989373449122",
            "market" to "zarinpal",
            "lan" to "EN",
            "versionc" to versionCode.toString(),
            "packageName" to  packageName,
            "_id" to header._id

        )
        Log.d("jasondata", "Opening URL: $jsonData")
        val context = MyApp.appContext
        val encryptedData = CryptUtil.encrypt(JSONObject(jsonData).toString())
        Log.d("MyCoinbuy", "Opening URL: $s$encryptedData")
        // Add the FLAG_ACTIVITY_NEW_TASK flag here
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("$s$encryptedData")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        appContext.startActivity(intent)
    }


    inner class TitleBuyCoinViewHolder(val rv2Headeritem: Rv2Headeritem) :
        RecyclerView.ViewHolder(rv2Headeritem) {

        fun bind(header: RVBuyCoin.Title) {
            // Update your header view based on the model
            rv2Headeritem.textView.text = header.title
        }
    }



    class MyDiffCallback : DiffUtil.ItemCallback<RVBuyCoin>() {
        override fun areItemsTheSame(oldItem: RVBuyCoin, newItem: RVBuyCoin): Boolean {
            return when {
                oldItem is RVBuyCoin.BodyModel && newItem is RVBuyCoin.BodyModel ->
                    oldItem.Id == newItem.Id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: RVBuyCoin, newItem: RVBuyCoin): Boolean {
            return oldItem == newItem
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is RVBuyCoin.HeaderModel -> headercoin_viewtype
            is RVBuyCoin.BodyModel -> bodycoin_viewtype
            is RVBuyCoin.Title -> title_viewtype
        }
    }







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            headercoin_viewtype -> {
                val itemheaderbuycoin = ItemHeaderBuyCoin(parent.context)
               HeaderBuyCoinViewHolder(itemheaderbuycoin)
            }
            bodycoin_viewtype -> {
                val itemBodyBuyCoin = ItemBodyBuyCoin(parent.context)
                BodyBuyCoinViewHolder(itemBodyBuyCoin)
            }
            title_viewtype -> {
                val rv2Headeritem = Rv2Headeritem(parent.context)
                TitleBuyCoinViewHolder(rv2Headeritem)

            }
            else -> throw IllegalArgumentException("Invalid view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is AdaptorBuyCoin.HeaderBuyCoinViewHolder -> {
                val header = item as RVBuyCoin.HeaderModel
                holder.bind(header)
            }
            is AdaptorBuyCoin.BodyBuyCoinViewHolder -> {
                val body = item as RVBuyCoin.BodyModel
                holder.bind(body)
            }
            is AdaptorBuyCoin.TitleBuyCoinViewHolder -> {
                val title = item as RVBuyCoin.Title
                holder.bind(title)
            }
        }
    }
}
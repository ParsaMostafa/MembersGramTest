package com.example.membersgramtest.adaptor

import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.models.ViewTabModel.Rv2model
import com.example.membersgramtest.ui.layout.Rv2Bodyitem
import com.example.membersgramtest.ui.layout.Rv2Headeritem

const val headerrv2_viewtype = 0
const val bodyrv2_viewtype = 1

class AdaptorRv2 :   ListAdapter<Rv2model, RecyclerView.ViewHolder>(MyDiffCallback()) {

    inner class HeaderRv2ViewHolder(val rv2Headeritem: Rv2Headeritem) :
        RecyclerView.ViewHolder(rv2Headeritem) {
        fun bind(header: Rv2model.Rv2HeaderModel) {
            // Update your header view based on the model
            rv2Headeritem.textView.text = header.title
        }
    }

    inner class BodyRv2ViewHolder(val rv2Bodyitem: Rv2Bodyitem) : RecyclerView.ViewHolder(rv2Bodyitem) {


        fun bindBodyRv2(rv2Model: Rv2model.Rv2BodyModel) {
            Log.d("BodyRv2ViewHolder", "Binding data for item: ${rv2Model.Id}")
            // Check if not by coin and set price or coin information
            val isNotByCoin = !rv2Model.by_coin
            // Hide pricewithoutdiscount if by_coin is true
            rv2Bodyitem.pricewithoutdiscount.visibility = if (rv2Model.by_coin) View.GONE else View.VISIBLE
            if (rv2Model.by_coin){
                rv2Bodyitem.showPriceInsteadOfCoin = false
                rv2Bodyitem.showDiscountprice = false
                rv2Bodyitem.dollar.visibility = View.INVISIBLE
                rv2Bodyitem.discountviewcount.visibility = View.INVISIBLE
            } else {
                rv2Bodyitem.showPriceInsteadOfCoin = true
                rv2Bodyitem.showDiscountprice = true
                rv2Bodyitem.dollar.visibility = View.VISIBLE
                rv2Bodyitem.discountviewcount.visibility = View.INVISIBLE
            }




            rv2Bodyitem.textview2.visibility =
                if (rv2Model.discount == 0.0f && (rv2Model.onvan != null || rv2Model.onvan != ""))
                    View.VISIBLE
                else
                    View.GONE
            rv2Bodyitem.pricewithoutdiscountvisibility = false
            rv2Bodyitem.textview2.text = rv2Model.onvan
            if (rv2Model.by_coin && rv2Model.discount == 0.0f  &&(rv2Model.onvan == null || rv2Model.onvan == "") ){

                rv2Bodyitem.showPriceInsteadOfCoin = false
                rv2Bodyitem.dollarCondition = true
                rv2Bodyitem.noDiscountatall = true
                rv2Bodyitem.showDiscountprice = false
                rv2Bodyitem.dollar.visibility = View.INVISIBLE
            } else if (!rv2Model.by_coin && rv2Model.discount == 0.0f  &&(rv2Model.onvan == null || rv2Model.onvan == "")) {
                rv2Bodyitem.showPriceInsteadOfCoin = true
                 rv2Bodyitem.coiniCondition = true
                rv2Bodyitem.noDiscountatall = true
                rv2Bodyitem.showDiscountprice = true
                rv2Bodyitem.dollar.visibility = View.VISIBLE
            }




            rv2Bodyitem.imageViewCoin.visibility = if (isNotByCoin) View.GONE else View.VISIBLE

            rv2Bodyitem.textView3.text = if (isNotByCoin) rv2Model.price.toString() else rv2Model.coin.toString()
            rv2Bodyitem.textView.text = rv2Model.view_count.toString()
            // Load image using Glide
            Glide.with(MyApp.appContext).load(rv2Model.image).into(rv2Bodyitem.imageviewfire)

            // Set discount text
            rv2Bodyitem.discountviewcount.text = rv2Model.discountString

            // Calculate original price before discount
            fun calculateOriginalPrice(price: Int, discount: Float): Float {
                return price * 100 / discount
            }

            // Check discount conditions
            val isDiscountZero = rv2Model.discount == 0.0f


            val isCoinDiscount = rv2Model.discount != null && rv2Model.discount != 0.0f  && rv2Model.by_coin
                    && !rv2Bodyitem.showDiscountprice && !rv2Bodyitem.pricewithoutdiscountvisibility &&
                    !rv2Bodyitem.showPriceInsteadOfCoin


            val isPurchaseDiscount = rv2Model.discount != null && rv2Model.discount != 0.0f
                    && !rv2Model.by_coin && rv2Bodyitem.showDiscountprice  && rv2Bodyitem.pricewithoutdiscountvisibility
                    && rv2Bodyitem.showPriceInsteadOfCoin

            // Set discount string and visibility
            rv2Bodyitem.dicountstringCoin.text = rv2Model.discountString
            Log.d("BodyRv2ViewHolder", "Discount string: ${rv2Model.discountString}")

            // Handle different discount cases
            when {
                isDiscountZero -> {

                    rv2Bodyitem.dicountstringCoin.visibility = View.INVISIBLE
                    rv2Bodyitem.textview2.text = rv2Model.onvan
                    rv2Bodyitem.pricewithoutdiscount.visibility = View.GONE
                }
                isPurchaseDiscount -> {
                    val originalPrice = calculateOriginalPrice(rv2Model.price, rv2Model.discount)
                    rv2Bodyitem.pricewithoutdiscount.text = originalPrice.toString()

                    rv2Bodyitem.textview2.visibility = View.GONE
                }
                isCoinDiscount -> {

                    rv2Bodyitem.textview2.visibility = View.GONE
                }
            }

            // Set button background color based on type
            when (rv2Model.type) {
                "normal" -> {
                    rv2Bodyitem.button.setBackgroundColor(Color.WHITE)
                    rv2Bodyitem.button.setTextColor(Color.parseColor("#1976D2"))
                }
                "special" -> {
                    rv2Bodyitem.button.setBackgroundColor(Color.BLUE)
                }
            }


        }


    }

    class MyDiffCallback : DiffUtil.ItemCallback<Rv2model>() {
        override fun areItemsTheSame(oldItem: Rv2model, newItem: Rv2model): Boolean {
            return when {
                oldItem is Rv2model.Rv2BodyModel && newItem is Rv2model.Rv2BodyModel ->
                    oldItem.Id == newItem.Id
                oldItem is Rv2model.Rv2HeaderModel && newItem is Rv2model.Rv2HeaderModel ->
                    oldItem.title == newItem.title  // comparing based on header title
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: Rv2model, newItem: Rv2model): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (val item = getItem(position)) {
            is Rv2model.Rv2HeaderModel -> headerrv2_viewtype
            is Rv2model.Rv2BodyModel -> bodyrv2_viewtype
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            headerrv2_viewtype -> {
                val rv2Headeritem = Rv2Headeritem(parent.context)
                HeaderRv2ViewHolder(rv2Headeritem)
            }
            bodyrv2_viewtype -> {
                val rv2Bodyitem = Rv2Bodyitem(parent.context)
                BodyRv2ViewHolder(rv2Bodyitem)
            }
            else -> throw IllegalArgumentException("Invalid view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is HeaderRv2ViewHolder -> {
                val header = item as Rv2model.Rv2HeaderModel
                holder.bind(header)
            }
            is BodyRv2ViewHolder -> {
                val bodyrv2 = item as Rv2model.Rv2BodyModel
                holder.bindBodyRv2(bodyrv2)
            }
        }
    }
}

package com.example.membersgramtest.adaptor

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.models.memberresponse.RV2MEMBER
import com.example.membersgramtest.ui.layout.ItemMemberinorder2
import com.example.membersgramtest.ui.layout.ItemMemberinorder3
import com.example.membersgramtest.ui.layout.Rv2Headeritem


const val headerrv2mem_viewtype = 0
const val bodyrv2mem_viewtype = 1
const val footer_viewtype = 2

class AdaptorRv2member :ListAdapter<RV2MEMBER, RecyclerView.ViewHolder>(AdaptorRv2member.DiffMember())  {

    inner class HeaderAdaptorrv2member(val rv2Headeritem: Rv2Headeritem) :
        RecyclerView.ViewHolder(rv2Headeritem) {
        fun bind(header: RV2MEMBER.Rv2HeaderModel) {
            // Update your header view based on the model
            rv2Headeritem.textView.text = header.title
        }
    }

    inner class BodyRv2ViewHoldermem(val rv2Bodyitem: ItemMemberinorder2) : RecyclerView.ViewHolder(rv2Bodyitem) {


        fun bindBodyRv2(rv2Model: RV2MEMBER.Rv2BodyModel) {


            rv2Bodyitem.discounttext.text = rv2Model.discount_member_count.toString()

            if (rv2Model.discount_member_count == null || rv2Model.discount_member_count == 0){
                rv2Bodyitem.discounttext.visibility = View.INVISIBLE
            } else {
                rv2Bodyitem.discounttext.visibility = View.VISIBLE
            }



            // Check if rv2Model.by_coin is true
            if (rv2Model.by_coin) {
                rv2Bodyitem.coin = true

                rv2Bodyitem.whtitebuttun.setPadding(35, 0,0, 0)
            } else {
                rv2Bodyitem.coin = false
                rv2Bodyitem.whtitebuttun.setPadding(20, 0, 20, 0)
            }

            rv2Bodyitem.imageViewcoin.visibility = if (!rv2Model.by_coin) View.GONE else View.VISIBLE

            rv2Bodyitem.textView.text = rv2Model.member_count.toString()
            rv2Bodyitem.custom3.visibility = View.INVISIBLE
            if(rv2Model.discountString != null || rv2Model.discountString != ""){
                rv2Bodyitem.custom2.visibility = View.INVISIBLE

            }else{
                rv2Bodyitem.custom2.visibility = View.VISIBLE
                rv2Bodyitem.custom2.text = rv2Model.discountString
            }


            // Assuming rv2Bodyitem.imageview2 is an ImageView and rv2Model.image is a String?
            val imageUrl = rv2Model.image

            if (!imageUrl.isNullOrEmpty()) {

                Glide.with(MyApp.appContext)  // Pass in a valid Context
                    .load(imageUrl)
                    .into(rv2Bodyitem.imageview2)
            } else {
                rv2Bodyitem.imageview2.visibility = View.INVISIBLE
            }

            rv2Bodyitem.whtitebuttun.text = if (!rv2Model.by_coin)  "${rv2Model.price}$" else rv2Model.coin.toString()



            // Calculate original price before discount
            fun calculateOriginalPrice(price: Double, discount: Int): Double {
                return price * 100 / discount
            }




            // Handle different discount cases
            if ( rv2Model.discount == 0)
            {

                rv2Bodyitem.textview1.visibility = View.INVISIBLE


            } else(rv2Model.discount != null && rv2Model.discount != 0)
            {
                val originalPrice = calculateOriginalPrice(rv2Model.price, rv2Model.discount)
                rv2Bodyitem.textview1.text = originalPrice.toString()


            }




            // Set button background color based on type
            when (rv2Model.type) {
                "normal" -> {
                    rv2Bodyitem.whtitebuttun.setBackgroundColor(Color.WHITE)
                    rv2Bodyitem.whtitebuttun.setTextColor(Color.parseColor("#1976D2"))
                }
                "special" -> {
                    rv2Bodyitem.whtitebuttun.setBackgroundColor(Color.BLUE)
                }
            }









        }



    }



    inner class FooterViewHolder(val itemMemberinorder3: ItemMemberinorder3) :
        RecyclerView.ViewHolder(itemMemberinorder3) {


    }

    class DiffMember : DiffUtil.ItemCallback<RV2MEMBER>() {
        override fun areItemsTheSame(oldItem: RV2MEMBER, newItem: RV2MEMBER): Boolean {
            return when {
                oldItem is RV2MEMBER.Rv2BodyModel && newItem is RV2MEMBER.Rv2BodyModel ->
                    oldItem.Id == newItem.Id
                oldItem is RV2MEMBER.Rv2HeaderModel && newItem is RV2MEMBER.Rv2HeaderModel ->
                    oldItem.title == newItem.title  // comparing based on header title
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: RV2MEMBER, newItem: RV2MEMBER): Boolean {
            return oldItem == newItem
        }

    }


    override fun getItemViewType(position: Int): Int {
        return when (val item = getItem(position)) {
            is RV2MEMBER.Rv2HeaderModel -> headerrv2mem_viewtype
            is RV2MEMBER.Rv2BodyModel -> bodyrv2mem_viewtype
            is RV2MEMBER.FooterModel -> footer_viewtype
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            headerrv2mem_viewtype -> {
                val rv2Headeritem = Rv2Headeritem(parent.context)
                HeaderAdaptorrv2member(rv2Headeritem)
            }
            bodyrv2mem_viewtype -> {
                val rv2Bodyitem = ItemMemberinorder2(parent.context)
                BodyRv2ViewHoldermem(rv2Bodyitem)
            }
            footer_viewtype -> {
                val itemMemberinorder3 = ItemMemberinorder3(parent.context)
                FooterViewHolder(itemMemberinorder3)
            }

            else -> throw IllegalArgumentException("Invalid view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is AdaptorRv2member.HeaderAdaptorrv2member -> {
                val header = item as RV2MEMBER.Rv2HeaderModel
                holder.bind(header)
            }
            is AdaptorRv2member.BodyRv2ViewHoldermem -> {
                val bodyrv2 = item as RV2MEMBER.Rv2BodyModel
                holder.bindBodyRv2(bodyrv2)
            }
        }
    }


}
package com.example.membersgramtest.adaptor

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.models.member.RvItemTypes
import com.example.membersgramtest.ui.layout.ItemMemberinorder
import com.example.membersgramtest.ui.layout.ItemMemberinorder2
import com.example.membersgramtest.ui.layout.ItemMemberinorder3


const val header_viewtype = 0
const val apiresponse_viewtype = 1
const val footer_viewtype = 2

    class StoreAdaptor()    :   ListAdapter<RvItemTypes, RecyclerView.ViewHolder>(MyDiffCallback()){


    inner class HeaderViewHolder(val itemMemberinorder: ItemMemberinorder) :
        RecyclerView.ViewHolder(itemMemberinorder) {


    }



    inner class ApiResponseViewHolder(val itemMemberinorder2: ItemMemberinorder2) : RecyclerView.ViewHolder(itemMemberinorder2){

        fun bindApiResponse (rvItemTypes: RvItemTypes.Apiresponse) {


            // manage onvan visibility
            itemMemberinorder2.textview1.text = rvItemTypes.onvan ?: ""
            itemMemberinorder2.textview1.visibility = if (rvItemTypes.onvan.isNullOrEmpty()) View.GONE else View.VISIBLE

            // manage member_count visibility
            itemMemberinorder2.custom3.text = rvItemTypes.member_count.toString()
            itemMemberinorder2.custom3.visibility = if (rvItemTypes.member_count == 0) View.GONE else View.VISIBLE

            // manage discount_member_count visibility
            itemMemberinorder2.discounttext.text = rvItemTypes.discount_member_count.toString()
            itemMemberinorder2.discounttext.visibility = if (rvItemTypes.discount_member_count == 0) View.GONE else View.VISIBLE

            // manage price visibility and button text
        if (rvItemTypes.type == "normal" && !rvItemTypes.by_coin) {
                itemMemberinorder2.whtitebuttun.text = rvItemTypes.price.toString()
                itemMemberinorder2.whtitebuttun.visibility = View.VISIBLE
                itemMemberinorder2.button.visibility = View.GONE
            }


            // manage discount visibility
            itemMemberinorder2.customView.text = rvItemTypes.discount.toString()
            itemMemberinorder2.customView.visibility = if (rvItemTypes.discount == 0) View.GONE else View.VISIBLE

            // manage discount visibility
            itemMemberinorder2.custom2.text = rvItemTypes.discount.toString()
            itemMemberinorder2.custom2.visibility = if (rvItemTypes.discount == 0) View.GONE else View.VISIBLE
            itemMemberinorder2.text.visibility =   View.GONE



        }
            }





    inner class FooterViewHolder(val itemMemberinorder3: ItemMemberinorder3) :
        RecyclerView.ViewHolder(itemMemberinorder3) {


    }




        class MyDiffCallback : DiffUtil.ItemCallback<RvItemTypes>() {
            override fun areItemsTheSame(oldItem: RvItemTypes, newItem: RvItemTypes): Boolean {
                return when {
                    oldItem is RvItemTypes.Apiresponse && newItem is RvItemTypes.Apiresponse ->
                        oldItem.Id == newItem.Id
                    oldItem is RvItemTypes.HeaderModel && newItem is RvItemTypes.HeaderModel ->
                        true  // assuming there is only one header
                    oldItem is RvItemTypes.FooterModel && newItem is RvItemTypes.FooterModel ->
                        true  // assuming there is only one footer
                    else -> false
                }
            }

            override fun areContentsTheSame(oldItem: RvItemTypes, newItem: RvItemTypes): Boolean {
                return oldItem == newItem
            }
        }


        override fun getItemViewType(position: Int): Int {
        return when ( val item = getItem(position)){
            is RvItemTypes.HeaderModel -> header_viewtype
            is RvItemTypes.Apiresponse -> apiresponse_viewtype
            is RvItemTypes.FooterModel -> footer_viewtype
        }
    }



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return when (viewType) {
                header_viewtype -> {
                    val itemMemberinorder = ItemMemberinorder(parent.context)
                    HeaderViewHolder(itemMemberinorder)
                }
                apiresponse_viewtype -> {
                    val itemMemberinorder2 = ItemMemberinorder2(parent.context)
                    ApiResponseViewHolder(itemMemberinorder2)
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
                is ApiResponseViewHolder -> {
                    val apiresponseItem = item as RvItemTypes.Apiresponse
                    holder.bindApiResponse(apiresponseItem)
                }
            }
        }



    }

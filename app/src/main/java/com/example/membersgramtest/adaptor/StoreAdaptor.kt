package com.example.membersgramtest.adaptor

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
                itemMemberinorder2.discounttext.text = rvItemTypes.discountString


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
       if (viewType == header_viewtype) {
            val itemMemberinorder = ItemMemberinorder(parent.context)
           return    HeaderViewHolder(itemMemberinorder)

        }
        if (viewType == apiresponse_viewtype) {
            val itemMemberinorder2 = ItemMemberinorder2(parent.context)
           return ApiResponseViewHolder(itemMemberinorder2)
        }
        else {
            val itemMemberinorder3 = ItemMemberinorder3(parent.context)
          return  FooterViewHolder(itemMemberinorder3)


    }
        }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is HeaderViewHolder -> {
                val headerItem = item as RvItemTypes.HeaderModel

            }
            is ApiResponseViewHolder -> {
                val apiresponsee = item as RvItemTypes.Apiresponse
                holder.bindApiResponse(apiresponsee)

            }
            is FooterViewHolder -> {
                val footerItem = item as RvItemTypes.FooterModel

            }
        }
    }


    }

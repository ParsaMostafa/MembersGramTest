package com.example.membersgramtest.adaptor

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.models.memberview.Rv2model
import com.example.membersgramtest.ui.layout.Rv2Bodyitem
import com.example.membersgramtest.ui.layout.Rv2Headeritem

const val headerrv2_viewtype = 0
const val bodyrv2_viewtype = 1

class AdaptorRv2 :   ListAdapter<Rv2model, RecyclerView.ViewHolder>(MyDiffCallback()){


    inner class HeaderRv2ViewHolder(val rv2Headeritem: Rv2Headeritem) :
        RecyclerView.ViewHolder(rv2Headeritem) {


    }



    inner class BodyRv2ViewHolder(val rv2Bodyitem: Rv2Bodyitem) : RecyclerView.ViewHolder(rv2Bodyitem){

        fun bindBodyRv2 (rv2Model: Rv2model.Rv2BodyModel) {



            rv2Bodyitem.text11.text= rv2Model.price.toString()
            rv2Bodyitem.textView.text = rv2Model.view_count.toString()





        }
    }










    class MyDiffCallback : DiffUtil.ItemCallback<Rv2model>() {
        override fun areItemsTheSame(oldItem: Rv2model, newItem: Rv2model): Boolean {
            return when {
                oldItem is Rv2model.Rv2BodyModel && newItem is Rv2model.Rv2BodyModel ->
                    oldItem.Id == newItem.Id
                oldItem is Rv2model.Rv2HeaderModel && newItem is Rv2model.Rv2HeaderModel ->
                    true  // assuming there is only one header

                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: Rv2model, newItem: Rv2model): Boolean {
            return oldItem == newItem
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when ( val item = getItem(position)){
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
                // Header is static, nothing to bind
            }
            is BodyRv2ViewHolder -> {
                val bodyrv2 = item as Rv2model.Rv2BodyModel
                holder.bindBodyRv2(bodyrv2)
            }
        }
    }




}

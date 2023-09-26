package com.example.membersgramtest.adaptor

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.R
import com.example.membersgramtest.models.MyMemberModel.MyMemberModel
import com.example.membersgramtest.ui.layout.MyMemberBodyModelLayout
import com.example.membersgramtest.ui.layout.MyMemberFooterModelLayout
import com.example.membersgramtest.ui.layout.MyMemberHeaderModelLayout


const val  mymemHeader_viewtype = 0
const val  mymemBody_viewtype = 1
const val  mymemfooter_viewtype = 2
class AdaptorMyMembers : ListAdapter<MyMemberModel, RecyclerView.ViewHolder>(AdaptorMyMembers.MyDiffCallback()){


    inner class MyMemberHeaderViewHolder(val myMemberHeaderModelLayout: MyMemberHeaderModelLayout) :
        RecyclerView.ViewHolder(myMemberHeaderModelLayout) {



        fun bind( header: MyMemberModel.MyMemberHeaderModel ) {
            // Update your header view based on the model
            Glide.with(MyApp.appContext)
                .load(header.accountImage)
                .placeholder(R.drawable.person_bue_24dp__2_) // Placeholder image resource
                .error(R.drawable.icons8_globe_showing_europe_africa_1) // Error image resource
                .into(myMemberHeaderModelLayout.imageViewClient)



            myMemberHeaderModelLayout.clientName.text = header.title
            myMemberHeaderModelLayout.numberclient.text = header.number

        }

    }


    inner class MyMemberBodyModelViewHolder( val myMemberBodyModelLayout: MyMemberBodyModelLayout) :
        RecyclerView.ViewHolder(myMemberBodyModelLayout) {


        fun bind(  header: MyMemberModel.MyMemberBodyModel  ) {
            // Update your header view based on the model
            Glide.with(MyApp.appContext)
                .load(header.icon1)
                .placeholder(R.drawable.person_bue_24dp__2_) // Placeholder image resource
                .error(R.drawable.icons8_globe_showing_europe_africa_1) // Error image resource
                .into(myMemberBodyModelLayout.imageViewPayment)



            myMemberBodyModelLayout.textViewPayment.text = header.title1


            // Update your header view based on the model
            Glide.with(MyApp.appContext)
                .load(header.icon2)
                .placeholder(R.drawable.person_bue_24dp__2_) // Placeholder image resource
                .error(R.drawable.icons8_globe_showing_europe_africa_1) // Error image resource
                .into(myMemberBodyModelLayout.imageViewsuport)



            myMemberBodyModelLayout.textViewsuporrt.text = header.title2







        }
    }

    inner class MyMemberFooterModelViewHolder( val memberFooterModelLayout: MyMemberFooterModelLayout ) :
        RecyclerView.ViewHolder(memberFooterModelLayout) {

    }

    class MyDiffCallback : DiffUtil.ItemCallback<MyMemberModel>() {
        override fun areItemsTheSame(oldItem: MyMemberModel, newItem: MyMemberModel): Boolean {
            return oldItem::class == newItem::class // تغییر این خط
        }

        override fun areContentsTheSame(oldItem: MyMemberModel, newItem: MyMemberModel): Boolean {
            return oldItem == newItem
        }
    }



    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MyMemberModel.MyMemberHeaderModel -> mymemHeader_viewtype
            is MyMemberModel.MyMemberBodyModel -> mymemBody_viewtype
            is MyMemberModel.MyMemberFooterModel -> mymemfooter_viewtype
        }
    }








    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
           mymemHeader_viewtype -> {
                val myMemberHeaderModelLayout = MyMemberHeaderModelLayout(parent.context)
                MyMemberHeaderViewHolder(myMemberHeaderModelLayout)
            }
            mymemBody_viewtype -> {
                val myMemberBodyModelLayout = MyMemberBodyModelLayout(parent.context)
                MyMemberBodyModelViewHolder(myMemberBodyModelLayout)
            }
            mymemfooter_viewtype -> {
                val myMemberFooterModelLayout = MyMemberFooterModelLayout(parent.context)
                MyMemberFooterModelViewHolder(myMemberFooterModelLayout)

            }
            else -> throw IllegalArgumentException("Invalid view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is AdaptorMyMembers.MyMemberHeaderViewHolder -> {
                val header = item as MyMemberModel.MyMemberHeaderModel
                holder.bind(header)
            }
            is AdaptorMyMembers.MyMemberBodyModelViewHolder -> {
                val body = item as MyMemberModel.MyMemberBodyModel
                holder.bind(body)
            }
            is AdaptorMyMembers.MyMemberFooterModelViewHolder -> {

            }
        }
    }
}
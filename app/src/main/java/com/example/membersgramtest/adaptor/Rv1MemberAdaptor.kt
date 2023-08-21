package com.example.membersgramtest.adaptor

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.R
import com.example.membersgramtest.models.memberresponse.RV1Member
import com.example.membersgramtest.ui.layout.BodyItemRv1

class Rv1MemberAdaptorclass (val onClick: (RV1Member.RV1Model) -> Unit) :
ListAdapter<RV1Member.RV1Model, Rv1MemberAdaptorclass.BodyItemRv1ViewHolder>(Rv1memDiffCallback()){
    private var previousSelectedItem: RV1Member.RV1Model? = null

    inner class BodyItemRv1ViewHolder(val bodyItemRv1: BodyItemRv1) :
        RecyclerView.ViewHolder(bodyItemRv1) {

        init {

            val defaultSelectedItem = currentList.find { it.name == "World" }
            defaultSelectedItem?.isSelected = true
            previousSelectedItem = defaultSelectedItem
        }

        fun bindrv1(rv1Model: RV1Member.RV1Model ) {
            Log.d("Adapter", "Binding item: ${rv1Model.toString()}")
            if (rv1Model.name == "World") {
                bodyItemRv1.isConditionMet = false
                bodyItemRv1.flag = true
                Glide.with(MyApp.appContext)
                    .load(rv1Model.flag)
                    .placeholder(R.drawable.person_bue_24dp__2_) // Placeholder image resource
                    .error(R.drawable.icons8_globe_showing_europe_africa_1) // Error image resource
                    .into(bodyItemRv1.imageView)
                bodyItemRv1.bt.setPadding(35, 0,0, 0)
                bodyItemRv1.bt.text = "Global"
            } else {
                bodyItemRv1.isConditionMet = true
                bodyItemRv1.flag = false
                bodyItemRv1.bt.text = "${rv1Model.name}  "
                bodyItemRv1.flag = false
                bodyItemRv1.bt.setPadding(60, 0,0, 0)
                // Load the image using Glide
                Glide.with(MyApp.appContext)
                    .load(rv1Model.flag)
                    .placeholder(R.drawable.person_bue_24dp__2_) // Placeholder image resource
                    .error(R.drawable.visibility_black_24dp__2_) // Error image resource
                    .into(bodyItemRv1.imageView)

            }

            if (rv1Model.isSelected) {
    bodyItemRv1.bt.typeface =ResourcesCompat.getFont(MyApp.appContext, R.font.producsansmedium)
                val selectedBackgroundColor = Color.parseColor("#E3F2FD")
                val selectedTextColor = Color.parseColor("#1565C0")
                bodyItemRv1.bt.backgroundTintList = ColorStateList.valueOf(selectedBackgroundColor)
                bodyItemRv1.imageView.visibility = View.VISIBLE
                bodyItemRv1.bt.setTextColor(selectedTextColor)
                bodyItemRv1.bt.strokeWidth = 0
            } else {
                bodyItemRv1.bt.strokeWidth = 1
                bodyItemRv1.imageView.visibility = View.VISIBLE
                val unselectedBackgroundColor = Color.parseColor("#FFFFFF")
                val unselectedTextColor = Color.parseColor("#616161")
                bodyItemRv1.bt.backgroundTintList = ColorStateList.valueOf(unselectedBackgroundColor)
                bodyItemRv1.bt.setTextColor(unselectedTextColor)
                bodyItemRv1.bt.typeface =ResourcesCompat.getFont(MyApp.appContext, R.font.product_sans_regular)
            }



            bodyItemRv1.bt.setOnClickListener {
                if (rv1Model != previousSelectedItem) {
                    rv1Model.isSelected = true
                    previousSelectedItem?.isSelected = false
                    previousSelectedItem = rv1Model

                    notifyDataSetChanged()

                    onClick(rv1Model)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rv1MemberAdaptorclass.BodyItemRv1ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bodyItemRv1 = BodyItemRv1(parent.context)
        return BodyItemRv1ViewHolder(bodyItemRv1)
    }

    override fun onBindViewHolder(holder: Rv1MemberAdaptorclass.BodyItemRv1ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindrv1(item)


    }


    class Rv1memDiffCallback : DiffUtil.ItemCallback<RV1Member.RV1Model>() {
        override fun areItemsTheSame(oldItem: RV1Member.RV1Model, newItem: RV1Member.RV1Model): Boolean {
            return oldItem.countryCode == newItem.countryCode
        }

        override fun areContentsTheSame(oldItem: RV1Member.RV1Model, newItem: RV1Member.RV1Model): Boolean {
            return oldItem == newItem
        }
    }
}

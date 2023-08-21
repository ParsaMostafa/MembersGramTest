package com.example.membersgramtest.adapter

import Rv1Model
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.R
import com.example.membersgramtest.ui.layout.BodyItemRv1

class BodyItemRv1Adapter(val onClick: (Rv1Model.Rv1BodyModel) -> Unit) :
    ListAdapter<Rv1Model.Rv1BodyModel, BodyItemRv1Adapter.BodyItemRv1ViewHolder>(Rv1ModelDiffCallback()) {
    private var previousSelectedItem: Rv1Model.Rv1BodyModel? = null

    inner class BodyItemRv1ViewHolder(private val bodyItemRv1: BodyItemRv1) :
        RecyclerView.ViewHolder(bodyItemRv1) {
        init {
            // Find the item with count_post equal to 1 and select it
            val defaultSelectedItem = currentList.find { it.count_post == 1 }
            defaultSelectedItem?.isSelected = true
            previousSelectedItem = defaultSelectedItem
        }
        fun bindrv1(rv1Model: Rv1Model.Rv1BodyModel) {
            if (rv1Model.count_post == 1) {
                bodyItemRv1.bt.text = "One Post"
            } else {
                bodyItemRv1.bt.text = "${rv1Model.count_post} Posts"
            }

            // Update background and text color based on selection
            if (rv1Model.isSelected) {
                val selectedBackgroundColor = Color.parseColor("#E3F2FD")
                val selectedTextColor = Color.parseColor("#1565C0")
                bodyItemRv1.bt.backgroundTintList = ColorStateList.valueOf(selectedBackgroundColor)
                bodyItemRv1.bt.setTextColor(selectedTextColor)
            } else {
                val unselectedBackgroundColor = Color.parseColor("#FFFFFF")
                val unselectedTextColor = Color.parseColor("#616161")
                bodyItemRv1.bt.backgroundTintList = ColorStateList.valueOf(unselectedBackgroundColor)
                bodyItemRv1.bt.setTextColor(unselectedTextColor)
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




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyItemRv1ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bodyItemRv1 = BodyItemRv1(parent.context)
        return BodyItemRv1ViewHolder(bodyItemRv1)
    }

    override fun onBindViewHolder(holder: BodyItemRv1ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindrv1(item)
    }

    class Rv1ModelDiffCallback : DiffUtil.ItemCallback<Rv1Model.Rv1BodyModel>() {
        override fun areItemsTheSame(oldItem: Rv1Model.Rv1BodyModel, newItem: Rv1Model.Rv1BodyModel): Boolean {
            return oldItem.count_post == newItem.count_post
        }

        override fun areContentsTheSame(oldItem: Rv1Model.Rv1BodyModel, newItem: Rv1Model.Rv1BodyModel): Boolean {
            return oldItem == newItem
        }
    }
}

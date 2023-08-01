package com.example.membersgramtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.models.memberview.Rv1Model
import com.example.membersgramtest.ui.layout.BodyItemRv1

class BodyItemRv1Adapter(private val onClick: (Rv1Model.Rv1BodyModel) -> Unit) :
    ListAdapter<Rv1Model.Rv1BodyModel, BodyItemRv1Adapter.BodyItemRv1ViewHolder>(Rv1ModelDiffCallback()) {

    inner class BodyItemRv1ViewHolder(private val bodyItemRv1: BodyItemRv1) :
        RecyclerView.ViewHolder(bodyItemRv1) {

        fun bindrv1(rv1Model: Rv1Model.Rv1BodyModel) {
            bodyItemRv1.bt.text = rv1Model.count_post.toString()
            bodyItemRv1.bt.setOnClickListener { onClick(rv1Model) }
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

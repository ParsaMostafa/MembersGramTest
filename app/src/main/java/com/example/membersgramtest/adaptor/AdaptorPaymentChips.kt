package com.example.membersgramtest.adaptor
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.models.Transaction.ChipsModel
import com.example.membersgramtest.models.Transaction.Doc
import com.example.membersgramtest.ui.layout.ChipsOfPaymentLayout

class AdaptorPaymentChips   :
    ListAdapter<ChipsModel, AdaptorPaymentChips.ChipsItemsViewHolder>(ChipsDiffCallback())
{

    inner class ChipsItemsViewHolder(val chipsOfPaymentLayout: ChipsOfPaymentLayout) :
        RecyclerView.ViewHolder(chipsOfPaymentLayout) {

        fun bindChips(chips : ChipsModel ) {
            Log.d("Paging", "Binding item: ${chips.toString()}")

             chipsOfPaymentLayout.Buttonfiltered.text = chips.filterdname


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptorPaymentChips.ChipsItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val ChipsItems = ChipsOfPaymentLayout(parent.context)
        return ChipsItemsViewHolder(ChipsItems)
    }

    override fun onBindViewHolder(holder: AdaptorPaymentChips.ChipsItemsViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bindChips(item)
        }
        }

    }


class ChipsDiffCallback : DiffUtil.ItemCallback<ChipsModel>() {
    override fun areItemsTheSame(oldItem: ChipsModel , newItem: ChipsModel): Boolean {
        // Check if the items have the same ID or unique identifier
        return oldItem.filterdname == newItem.filterdname
    }

    override fun areContentsTheSame( oldItem: ChipsModel , newItem: ChipsModel ): Boolean {
        // Check if the contents of the items are the same. This is where you define your comparison logic.
        // You can compare each field in your Doc class here.
        return oldItem == newItem
    }
}

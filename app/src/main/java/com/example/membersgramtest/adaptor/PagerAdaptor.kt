package com.example.membersgramtest.adaptor

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.ui.layout.ViewPagerItemPreView
import com.example.membersgramtest.utillity.MyData

class PagerAdaptor(
    private var dataList: List<MyData>
) : RecyclerView.Adapter<PagerAdaptor.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(val viewPagerItemPreView: ViewPagerItemPreView) :
        RecyclerView.ViewHolder(viewPagerItemPreView) {
        fun bind(data: MyData) {
            viewPagerItemPreView.textview2.text = data.text1
            viewPagerItemPreView.textview3.text = data.text2
            viewPagerItemPreView.imageviewmain.setImageResource(data.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerAdaptor.Pager2ViewHolder {
        val viewPagerItemPreView = ViewPagerItemPreView(parent.context)
        viewPagerItemPreView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return Pager2ViewHolder(viewPagerItemPreView)
    }


    override fun onBindViewHolder(holder: PagerAdaptor.Pager2ViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
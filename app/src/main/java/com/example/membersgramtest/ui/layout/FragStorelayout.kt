package com.example.membersgramtest.ui.layout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics

class FragStorelayout(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val recyclerView:RecyclerView







    init {

        recyclerView = RecyclerView(context)
        addView(recyclerView)



    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // RecyclerView
        val tleft = l
        val ttop = t
        val tright = l + parentWidth
        val tbottom = t + parentHeight
        recyclerView.layout(tleft, ttop, tright, tbottom)
    }




    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)

        // Create a measure specification for the RecyclerView's height that allows it to be as big as it wants, up to the specified size.
        val heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.AT_MOST)

        recyclerView.measure(widthMeasureSpec, heightSpec)

        // Let's measure the ViewGroup to be as big as it's allowed.
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

}

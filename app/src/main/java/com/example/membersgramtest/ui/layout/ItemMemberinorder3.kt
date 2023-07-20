package com.example.membersgramtest.ui.layout

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics

class ItemMemberinorder3(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr){
    val imageview : ImageView






    init {

        imageview = ImageView(context)
        imageview.setImageResource(R.drawable.group_17276)
        addView(imageview)

    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        //val imageview
        val l = l
        val t = t
        val r = r
        val b = b
        imageview.layout(l,t,r,b)


    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)



    imageview.measure(
        Measure.wrapContentSpec,
        Measure.wrapContentSpec
    )



        setMeasuredDimension(width, Metrics.dpToPx(43) + imageview.measuredHeight)
    }
}
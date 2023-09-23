package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics

class MyMemberFooterModelLayout (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {


    // ImageView Center
    val imageViewClient = ImageView(context).apply {
        setImageResource(R.drawable.group_9853)

    }



    init {
        // Add child views to your custom ViewGroup
        addView(imageViewClient)





    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // Center ImageView
        val imageLeft = (parentWidth - imageViewClient.measuredWidth) / 2
        val imageTop = Metrics.dpToPx(10)
        val imageRight = imageLeft + imageViewClient.measuredWidth
        val imageBottom = imageTop + imageViewClient.measuredHeight
        imageViewClient.layout(imageLeft, imageTop, imageRight, imageBottom)




    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)


        imageViewClient.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec)





        setMeasuredDimension(
            width,
            Metrics.dpToPx(50)
        )
    }







}
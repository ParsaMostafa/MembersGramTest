package com.example.membersgramtest.ui.layout

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.example.membersgramtest.utillity.Metrics.setSize

class ViewPagerItemPreView(  context: Context,
                             attrs: AttributeSet? = null
) : ViewGroup(context, attrs) {
    val imageviewmain: ImageView
    val textview2: TextView
    val textview3: TextView

    init {

        imageviewmain = ImageView(context)
        imageviewmain.setImageResource(R.drawable.group_9783)
        addView(imageviewmain)

        textview2 = TextView(context)
        textview2.hint = "Increase member"
        textview2.setSize(20)
        textview2.gravity = Gravity.CENTER
        addView(textview2)

        textview3 = TextView(context)
        textview3.hint = "Order as many members "
        textview3.gravity = Gravity.CENTER
        addView(textview3)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // imageview
        val iWidth = imageviewmain.measuredWidth
        val iHeight = imageviewmain.measuredHeight
        val iLeft = (parentWidth - iWidth) / 2
        val iTop = (parentHeight - iHeight) / 2 - Metrics.dpToPx(80)
        val iRight = iLeft + iWidth
        val iBottom = iTop + iHeight
        imageviewmain.layout(iLeft, iTop, iRight, iBottom)

        // textview2
        val textWidth = textview2.measuredWidth
        val textHeight = textview2.measuredHeight
        val ttLeft = (parentWidth - textWidth) / 2
        val ttTop = parentHeight - (parentHeight - iHeight) / 2 - Metrics.dpToPx(40)
        val ttRight = ttLeft + textWidth
        val ttBottom = ttTop + textHeight
        textview2.layout(ttLeft, ttTop, ttRight, ttBottom)

        // textview3
        val text3Width = textview3.measuredWidth
        val text3Height = textview3.measuredHeight
        val tt3Left = (parentWidth - text3Width) / 2
        val tt3Top = ttTop + text3Height + Metrics.dpToPx(20) // Adjusted top position
        val tt3Right = tt3Left + text3Width
        val tt3Bottom = tt3Top + text3Height
        textview3.layout(tt3Left, tt3Top, tt3Right, tt3Bottom)


    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(
            MeasureSpec.makeMeasureSpec(Metrics.displayWidth, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(Metrics.displayHeight, MeasureSpec.EXACTLY)
        )

        imageviewmain.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        textview2.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        // Measure textview3 based on its content
        // Measure the dimensions of the TextView

        textview3.measure(
            View.MeasureSpec.makeMeasureSpec(widthMeasureSpec-Metrics.dpToPx(60), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(80, View.MeasureSpec.EXACTLY)
        )




    }
}
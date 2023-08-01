package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics

class ItemRv1(
    context: Context, attrs: AttributeSet?
) : ViewGroup(context, attrs) {

        val textView : TextView




    init {
        textView = TextView(context)
        textView.text = "Number of posts"
        textView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textView.setTextColor(Color.parseColor("#616161"))
        addView(textView)

    }

    fun setText(text: String) {
        textView.text = text
    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // textview
        val l =  Metrics.dpToPx(16)
        val t =  Metrics.dpToPx(10)
        val r = l + textView.measuredWidth
        val b = t+ textView.measuredHeight
        textView.layout(l, t, r, b)




    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {


        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)

        textView.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )



        val textwidth = textView.measuredWidth

        setMeasuredDimension(textwidth+Metrics.dpToPx(50), Measure.getExactSpec(42)+textView.measuredHeight)




    }






}
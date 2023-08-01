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

class Rv2Headeritem (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val textView : TextView




    init {
        textView = TextView(context)
        textView.text = "Visit order"
        textView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        textView.setTextColor(Color.parseColor("#212121"))
        addView(textView)

    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // textview
        val l =  Metrics.dpToPx(16)
        val t =  Metrics.dpToPx(8)
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





        setMeasuredDimension(Metrics.dpToPx(140), Measure.getExactSpec(45)+textView.measuredHeight)




    }






}
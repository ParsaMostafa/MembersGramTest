package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Metrics

class FragMenberslayout (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val text1 : TextView







    init {


        text1 = TextView(context)
        text1.text = "Join the bot"
        text1.textSize = 20F
        text1.setTextColor(Color.parseColor("#212121")) // Set text color to black
        text1.gravity = Gravity.CENTER
        text1.setTypeface(null, Typeface.BOLD)
        text1.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)// Set the typeface to bold
        addView(text1)



    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        //Text1
        val tleft = (parentWidth - text1.measuredWidth) / 2
        val ttop = t + text1.measuredHeight+ Metrics.dpToPx(10) + text1.measuredHeight  // Set the top position to 0 to align with the top of the parent
        val tright = tleft + text1.measuredWidth
        val tbottom = ttop+ text1.measuredHeight
        text1.layout(tleft, ttop, tright, tbottom)



    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)



        text1.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )

    }
}

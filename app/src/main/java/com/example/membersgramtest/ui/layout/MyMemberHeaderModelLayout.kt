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

class MyMemberHeaderModelLayout(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    // ImageView Center
    val imageViewClient = ImageView(context).apply {
        setImageResource(R.drawable.visibility_black_24dp__2_)

    }

    // Text View
    val clientName = TextView(context).apply {
        text = "Borzoo Bastaee"
        textSize = 16F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }

    // Text View Number
    val numberclient = TextView(context).apply {
        text = "09055249719"
        textSize = 16F
        setTextColor(Color.parseColor("#616161"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }


    init {
        // Add child views to your custom ViewGroup
        addView(imageViewClient)

        // Add TextView
        addView(clientName)

        // Client Number
        addView(numberclient)



    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // Center ImageView
        val imageLeft = (parentWidth - imageViewClient.measuredWidth) / 2
        val imageTop = Metrics.dpToPx(53)
        val imageRight = imageLeft + imageViewClient.measuredWidth
        val imageBottom = imageTop + imageViewClient.measuredHeight
        imageViewClient.layout(imageLeft, imageTop, imageRight, imageBottom)

        // Center TextView below ImageView
        val textLeft = (parentWidth - clientName.measuredWidth) / 2
        val textTop =  imageBottom + Metrics.dpToPx(8)
        val textRight = textLeft + clientName.measuredWidth
        val textBottom = textTop + clientName.measuredHeight
        clientName.layout(textLeft, textTop, textRight, textBottom)

        // Number
        val numLeft = Metrics.dpToPx(150)
        val numTop = Metrics.dpToPx(158)
        val numRight = numLeft + numberclient.measuredWidth
        val numBottom = numTop + numberclient.measuredHeight
        numberclient.layout(numLeft, numTop, numRight, numBottom)



    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)


        imageViewClient.measure(
            Measure.getExactSpec(Metrics.dpToPx(65)),
            Measure.getExactSpec(Metrics.dpToPx(65))
        )

        clientName.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        numberclient.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec

        )


        setMeasuredDimension(
            width,
           Metrics.dpToPx(235)
        )
    }



}
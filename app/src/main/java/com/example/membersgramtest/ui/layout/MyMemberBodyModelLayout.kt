package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.View.MeasureSpec.EXACTLY
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics

class MyMemberBodyModelLayout (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {



    // ImageView payment
    val imageViewPayment = ImageView(context).apply {
        setImageResource(R.drawable.payment_black_24dp)

    }

    // Text View Number
    val textViewPayment = TextView(context).apply {
        text = "Payments"
        textSize = 14F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }

      // Divider view
       val lineView: View // Added gray line view
       var showDivider : Boolean = true








    init {


        // ImageView payment
        addView(imageViewPayment)

        // Add TextView Payment
        addView(textViewPayment)

        lineView = View(context)
        lineView.setBackgroundColor(Color.parseColor("#E7E7E7"))
        addView(lineView)







    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t


        // ImageViewPayment
        val paymentLeft = Metrics.dpToPx(24)
        val paymentTop =  parentHeight / 2   - imageViewPayment.measuredHeight / 2
        val paymentRight = paymentLeft + imageViewPayment.measuredWidth
        val paymentBottom = parentHeight / 2   + imageViewPayment.measuredHeight / 2
        imageViewPayment.layout(paymentLeft, paymentTop, paymentRight, paymentBottom)

        // textViewPayment
        val textpaymentLeft = Metrics.dpToPx(72)
        val textpaymentTop = paymentTop + Metrics.dpToPx(3)
        val textpaymentRight = textpaymentLeft + textViewPayment.measuredWidth
        val textpaymentBottom = textpaymentTop + textViewPayment.measuredHeight
        textViewPayment.layout(textpaymentLeft, textpaymentTop, textpaymentRight, textpaymentBottom)

        // Line View
        val lineLeft = l
        val lineTop =   textpaymentTop - Metrics.dpToPx(18)
        val lineRight = r
        val lineHeight = 1 // Set line height as desired
        val lineBottom = lineTop + lineHeight
        lineView.layout(lineLeft, lineTop, lineRight, lineBottom)
        if ( showDivider == true ) {
            Log.d("cyberwolf","$showDivider")
            lineView.visibility = View.VISIBLE

        } else {
            lineView.visibility = View.INVISIBLE
            // Do nothing when showDivider is false
        }




    }


        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            val width = View.MeasureSpec.getSize(widthMeasureSpec)
            val height = View.MeasureSpec.getSize(heightMeasureSpec)


            imageViewPayment.measure(
                Measure.wrapContentSpec,
                Measure.wrapContentSpec
            )

            textViewPayment.measure(
                Measure.wrapContentSpec,
                Measure.wrapContentSpec
            )

            // Line View
            val lineViewHeight = 1 // Set line view height as desired
            lineView.measure(
                MeasureSpec.makeMeasureSpec(width , MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(lineViewHeight, MeasureSpec.EXACTLY)
            )







            setMeasuredDimension(
                width,
                 textViewPayment.measuredHeight  + Metrics.dpToPx(39)
            )
        }
    }

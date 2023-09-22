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

class MyMemberLayout(
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


    // ImageView Center
    val imageViewsuport = ImageView(context).apply {
        setImageResource(R.drawable.ic_support)

    }

    // Text View Suporrt
    val textViewsuporrt = TextView(context).apply {
        text = "Support"
        textSize = 14F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }

    // ImageView Center
    val imageviewSetting = ImageView(context).apply {
        setImageResource(R.drawable.settings_24px)

    }






    init {
        // Add child views to your custom ViewGroup
        addView(imageViewClient)

        // Add TextView
        addView(clientName)

        // Client Number
        addView(numberclient)

        // ImageView payment
        addView(imageViewPayment)

        // Add TextView Payment
        addView(textViewPayment)

        // Add TextView Payment
        addView(imageViewsuport)

        // Add TextView Payment
        addView(textViewsuporrt)




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
        val numLeft = Metrics.dpToPx(158)
        val numTop = Metrics.dpToPx(150)
        val numRight = numLeft + numberclient.measuredWidth
        val numBottom = numTop + numberclient.measuredHeight
        numberclient.layout(numLeft, numTop, numRight, numBottom)

        // ImageViewPayment
        val paymentLeft =  Metrics.dpToPx(24)
        val paymentTop = numBottom +  Metrics.dpToPx(48)
        val paymentRight = paymentLeft + imageViewPayment.measuredWidth
        val paymentBottom = paymentTop + imageViewPayment.measuredHeight
        imageViewPayment.layout(paymentLeft, paymentTop , paymentRight, paymentBottom)

        // textViewPayment
        val textpaymentLeft =  Metrics.dpToPx(72)
        val textpaymentTop = numBottom +  Metrics.dpToPx(52)
        val textpaymentRight = textpaymentLeft + textViewPayment.measuredWidth
        val textpaymentBottom = textpaymentTop + textViewPayment.measuredHeight
        textViewPayment.layout(textpaymentLeft, textpaymentTop , textpaymentRight, textpaymentBottom)

        // ImageViewsuport
        val imageviewsupporttLeft =  Metrics.dpToPx(24)
        val imageviewsupportTop = numBottom +  Metrics.dpToPx(104)
        val imageviewsupportRight = imageviewsupporttLeft + imageViewsuport.measuredWidth
        val imageviewsupportBottom = imageviewsupportTop+ imageViewsuport.measuredHeight
        imageViewsuport.layout(imageviewsupporttLeft, imageviewsupportTop , imageviewsupportRight, imageviewsupportBottom)

        // suport
        val  supporttextleft =  Metrics.dpToPx(72)
        val  supporttexttop = numBottom +  Metrics.dpToPx(108)
        val  supporttextRight = supporttextleft + textViewsuporrt.measuredWidth
        val supporttextBottom = supporttexttop + textViewsuporrt.measuredHeight
        textViewsuporrt.layout(supporttextleft, supporttexttop , supporttextRight, supporttextBottom)


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

        imageViewPayment.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        textViewPayment.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        imageViewsuport.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        textViewsuporrt.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        setMeasuredDimension(
            width,
            height
        )
    }
}

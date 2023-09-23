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

    // Text Settings
    val textSettings = TextView(context).apply {
        text = "Settings"
        textSize = 14F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }

    //lineView
    val lineView = View(context).apply {
        setBackgroundColor(Color.parseColor("#E7E7E7"))
    }

    // ImageView Center
    val logout = ImageView(context).apply {
        setImageResource(R.drawable.logout_black_24dp)

    }

    // Text Settings
    val textlogout = TextView(context).apply {
        text = "Log out"
        textSize = 14F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }


    init {


        // ImageView payment
        addView(imageViewPayment)

        // Add TextView Payment
        addView(textViewPayment)

        // Add TextView Payment
        addView(imageViewsuport)

        // Add TextView Payment
        addView(textViewsuporrt)

        // Add TextView Payment
        addView(imageviewSetting)

        // Add TextView Payment
        addView(textSettings)

        // Add TextView Payment
        addView(lineView)

        // Add TextView Payment
        addView(logout)

        // Add TextView Payment
        addView(textlogout)


    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t


        // ImageViewPayment
        val paymentLeft = Metrics.dpToPx(24)
        val paymentTop = Metrics.dpToPx(5)
        val paymentRight = paymentLeft + imageViewPayment.measuredWidth
        val paymentBottom = paymentTop + imageViewPayment.measuredHeight
        imageViewPayment.layout(paymentLeft, paymentTop, paymentRight, paymentBottom)

        // textViewPayment
        val textpaymentLeft = Metrics.dpToPx(72)
        val textpaymentTop = paymentTop + Metrics.dpToPx(4)
        val textpaymentRight = textpaymentLeft + textViewPayment.measuredWidth
        val textpaymentBottom = textpaymentTop + textViewPayment.measuredHeight
        textViewPayment.layout(textpaymentLeft, textpaymentTop, textpaymentRight, textpaymentBottom)

        // ImageViewsuport
        val imageviewsupporttLeft = Metrics.dpToPx(24)
        val imageviewsupportTop = paymentBottom + Metrics.dpToPx(32)
        val imageviewsupportRight = imageviewsupporttLeft + imageViewsuport.measuredWidth
        val imageviewsupportBottom = imageviewsupportTop + imageViewsuport.measuredHeight
        imageViewsuport.layout(
            imageviewsupporttLeft,
            imageviewsupportTop,
            imageviewsupportRight,
            imageviewsupportBottom
        )

        // suport
        val supporttextleft = Metrics.dpToPx(72)
        val supporttexttop = textpaymentBottom + Metrics.dpToPx(39)
        val supporttextRight = supporttextleft + textViewsuporrt.measuredWidth
        val supporttextBottom = supporttexttop + textViewsuporrt.measuredHeight
        textViewsuporrt.layout(supporttextleft, supporttexttop, supporttextRight, supporttextBottom)


        // settings
        val settingstLeft = Metrics.dpToPx(24)
        val settingstTop = imageviewsupportBottom  + Metrics.dpToPx(32)
        val settingsRight = settingstLeft + imageviewSetting.measuredWidth
        val settingsBottom = settingstTop + imageviewSetting.measuredHeight
        imageviewSetting.layout(settingstLeft, settingstTop, settingsRight, settingsBottom)

        // settings Text
        val stextleft = Metrics.dpToPx(72)
        val stexttop =  imageviewsupportBottom  + Metrics.dpToPx(35)
        val stextRight = stextleft + textSettings.measuredWidth
        val stextBottom = stexttop + textSettings.measuredHeight
        textSettings.layout(stextleft, stexttop, stextRight, stextBottom)


        // Line View
        val lineLeft = l
        val lineTop = Metrics.dpToPx(170)
        val lineRight = r
        val lineHeight = 1 // Set line height as desired
        val lineBottom = lineTop + lineHeight
        lineView.layout(lineLeft, lineTop, lineRight, lineBottom)

        // logout
        val logoutLeft = Metrics.dpToPx(24)
        val logoutTop = lineBottom  + Metrics.dpToPx(24)
        val logoutRight = logoutLeft + logout.measuredWidth
        val logoutBottom = logoutTop + logout.measuredHeight
        logout.layout(logoutLeft, logoutTop, logoutRight, logoutBottom)

        // logout Text
        val logouttextleft = Metrics.dpToPx(72)
        val logouttexttop =  lineBottom  + Metrics.dpToPx(26)
        val logouttextRight = logouttextleft + textlogout.measuredWidth
        val logouttextBottom = logouttexttop + textlogout.measuredHeight
        textlogout.layout(logouttextleft, logouttexttop, logouttextRight, logouttextBottom)

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

            imageViewsuport.measure(
                Measure.wrapContentSpec,
                Measure.wrapContentSpec
            )

            textViewsuporrt.measure(
                Measure.wrapContentSpec,
                Measure.wrapContentSpec
            )

            imageviewSetting.measure(
                Measure.wrapContentSpec,
                Measure.wrapContentSpec
            )
            textSettings.measure(
                Measure.wrapContentSpec,
                Measure.wrapContentSpec
            )

            // Line View
            val lineViewHeight = 1 // Set line view height as desired
            lineView.measure(
                MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(lineViewHeight, MeasureSpec.EXACTLY)
            )

            logout.measure(
                Measure.wrapContentSpec,
                Measure.wrapContentSpec
            )
            textlogout.measure(
                Measure.wrapContentSpec,
                Measure.wrapContentSpec
            )


            setMeasuredDimension(
                width,
                Metrics.dpToPx(230)
            )
        }
    }

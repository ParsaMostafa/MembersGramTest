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

class LogOutLayout (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    // ImageView Center
    val imageViewClient = ImageView(context).apply {
        setImageResource(R.drawable.ic_actionbar_back)

    }

    // Text View
    val clientName = TextView(context).apply {
        text = "Log out"
        textSize = 20F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
    }

    // Text View Number
    val numberclient = TextView(context).apply {
        text = "Other options"
        textSize = 12F
        setTextColor(Color.parseColor("#616161"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }


    // ImageView Email
    val Emailimg = ImageView(context).apply {
        setImageResource(R.drawable.ic_email)

    }


    // Text View
    val sendEmailTextView = TextView(context).apply {
        text = "Send email to support"
        textSize = 16F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }


    // Text View
    val emailus = TextView(context).apply {
        text = "Email us if you are dissatisfied"
        textSize = 12F
        setTextColor(Color.parseColor("#616161"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }

    // ImageView
    val aq = ImageView(context).apply {
        setImageResource(R.drawable.ic_faq)

    }

    // Text View
    val FrequentlyAskedQuestions = TextView(context).apply {
        text = "Frequently Asked Questions"
        textSize = 16F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }


    // Text View
    val IfyouhaveaproblemTextView = TextView(context).apply {
        text = "If you have a problem, here is the answer"
        textSize = 12F
        setTextColor(Color.parseColor("#616161"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }

    //lineView
    val lineView = View(context).apply {
        setBackgroundColor(Color.parseColor("#E7E7E7"))
    }


    // ImageView Center
    val imageViewredLogout = ImageView(context).apply {
        setImageResource(R.drawable.ic_account_managment__1_)

    }

    // Text View
    val redtextlogout = TextView(context).apply {
        text = "Log out"
        textSize = 16F
        setTextColor(Color.parseColor("#D32F2F"))
        typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
    }




    init {
        // Add child views to your custom ViewGroup
        addView(imageViewClient)

        // Add TextView
        addView(clientName)

        // Client Number
        addView(numberclient)

        // Img Email
        addView(Emailimg)

        // TextView sendEmailTextView
        addView(sendEmailTextView)

        // TextView email us
        addView(emailus)

        // TextView email us
        addView(aq)

        // TextView email us
        addView(FrequentlyAskedQuestions)

        // TextView email us
        addView(IfyouhaveaproblemTextView)

        // Add TextView
        addView(lineView)

        //
        addView(imageViewredLogout)

        //
        addView(redtextlogout)



    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // Center ImageView
        val imageLeft = Metrics.dpToPx(8)
        val imageTop = Metrics.dpToPx(8)
        val imageRight = imageLeft + imageViewClient.measuredWidth
        val imageBottom = imageTop + imageViewClient.measuredHeight
        imageViewClient.layout(imageLeft, imageTop, imageRight, imageBottom)

        // Center TextView below ImageView
        val textLeft = imageRight + Metrics.dpToPx(16)
        val textTop =   Metrics.dpToPx(16)
        val textRight = textLeft + clientName.measuredWidth
        val textBottom = textTop + clientName.measuredHeight
        clientName.layout(textLeft, textTop, textRight, textBottom)

        // Number
        val numLeft = Metrics.dpToPx(24)
        val numTop = textBottom + Metrics.dpToPx(27)
        val numRight = numLeft + numberclient.measuredWidth
        val numBottom = numTop + numberclient.measuredHeight
        numberclient.layout(numLeft, numTop, numRight, numBottom)

        // img Email
        val numLeftt = Metrics.dpToPx(24)
        val numTopt =  numBottom + Metrics.dpToPx(34)
        val numRightt = numLeftt + Emailimg.measuredWidth
        val numBottomt = numTopt + Emailimg.measuredHeight
        Emailimg.layout(numLeftt, numTopt , numRightt , numBottomt )

        // img Email
        val numLeftts = numRightt + Metrics.dpToPx(24)
        val numTopts =  numBottom + Metrics.dpToPx(23)
        val numRightts = numLeftts + sendEmailTextView.measuredWidth
        val numBottomts = numTopts + sendEmailTextView.measuredHeight
        sendEmailTextView.layout( numLeftts, numTopts , numRightts , numBottomts )

        // img Email
        val numLefttsa = numRightt + Metrics.dpToPx(24)
        val numToptsa =  numBottomts + Metrics.dpToPx(13)
        val numRighttsa = numLefttsa + emailus.measuredWidth
        val numBottomtsa = numToptsa + emailus.measuredHeight
        emailus.layout( numLefttsa, numToptsa , numRighttsa , numBottomtsa )


        // img aq
        val numLefttsaw =  Metrics.dpToPx(24)
        val numToptsaw =  numBottomt + Metrics.dpToPx(48)
        val numRighttsaw = numLefttsaw + aq.measuredWidth
        val numBottomtsaw = numToptsaw + aq.measuredHeight
        aq.layout( numLefttsaw, numToptsaw , numRighttsaw , numBottomtsaw )


        // img
        val numLefttsawq =  numRighttsaw + Metrics.dpToPx(24)
        val numToptsawq =  numBottomtsa + Metrics.dpToPx(25)
        val numRighttsawq = numLefttsawq + FrequentlyAskedQuestions.measuredWidth
        val numBottomtsawq = numToptsawq + FrequentlyAskedQuestions.measuredHeight
        FrequentlyAskedQuestions.layout( numLefttsawq, numToptsawq , numRighttsawq , numBottomtsawq )

        // img If you have a problem
        val numLefttsawqa =  numRighttsaw + Metrics.dpToPx(24)
        val numToptsawqa =  numBottomtsawq + Metrics.dpToPx(13)
        val numRighttsawqa = numLefttsawqa + IfyouhaveaproblemTextView.measuredWidth
        val numBottomtsawqa = numToptsawqa + IfyouhaveaproblemTextView.measuredHeight
        IfyouhaveaproblemTextView.layout( numLefttsawqa , numToptsawqa , numRighttsawqa , numBottomtsawqa )

        // img If you have a problem

        val numToptsawqat =   numBottomtsawqa + Metrics.dpToPx(12)
        val numRighttsawqat = r
        val numBottomtsawqat = numToptsawqat + lineView.measuredHeight
        lineView.layout( l , numToptsawqat , numRighttsawqat , numBottomtsawqat )


        // red log out
        val leftred = Metrics.dpToPx(24)
        val topred =  numBottomtsawqat + Metrics.dpToPx(16)
        val rightred = leftred + imageViewredLogout.measuredWidth
        val bottomred = topred + imageViewredLogout.measuredHeight
        imageViewredLogout.layout(leftred,topred,rightred,bottomred)


        // red text log out
        val leftredq =  rightred + Metrics.dpToPx(24)
        val topredq =  numBottomtsawqat + Metrics.dpToPx(19)
        val rightredq = leftredq + redtextlogout.measuredWidth
        val bottomredq = topredq + redtextlogout.measuredHeight
        redtextlogout.layout(leftredq ,topredq ,rightredq ,bottomredq )




    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)


        imageViewClient.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        clientName.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        numberclient.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec

        )

        Emailimg.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        sendEmailTextView.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        emailus.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        aq.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        FrequentlyAskedQuestions.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        IfyouhaveaproblemTextView.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        // Line View
        val lineViewHeight = 1 // Set line view height as desired
        lineView.measure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(lineViewHeight, MeasureSpec.EXACTLY)
        )

        imageViewredLogout.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        redtextlogout.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )


        setMeasuredDimension(
            width,
            height
        )
    }



}
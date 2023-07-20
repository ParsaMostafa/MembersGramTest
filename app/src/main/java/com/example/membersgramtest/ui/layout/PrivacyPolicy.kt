package com.example.membersgramtest.ui.layout

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class PrivacyPolicy(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
    val imagemain: ImageView
    val text1 :TextView
    val text2:TextView
    val text3:TextView
    val text4:TextView
    val text5:TextView
    val text6:TextView
    val text7:TextView
    val lineView: View // Added gray line view
    val button : MaterialButton







    init {
        imagemain = ImageView(context)
        imagemain.setImageResource(R.drawable.privicy_icon)
        addView(imagemain)

        lineView = View(context)
        lineView.setBackgroundColor(Color.parseColor("#E7E7E7"))
        addView(lineView)

        text1 = TextView(context)
        text1.text = "Your Privacy is important to us"

        text1.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        text1.textSize = 20F
        text1.setTextColor(Color.parseColor("#212121"))
        addView(text1)

        text2 = TextView(context)
        val text2StringBuilder = SpannableStringBuilder("By clicking Agree & Continue you agree to our Privacy Policy and Terms of Service")
        text2StringBuilder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.blueindt)), // Set text color to blue
            text2StringBuilder.indexOf("Privacy Policy"), // Start index of "Privacy Policy" in the string
            text2StringBuilder.indexOf("Privacy Policy") + "Privacy Policy".length, // End index of "Privacy Policy" in the string
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Span type
        )
        text2StringBuilder.setSpan(
            object : ClickableSpan() {
                override fun onClick(view: View) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://membersgram.com/privacy/"))
                    view.context.startActivity(intent)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.isUnderlineText = false // Remove underline
                 //   ds.typeface = Typeface.DEFAULT_BOLD // Set bold font
                }
            },
            text2StringBuilder.indexOf("Privacy Policy"), // Start index of "Privacy Policy" in the string
            text2StringBuilder.indexOf("Privacy Policy") + "Privacy Policy".length, // End index of "Privacy Policy" in the string
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Span type
        )
        text2StringBuilder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.blueindt)), // Set text color to blue
            text2StringBuilder.indexOf("Terms of Service"), // Start index of "Terms of Service" in the string
            text2StringBuilder.indexOf("Terms of Service") + "Terms of Service".length, // End index of "Terms of Service" in the string
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Span type
        )
        text2StringBuilder.setSpan(
            object : ClickableSpan() {
                override fun onClick(view: View) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://membersgram.com/privacy/"))
                    view.context.startActivity(intent)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.isUnderlineText = false // Remove underline
                  //  ds.typeface = Typeface.DEFAULT_BOLD // Set bold font
                }
            },
            text2StringBuilder.indexOf("Terms of Service"), // Start index of "Terms of Service" in the string
            text2StringBuilder.indexOf("Terms of Service") + "Terms of Service".length, // End index of "Terms of Service" in the string
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Span type
        )
        text2.text = text2StringBuilder
        text2.textSize = 14F
        text2.setTextColor(Color.parseColor("#212121"))
        text2.movementMethod = LinkMovementMethod.getInstance()
        text2.setLineSpacing(20f, 1.0f)
        addView(text2)

        text3 = TextView(context)
        text3.text = "Data we process"
        text3.textSize = 14F
        text3.setTextColor(Color.parseColor("#212121"))// Set text color to black
        text3.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        addView(text3)

        text4 = TextView(context)
        text4.text = "We process your profile data (name, phone number)"
        text4.textSize = 14F
        text4.setTextColor(Color.parseColor("#212121"))// Set text color to black
        text4.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(text4)

        text5 = TextView(context)
        text5.text = "Data we process"
        text5.textSize = 14F
        text5.setTextColor(Color.parseColor("#212121"))
        text5.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)// Set text color to black
        addView(text5)

        text6 = TextView(context)
        text6.text = "We process your profile data (name, phone number)"
        text6.textSize = 14F
        text6.setTextColor(Color.parseColor("#212121")) // Set text color to black
        text6.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(text6)


        text7 = TextView(context)
        val text7StringBuilder = SpannableStringBuilder("By clicking Agree & Continue you agree to our Privacy Policy and Terms of Service")
        text7StringBuilder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.blueindt)), // Set text color to blue
            text7StringBuilder.indexOf("Privacy Policy"), // Start index of "Privacy Policy" in the string
            text7StringBuilder.indexOf("Privacy Policy") + "Privacy Policy".length, // End index of "Privacy Policy" in the string
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Span type
        )
        text7StringBuilder.setSpan(
            object : ClickableSpan() {
                override fun onClick(view: View) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://membersgram.com/privacy/"))
                    view.context.startActivity(intent)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.isUnderlineText = false // Remove underline
                  //  ds.typeface = Typeface.DEFAULT_BOLD // Set bold font
                }
            },
            text7StringBuilder.indexOf("Privacy Policy"), // Start index of "Privacy Policy" in the string
            text7StringBuilder.indexOf("Privacy Policy") + "Privacy Policy".length, // End index of "Privacy Policy" in the string
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Span type
        )
        text7StringBuilder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.blueindt)), // Set text color to blue
            text7StringBuilder.indexOf("Terms of Service"), // Start index of "Terms of Service" in the string
            text7StringBuilder.indexOf("Terms of Service") + "Terms of Service".length, // End index of "Terms of Service" in the string
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Span type
        )
        text7StringBuilder.setSpan(
            object : ClickableSpan() {
                override fun onClick(view: View) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://membersgram.com/tos/index.html"))
                    view.context.startActivity(intent)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.isUnderlineText = false // Remove underline
                  //  ds.typeface = Typeface.DEFAULT_BOLD // Set bold font
                }
            },
            text7StringBuilder.indexOf("Terms of Service"), // Start index of "Terms of Service" in the string
            text7StringBuilder.indexOf("Terms of Service") + "Terms of Service".length, // End index of "Terms of Service" in the string
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE // Span type
        )
        text7.text = text7StringBuilder
        text7.setTextColor(Color.GRAY)
        text7.textSize = 10F
        text7.gravity = Gravity.CENTER
        text7.setLineSpacing(20f, 1.0f)
        text7.movementMethod = LinkMovementMethod.getInstance()
        addView(text7)


        button = MaterialButton(context)
        button.text = "Accept and continue"
        button.textSize = 16f
        button.isAllCaps = false
        button.setBackgroundColor(Color.parseColor("#1976D2")) // Set button background color
        button.setTextColor(Color.WHITE) // Set button text color
        button.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        button.setPadding(0, 0, 0, 0) // Set top and bottom insets to 0dp
        button.minimumHeight = 0 // Set minimum height to 0
        button.minimumWidth = 0 // Set minimum width to 0
        button.insetTop = 0
        button.insetBottom = 0
        val radius = 60 // specify the radius in pixels
        val shapeAppearanceModel = button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        button.shapeAppearanceModel = shapeAppearanceModel
        addView(button)


    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        val imageWidth = imagemain.measuredWidth
        val imageHeight = imagemain.measuredHeight
        //image
        val Ileft = (parentWidth - imageWidth) / 2
        val Itop = Metrics.dpToPx(60)  // Set the top position to 0 to align with the top of the parent
        val Iright = Ileft + imageWidth
        val Ibottom = Itop + imageHeight
        imagemain.layout(Ileft, Itop, Iright, Ibottom)


        //Text1
        val tleft =l + Metrics.dpToPx(30)
        val ttop = Itop + imageHeight+ Metrics.dpToPx(10) + text1.measuredHeight  // Set the top position to 0 to align with the top of the parent
        val tright = tleft + text1.measuredWidth
        val tbottom = ttop+ text1.measuredHeight
        text1.layout(tleft, ttop, tright, tbottom)

        //Text2

        val t2left = l + Metrics.dpToPx(30)
        val t2top = ttop + Metrics.dpToPx(10)  + text2.measuredHeight// Set the top position to 0 to align with the top of the parent
        val t2right = t2left + text2.measuredWidth
        val t2bottom = t2top+ text2.measuredHeight
        text2.layout(t2left, t2top, t2right, t2bottom)




        //Text3

        val t3left = l + Metrics.dpToPx(30)
        val t3top = t2top + Metrics.dpToPx(30)+ text2.measuredHeight// Set the top position to 0 to align with the top of the parent
        val t3right = t3left + text3.measuredWidth
        val t3bottom =t3top + text3.measuredHeight
        text3.layout(t3left, t3top, t3right, t3bottom)



        //Text4

        val t4left = (parentWidth - text4.measuredWidth) / 2
        val t4top = t3top + Metrics.dpToPx(10)  + text3.measuredHeight// Set the top position to 0 to align with the top of the parent
        val t4right = t4left + text4.measuredWidth
        val t4bottom = t4top+ text4.measuredHeight
        text4.layout(t4left, t4top, t4right, t4bottom)

        //Text5

        val t5left = l + Metrics.dpToPx(30)
        val t5top = t4top + Metrics.dpToPx(30)+ text4.measuredHeight// Set the top position to 0 to align with the top of the parent
        val t5right = t5left + text5.measuredWidth
        val t5bottom =t5top + text5.measuredHeight
        text5.layout(t5left, t5top, t5right, t5bottom)

        //Text6

        val t6left = (parentWidth - text4.measuredWidth) / 2
        val t6top = t5top + Metrics.dpToPx(10)  + text5.measuredHeight// Set the top position to 0 to align with the top of the parent
        val t6right = t6left + text6.measuredWidth
        val t6bottom = t6top+ text6.measuredHeight
        text6.layout(t6left, t6top, t6right, t6bottom)





    //Text7

    val t7left = (parentWidth - text4.measuredWidth) / 2
    val t7top = parentHeight - text7.measuredHeight- Metrics.dpToPx(70)
    val t7right =t7left + text7.measuredWidth
    val t7bottom = t7top+ text7.measuredHeight
    text7.layout(t7left, t7top, t7right, t7bottom)



        // Line View
        val lineLeft = l
        val lineTop = t7top
        val lineRight = r
        val lineHeight = 1 // Set line height as desired
        val lineBottom = lineTop + lineHeight
        lineView.layout(lineLeft, lineTop, lineRight, lineBottom)



        // Login Button
        val buttonWidth = button.measuredWidth
        val buttonHeight = button.measuredHeight
        val buttonLeft = (parentWidth - buttonWidth) / 2
        val buttonTop = parentHeight - buttonHeight - Metrics.dpToPx(20)
        val buttonRight = buttonLeft + buttonWidth
        val buttonBottom = buttonTop + buttonHeight
        button.layout(buttonLeft, buttonTop, buttonRight, buttonBottom)


}



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        imagemain.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )


        text1.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        text2.measure(
            View.MeasureSpec.makeMeasureSpec(  Metrics.dpToPx(312), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(Metrics.dpToPx(54), View.MeasureSpec.EXACTLY)
        )

        text3.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )


        text4.measure(
            View.MeasureSpec.makeMeasureSpec(widthMeasureSpec-Metrics.dpToPx(60), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY)
        )


        text5.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        text6.measure(
            View.MeasureSpec.makeMeasureSpec(widthMeasureSpec-Metrics.dpToPx(60), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY)
        )

        text7.measure(
            View.MeasureSpec.makeMeasureSpec(widthMeasureSpec-Metrics.dpToPx(60), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY)
        )

        // Line View
        val lineViewHeight = 1 // Set line view height as desired
        lineView.measure(
            MeasureSpec.makeMeasureSpec(width , MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(lineViewHeight, MeasureSpec.EXACTLY)
        )


        button.measure(
            View.MeasureSpec.makeMeasureSpec( width -Metrics.dpToPx(48), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(Metrics.dpToPx(48), View.MeasureSpec.EXACTLY)
        )
    }
}

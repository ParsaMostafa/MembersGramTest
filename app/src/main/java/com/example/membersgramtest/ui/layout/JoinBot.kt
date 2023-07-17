package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class JoinBot(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
    val imagemain: ImageView
    val text1 : TextView
    val text2 : TextView

    val button : MaterialButton







    init {
        imagemain = ImageView(context)
        imagemain.setImageResource(R.drawable.join_bot)
        addView(imagemain)

        text1 = TextView(context)
        text1.text = "Join the bot"
        text1.textSize = 20F
        text1.setTextColor(Color.parseColor("#212121")) // Set text color to black
        text1.gravity = Gravity.CENTER
        text1.setTypeface(null, Typeface.BOLD)
        text1.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)// Set the typeface to bold
        addView(text1)

        text2 = TextView(context)
        text2.text = "Please take the time to review our Privacy Policy and Terms of Use below"
        text2.textSize = 14F
        text2.gravity =Gravity.CENTER
        text2.setPadding(0, Metrics.dpToPx(0), 7, 0)
        text2.setLineSpacing(20f, 1.0f)
        text2.setTextColor(Color.parseColor("#212121"))
        text2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(text2)



        button = MaterialButton(context)
        button.text = "Join and get started "
        button.textSize = 16f
        button.isAllCaps = false
        button.setBackgroundColor(Color.parseColor("#1976D2")) // Set button background color
        button.setTextColor(Color.WHITE) // Set button text color
        button.setPadding(0,0,0,0)
        button.insetTop = 0
        button.insetBottom = 0
        button.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
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
        val tleft = (parentWidth - text1.measuredWidth) / 2
        val ttop = Itop + imageHeight+ Metrics.dpToPx(10) + text1.measuredHeight  // Set the top position to 0 to align with the top of the parent
        val tright = tleft + text1.measuredWidth
        val tbottom = ttop+ text1.measuredHeight
        text1.layout(tleft, ttop, tright, tbottom)

        //Text2

        val t2left = (parentWidth - text2.measuredWidth) / 2
        val t2top = ttop  + text2.measuredHeight// Set the top position to 0 to align with the top of the parent
        val t2right = t2left + text2.measuredWidth
        val t2bottom = t2top+ text2.measuredHeight
        text2.layout(t2left, t2top, t2right, t2bottom)




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
            View.MeasureSpec.makeMeasureSpec(widthMeasureSpec-Metrics.dpToPx(70), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY)
        )


        button.measure(
            View.MeasureSpec.makeMeasureSpec( width -Metrics.dpToPx(48), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(Metrics.dpToPx(48), View.MeasureSpec.EXACTLY)
        )
    }
}

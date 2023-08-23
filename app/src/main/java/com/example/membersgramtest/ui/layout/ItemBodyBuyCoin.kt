package com.example.membersgramtest.ui.layout

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class ItemBodyBuyCoin (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    var button: MaterialButton
    val discountStringCoin : TextView
    val imageView : ImageView
    val textCoin : TextView






    init {


       // Create a MaterialButton instance
        button = MaterialButton(context)

       // Set the button properties
        button.text = "3,900"
        button.isAllCaps = false
        button.textSize = 14f
        button.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        button.insetTop = 0
        button.insetBottom = 0

        // Set the corner radius for rounded corners
        val radius = context.resources.getDimensionPixelSize(R.dimen.corner_radius)

        // Create a shapeAppearanceModel with rounded corners
        val shapeAppearanceModel = button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()

        // Apply the shapeAppearanceModel to the button
        button.shapeAppearanceModel = shapeAppearanceModel

        // Set the border
        val borderColor = 0xFFE7E7E7.toInt() // Convert color to integer value
        val borderWidth = context.resources.getDimensionPixelSize(R.dimen.border_width)

        // Create a ColorStateList for the border color
        val borderColors = ColorStateList.valueOf(borderColor)

        // Set the border stroke color and width
        button.strokeWidth = borderWidth
        button.strokeColor = borderColors

        // Disable the shadow (remove elevation animations)
        button.stateListAnimator = null

        // Add the button to the view

        button.setBackgroundColor(Color.WHITE)
        button.setTextColor(Color.parseColor("#1976D2"))
        addView(button)




        //discountstringcoin
        discountStringCoin = TextView(context)
        discountStringCoin.background = ContextCompat.getDrawable(context, R.drawable.shape)
        discountStringCoin.text = "55%"
        discountStringCoin.setTextColor(Color.parseColor("#C62828"))
        discountStringCoin.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        discountStringCoin.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        discountStringCoin.gravity = Gravity.CENTER
        addView(discountStringCoin)


         // Imageview

        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.person_bue_24dp__2_)
        addView(imageView)

        //textCoin
        textCoin = TextView(context)
        textCoin.text = "200 Coins"
        textCoin.setTextColor(Color.parseColor("#212121"))
        textCoin.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textCoin.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textCoin)




    }





    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // buttun
        val br = parentWidth - Metrics.dpToPx(16)
        val bt = Metrics.dpToPx(18)
        val bl = br - button.measuredWidth
        val Bb = bt + button.measuredHeight
        button.layout(bl,bt,br,Bb)


        // discount string
        val discountRight =  bl - Metrics.dpToPx(8)
        val discountTop = Metrics.dpToPx(24)
        val discountLeft = discountRight - discountStringCoin.measuredWidth
        val discountBottom = discountTop + discountStringCoin.measuredHeight
        discountStringCoin.layout(discountLeft, discountTop, discountRight, discountBottom)


        // image view
         val imgl = Metrics.dpToPx(16)
         val imgt = Metrics.dpToPx(8)
         val imgr = imgl + imageView.measuredWidth
         val imgb = imgt + imageView.measuredHeight
        imageView.layout(imgl,imgt,imgr,imgb)

        // textCoin
        val coinl = imgr + Metrics.dpToPx(8)
        val coint = Metrics.dpToPx(27)
        val coinr = coinl + textCoin.measuredWidth
        val coinb = coint + textCoin.measuredHeight
        textCoin.layout(coinl,coint,coinr,coinb)




    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)


        button.measure(
            Measure.wrapContentSpec,
            Measure.getExactSpec(Metrics.dpToPx(36))
        )

        discountStringCoin.measure(
            Measure.getExactSpec(Metrics.dpToPx(30)),
            Measure.getExactSpec(Metrics.dpToPx(24))
        )

        imageView.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )
        textCoin.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        // Set the measured dimensions of this ViewGroup
        setMeasuredDimension(width, Metrics.dpToPx(36)+ button.measuredHeight  )
    }
}
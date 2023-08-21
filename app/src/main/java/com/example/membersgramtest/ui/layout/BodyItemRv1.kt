package com.example.membersgramtest.ui.layout

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily


class BodyItemRv1 (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val bt: MaterialButton
    val imageView: ImageView // Declare ImageView instance
    var flag: Boolean = true
    var isConditionMet = true // Your condition check here


    init {
    // Create a MaterialButton instance and set its properties
        bt = MaterialButton(context)
        bt.text = "OnePost"
        bt.isAllCaps = false

    // Set the background color of the button
        val color = Color.parseColor("#E3F2FD")
        bt.backgroundTintList = ColorStateList.valueOf(color)

    // Set the text color of the button
        val textColor = Color.parseColor("#616161")
        bt.setTextColor(textColor)

     // Set the size of the button's text
        bt.setTextSize(14F)

    // Set the typeface (font) for the button's text
        bt.typeface = ResourcesCompat.getFont(MyApp.appContext, R.font.producsansmedium)

    // Set top and bottom insets for the button
        bt.insetTop = 0
        bt.insetBottom = 0

// Specify the radius for rounded corners in pixels
        val radius = 60
        val shapeAppearanceModel = bt.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        bt.shapeAppearanceModel = shapeAppearanceModel

        val borderColor = Color.parseColor("#E0E0E0") // Change the color as needed
        val borderWidth = context.resources.getDimensionPixelSize(R.dimen.border_width)

       // Create a ColorStateList for the border color
        val borderColors = ColorStateList.valueOf(borderColor)

        // Set the border stroke color and width
        bt.strokeWidth = borderWidth
        bt.strokeColor = borderColors

        // Set the letter spacing (adjust the value as needed)
        bt.letterSpacing = 0.0f

       // Disable the shadow (remove elevation animations)
        bt.stateListAnimator = null
        // Add the button to its parent view
        addView(bt)



        // Create an ImageView instance
        imageView = ImageView(context)
        // Set the image resource for the ImageView
        imageView.setImageResource(R.drawable.icons8_globe_1)
        // Add the ImageView to the parent view (BodyItemRv1)
        imageView.visibility = View.INVISIBLE
        addView(imageView)


    }

    fun setButtonText(text: String) {
        bt.text = text
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        val buttonWidth = bt.measuredWidth
        val buttonHeight = bt.measuredHeight

        val buttonLeft = (parentWidth - buttonWidth) / 2
        val buttonTop = (parentHeight - buttonHeight) / 2




        bt.layout(buttonLeft, buttonTop, buttonLeft + buttonWidth, buttonTop + buttonHeight)


        // Calculate the position for the ImageView
        val imageLeft: Int = if (flag) {
            buttonLeft - imageView.measuredWidth + Metrics.dpToPx(33) // global
        } else {
            buttonLeft - imageView.measuredWidth + Metrics.dpToPx(35) // Adjust spacing as needed
        }

        val imageTop = (parentHeight - imageView.measuredHeight) / 2

        // Layout the ImageView
        imageView.layout(
            imageLeft,
            imageTop,
            imageLeft + imageView.measuredWidth,
            imageTop + imageView.measuredHeight
        )


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)

        // Check a condition (for example, if a certain flag is set)
        imageView.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec


        )

        if (isConditionMet) {
            bt.measure(
                Measure.wrapContentSpec,
                Measure.getExactSpec(Metrics.dpToPx(36))
            )
        } else {
            // Adjust button measurements based on the condition
            bt.measure(
                Measure.getExactSpec(Metrics.dpToPx(100)), // Adjust width as needed
                Measure.getExactSpec(Metrics.dpToPx(36))
            )



        }
        setMeasuredDimension(
            bt.measuredWidth + Metrics.dpToPx(8),
            bt.measuredHeight + Metrics.dpToPx(42)
        )
    }
}





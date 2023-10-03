package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class ChipsOfPaymentLayout (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {


    val Buttonfiltered = MaterialButton(context).apply {
        text = "Transfer"
        textSize = 16f
        isAllCaps = false
        setBackgroundColor(Color.WHITE)
        setTextColor(Color.parseColor("#1976D2"))
        setPadding(0, 0, 0, 0)
        insetTop = 0
        insetBottom = 0
        typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        letterSpacing = 0.0f



        setBackgroundColor(Color.WHITE)
    }


    init {
        // Get the corner radius from the dimension resource
        val radiuse = context.resources.getDimensionPixelSize(R.dimen.corner_radius)

        // Create a shapeAppearanceModel with rounded corners
        val shapeAppearanceModele = Buttonfiltered.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radiuse.toFloat())
            .build()

        // Apply the shapeAppearanceModel to the SButton
        Buttonfiltered.shapeAppearanceModel = shapeAppearanceModele
        addView(Buttonfiltered)

    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t



        // Buttonfiltered

        val chipsLeft = Metrics.dpToPx(16)
        val chipsTop =  parentHeight / 2   - Buttonfiltered.measuredHeight / 2
        val chipsRight = chipsLeft + Buttonfiltered.measuredWidth
        val chipsBottom = parentHeight / 2   + Buttonfiltered.measuredHeight / 2

        Buttonfiltered.layout( chipsLeft , chipsTop , chipsRight , chipsBottom )


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)


        Buttonfiltered.measure(
            Measure.wrapContentSpec,
            Measure.getExactSpec(Metrics.dpToPx(36))
        )


        setMeasuredDimension(
            Buttonfiltered.measuredWidth + Metrics.dpToPx(25),
            Buttonfiltered.measuredHeight + Metrics.dpToPx(42)
        )
    }

}


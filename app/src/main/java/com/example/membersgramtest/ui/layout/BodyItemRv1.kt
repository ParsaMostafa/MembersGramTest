package com.example.membersgramtest.ui.layout

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.example.membersgramtest.utillity.Metrics.setSize
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class BodyItemRv1 (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val bt : MaterialButton




    init {
        bt = MaterialButton(context)
        bt.text = "SinglePost"
        bt.isAllCaps = false
        val color = Color.parseColor("#E0E0E0")
        bt.backgroundTintList = ColorStateList.valueOf(color)
        val textColor = Color.parseColor("#1565C0")
        bt.setTextColor(textColor)
        bt.setSize(14)
        bt.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        bt.insetTop = 0
        bt.insetBottom = 0
        val radiuss = 60 // specify the radius in pixels
        val shapeAppearanceModellb = bt.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radiuss.toFloat())
            .build()
        bt.shapeAppearanceModel = shapeAppearanceModellb
        addView(bt)

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
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)

        measureChild(bt, Measure.wrapContentSpec,Measure.wrapContentSpec)

        setMeasuredDimension(Metrics.dpToPx(120), Metrics.dpToPx(70))
    }

}





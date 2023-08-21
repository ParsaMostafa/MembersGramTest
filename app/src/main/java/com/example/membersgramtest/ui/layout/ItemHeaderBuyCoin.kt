package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.membersgramtest.R

class ItemHeaderBuyCoin(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val borderPaint = Paint()
    private val desiredBorderWidth = context.resources.displayMetrics.density * 8 // 8dp border
    private val desiredHeight = context.resources.displayMetrics.density * 89 // 89dp height

    init {
        val borderColor = ContextCompat.getColor(context, R.color.blueindt)
        borderPaint.color = borderColor
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = desiredBorderWidth
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        // Place child views within the parent view as needed
        // You can use child.layout(left, top, right, bottom) here
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Measure child views and calculate the size of this view
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = desiredHeight.toInt()
        setMeasuredDimension(width, height)
    }

    override fun dispatchDraw(canvas: Canvas) {
        // Draw the border using the canvas
        val halfBorderWidth = borderPaint.strokeWidth / 2
        canvas.drawRect(
            halfBorderWidth,
            halfBorderWidth,
            width - halfBorderWidth,
            desiredHeight.toFloat(),
            borderPaint
        )
        super.dispatchDraw(canvas)
    }
}

package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Metrics

class ItemHeaderBuyCoin(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val backgroundColor = ContextCompat.getColor(context, R.color.light_blue) // #E3F2FD

    private val backgroundPaint = Paint()
    private val shadowPaint = Paint()

    private val desiredHeight = context.resources.displayMetrics.density * 89 // 89dp height
    private val horizontalPadding = context.resources.displayMetrics.density * 16 // 16dp padding
    private val topPadding = context.resources.displayMetrics.density * 16 // 16dp padding from the top
    private val cornerRadius = context.resources.displayMetrics.density * 5 // 5dp corner radius
    private val shadowRadius = context.resources.displayMetrics.density * 10 // 10dp shadow radius
    private val shadowOffsetX = context.resources.displayMetrics.density * 0 // No horizontal shadow offset
    private val shadowOffsetY = context.resources.displayMetrics.density * 4 // 4dp vertical shadow offset

    init {
        backgroundPaint.color = backgroundColor
        backgroundPaint.style = Paint.Style.FILL

        // Create a BlurMaskFilter for the shadow paint
        val blurMaskFilter = BlurMaskFilter(shadowRadius, BlurMaskFilter.Blur.NORMAL)
        shadowPaint.maskFilter = blurMaskFilter
        shadowPaint.color = ContextCompat.getColor(context, android.R.color.darker_gray)
        shadowPaint.style = Paint.Style.FILL
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        // Place child views within the parent view as needed
        // You can use child.layout(left, top, right, bottom) here
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Measure child views and calculate the size of this view
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = desiredHeight.toInt()
        setMeasuredDimension(width, Metrics.dpToPx(105))
    }

    override fun dispatchDraw(canvas: Canvas) {
        // Draw the background color with shadow using the canvas
        val left = horizontalPadding
        val right = width - horizontalPadding
        val top = topPadding
        val bottom = desiredHeight.toFloat()

        // Draw shadow first
        canvas.drawRoundRect(left + shadowOffsetX, top + shadowOffsetY, right + shadowOffsetX, bottom + shadowOffsetY, cornerRadius, cornerRadius, shadowPaint)

        // Draw the background color
        canvas.drawRoundRect(left, top, right, bottom, cornerRadius, cornerRadius, backgroundPaint)

        super.dispatchDraw(canvas)
    }
}

package com.example.membersgramtest.ui.layout

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.TextureView
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

class ItemHeaderBuyCoin(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val backgroundColor = ContextCompat.getColor(context, R.color.light_blue) // #E3F2FD

    private val backgroundPaint = Paint()
    private val shadowPaint = Paint()

    private val desiredHeight = Metrics.dpToPx(99)// 89dp height
    private val horizontalPadding =  Metrics.dpToPx(16f) // 16dp padding
    private val topPadding =  Metrics.dpToPx(16f) // 16dp padding from the top
    private val cornerRadius =  Metrics.dpToPx(5f)  // 5dp corner radius
    private val shadowRadius =  Metrics.dpToPx(10f)  // 10dp shadow radius
    private val shadowOffsetX = Metrics.dpToPx(0f)  // No horizontal shadow offset
    private val shadowOffsetY =   Metrics.dpToPx(4f) // 4dp vertical shadow offset


    val button : MaterialButton
    var textviewtime : TextView
    val textviewdiscountprice : TextView
    val imageView : ImageView
    val textviewcoin : TextView
    val todayText : TextView



    init {
        backgroundPaint.color = backgroundColor
        backgroundPaint.style = Paint.Style.FILL

        // Create a BlurMaskFilter for the shadow paint
        val blurMaskFilter = BlurMaskFilter(shadowRadius, BlurMaskFilter.Blur.NORMAL)
        shadowPaint.maskFilter = blurMaskFilter
        shadowPaint.color = ContextCompat.getColor(context, android.R.color.darker_gray)
        shadowPaint.style = Paint.Style.FILL



        // button

        button = MaterialButton(context)
        button.text = "900"
        button.isAllCaps = false
        button.textSize = 14f
        button.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        button.insetTop = 0
        button.insetBottom = 0

// Set the corner radius for rounded corners
        val radius = context.resources.getDimensionPixelSize(R.dimen.corner_radius).toFloat()

// Create a shapeAppearanceModel with rounded corners
        val shapeAppearanceModel = button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius)
            .build()

          // Apply the shapeAppearanceModel to the button
        button.shapeAppearanceModel = shapeAppearanceModel

        // Set the border
        val borderColor = Color.parseColor("#1B6199") // Border color #1B6199
        val borderWidth = context.resources.getDimensionPixelSize(R.dimen.border_width)

       // Create a ColorStateList for the border color
        val borderColors = ColorStateList.valueOf(borderColor)

        // Set the border stroke color and width
        button.strokeWidth = borderWidth
        button.strokeColor = borderColors

         // Set the background color
        val backgroundColor = Color.parseColor("#E3F2FD") // Background color #E3F2FD
        button.backgroundTintList = ColorStateList.valueOf(backgroundColor)

        // Set the text color
        val textColor = Color.parseColor("#1B6199") // Text color #1B6199
        button.setTextColor(textColor)

       // Disable the shadow (remove elevation animations)
        button.stateListAnimator = null
        button.letterSpacing = 0.0f

       // Add the button to the view hierarchy
        addView(button)



        // TextView
        textviewtime = TextView(context)
        textviewtime.text = "39 : 27 : 14"
        textviewtime.setTextColor(Color.parseColor("#1B6199"))
        textviewtime.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textviewtime.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textviewtime)


        // TextView
        textviewdiscountprice = TextView(context)
        textviewdiscountprice.text = "5,900"
        textviewdiscountprice.setTextColor(Color.parseColor("#1B6199"))
        textviewdiscountprice.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
        textviewdiscountprice.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        textviewdiscountprice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        addView(textviewdiscountprice)


        //imageview
        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.group_2167)
        addView(imageView)

        //texiviewcoin
        textviewcoin = TextView(context)
        textviewcoin.text = "1,000 Coin"
        textviewcoin.setTextColor(Color.parseColor("#1B6199"))
        textviewcoin.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textviewcoin.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        addView(textviewcoin)

        // TextView "Today's special package"
        todayText = TextView(context)
        todayText.text = "Today's special package"
        todayText.setTextColor(Color.parseColor("#1B6199"))
        todayText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        todayText.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        addView(todayText)



    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // button
        val buttonRight = parentWidth - Metrics.dpToPx(32)
        val buttonTop = topPadding + Metrics.dpToPx(27)
        val buttonLeft = buttonRight - button.measuredWidth
        val buttonBottom = buttonTop + button.measuredHeight
        button.layout(buttonLeft, buttonTop.toInt(), buttonRight, buttonBottom.toInt())

        // textviewtime
        val textviewtimeRight = parentWidth - Metrics.dpToPx(50)
        val textviewtimeTop = topPadding + Metrics.dpToPx(7)
        val textviewtimeLeft = textviewtimeRight - textviewtime.measuredWidth
        val textviewtimeBottom = textviewtimeTop + textviewtime.measuredHeight
        textviewtime.layout(textviewtimeLeft, textviewtimeTop.toInt(), textviewtimeRight, textviewtimeBottom.toInt())

        // textviewdiscountprice
        val textviewdiscountRight = parentWidth - Metrics.dpToPx(59)
        val textviewdiscountTop = buttonBottom + Metrics.dpToPx(4) // Adjust the spacing as needed
        val textviewdiscountLeft = textviewdiscountRight - textviewdiscountprice.measuredWidth
        val textviewdiscountBottom = textviewdiscountTop + textviewdiscountprice.measuredHeight
        textviewdiscountprice.layout(textviewdiscountLeft, textviewdiscountTop.toInt(), textviewdiscountRight, textviewdiscountBottom.toInt())


        // imageview
        val imgl = Metrics.dpToPx(33)
        val imgt =  Metrics.dpToPx(33)
        val imgr = imgl + imageView.measuredWidth
        val imgb = imgt + imageView.measuredHeight
        imageView.layout(imgl,imgt,imgr,imgb)

        // textviewcoin
        val coinLeft = imgl + imageView.measuredWidth + Metrics.dpToPx(16) // Adjust the left position as needed
        val cointTop = Metrics.dpToPx(33) // Adjust the top position as needed
        val coinRight = coinLeft + textviewcoin.measuredWidth
        val coinBottom = cointTop + textviewcoin.measuredHeight
        textviewcoin.layout(coinLeft, cointTop, coinRight, coinBottom)

       // todayText
        val todayLeft = imgl + imageView.measuredWidth + Metrics.dpToPx(16) // Adjust the left position as needed
        val todayTop = cointTop + textviewcoin.measuredHeight + Metrics.dpToPx(8) // Adjust the top position as needed
        val todayRight = todayLeft + todayText.measuredWidth
        val todayBottom = todayTop + todayText.measuredHeight
        todayText.layout(todayLeft, todayTop, todayRight, todayBottom)


    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Measure child views and calculate the size of this view
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = desiredHeight.toInt()


        button.measure(
            Measure.wrapContentSpec,
            Measure.getExactSpec(Metrics.dpToPx(36))
        )

        textviewtime.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )
        textviewdiscountprice.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        imageView.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )
        textviewcoin.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )
        todayText.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )


        setMeasuredDimension(width, Metrics.dpToPx(58)+textviewtime.measuredHeight+button.measuredHeight)
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

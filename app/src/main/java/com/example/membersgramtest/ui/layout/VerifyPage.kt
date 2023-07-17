package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class VerifyPage(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ViewGroup(context, attrs, defStyleAttr) {
    private val text1: TextView
    private val text2: TextView
    val phoneNumInputLayout: TextInputLayout
    val phoneNumEditText: EditText
    val fab : ImageView



    init {
        text1 = TextView(context)
        text1.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        text1.gravity = Gravity.CENTER
        text1.setTextColor(Color.parseColor("#212121"))
        text1.textSize = 20F
        text1.text = "Your Phone Number"
        addView(text1)

        text2 = TextView(context)
        text2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        text2.gravity = Gravity.CENTER
        val x = android.R.attr.textColorSecondary
        val typedValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.textColorSecondary, typedValue, true)
        val color = ContextCompat.getColor(context, typedValue.resourceId)

        text2.setTextColor(color)
        text2.textSize = 14F
        text2.text = "Please confirm your country code and enter your phone number"
        addView(text2)

        phoneNumInputLayout = TextInputLayout(ContextThemeWrapper(context, R.style.TextInputLayoutOutlinedBox))
        phoneNumEditText = TextInputEditText(phoneNumInputLayout.context)




        phoneNumEditText.hint = "Enter Your Number"
        phoneNumInputLayout.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val colorr = ContextCompat.getColor(context, R.color.white)
        phoneNumInputLayout.setBoxBackgroundColor(colorr)




        phoneNumInputLayout.addView(phoneNumEditText,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ))
        addView(phoneNumInputLayout)



        fab = ImageView(context)
        fab.setImageResource(R.drawable.group_17309) // Set your next flash icon here
        fab.isClickable = true
        fab.isFocusable = true
        fab.setBackgroundResource(R.drawable.fab) // Set your blue background here
        addView(fab)


    }
    fun setFabAction(action: () -> Unit) {
        fab.setOnClickListener { action() }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // Layout text1 TextView
        val left = (parentWidth - text1.measuredWidth) / 2
        val top = t + Metrics.dpToPx(260)
        val right = left + text1.measuredWidth
        val bottom = top + text1.measuredHeight
        text1.layout(left, top, right, bottom)

        // Layout text2 TextView
        val leftt = (parentWidth - text2.measuredWidth) / 2
        val topp = top + Metrics.dpToPx(30)
        val rightt = leftt + text2.measuredWidth
        val bottomm = topp + text2.measuredHeight
        text2.layout(leftt, topp, rightt, bottomm)

        // Layout phoneNumInputLayout
        val lefti = (parentWidth - phoneNumInputLayout.measuredWidth) / 2
        val topi = (parentHeight - phoneNumInputLayout.measuredHeight) / 2
        val righti = lefti + phoneNumInputLayout.measuredWidth
        val bottomi = topi + phoneNumInputLayout.measuredHeight
        phoneNumInputLayout.layout(lefti, topi, righti, bottomi)

        //layout fab
        val fabLeft = parentWidth - fab.measuredWidth - Metrics.dpToPx(16)
        val fabTop = parentHeight - fab.measuredWidth - Metrics.dpToPx(16)
        val fabRight = fabLeft + fab.measuredWidth
        val fabBottom = fabTop + fab.measuredHeight
        fab.layout(fabLeft, fabTop, fabRight, fabBottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)

        // Measure text1 TextView
        text1.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        // Measure text2 TextView
        text2.measure(
            Measure.getExactSpec(width - Metrics.dpToPx(80)),
            Measure.getExactSpec(Metrics.dpToPx(50))
        )

        // Measure phoneNumInputLayout
        phoneNumInputLayout.measure(
            Measure.getExactSpec(width - Metrics.dpToPx(70)),
            Measure.getExactSpec(Metrics.dpToPx(100))
        )

        // Measure fab
        fab.measure(
            Measure.getExactSpec(Metrics.dpToPx(60)),
            Measure.getExactSpec(Metrics.dpToPx(60))
        )


        setMeasuredDimension(width, height)

    }
}


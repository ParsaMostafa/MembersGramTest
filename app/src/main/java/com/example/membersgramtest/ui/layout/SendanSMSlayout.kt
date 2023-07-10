package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class SendanSMSlayout (context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ViewGroup(context, attrs, defStyleAttr) {
    private val text1: TextView
    private val text2: TextView
    private val phoneNumInputLayout: TextInputLayout
     val phoneNumEditText: EditText




    init {
        text1 = TextView(context)
        text1.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        text1.gravity = Gravity.CENTER
        text1.setTextColor(Color.parseColor("#212121"))
        text1.textSize = 20F
        text1.text = "EnterCode"
        addView(text1)

        text2 = TextView(context)
        text2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        text2.gravity = Gravity.CENTER
        text2.setTextColor(Color.parseColor("#E7E7E7"))
        text2.textSize = 14F
        text2.text = "Were Send An SMS with activation code"
        addView(text2)

        phoneNumInputLayout = TextInputLayout(ContextThemeWrapper(context, R.style.TextInputLayoutOutlinedBox))
        phoneNumEditText = TextInputEditText(phoneNumInputLayout.context)




        phoneNumEditText.hint = "Enter Code"
        phoneNumInputLayout.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE


        phoneNumInputLayout.addView(phoneNumEditText,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ))
        addView(phoneNumInputLayout)





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
            Measure.getExactSpec(Metrics.dpToPx(80))
        )




    }
}

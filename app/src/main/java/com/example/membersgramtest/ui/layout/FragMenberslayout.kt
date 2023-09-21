package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.InputType
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FragMenberslayout ( context: Context,
                          attrs: AttributeSet? = null,
                          defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    // Title TextView for coin transfer
    val transferLayoutTitle = TextView(context).apply {
        text = "Coin transfer"
        textSize = 16F
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
    }


    // TextInputLayout and EditText for country code
    val countryCodeInputLayout = TextInputLayout(ContextThemeWrapper(context, R.style.TextInputLayoutOutlinedBox)).apply {
        boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val color = ContextCompat.getColor(context, R.color.white)
        boxBackgroundColor = color
    }

    val countryCodeEditText = TextInputEditText(countryCodeInputLayout.context).apply {
        showSoftInputOnFocus = false
        isFocusable = false
        isClickable = false
        isLongClickable = false
        inputType = InputType.TYPE_NULL
        setText("98")
        id = R.id.transferCoinCountryEditText // Make sure to set the correct ID

    }



    // TextInputLayout and EditText for phone number
    val phoneNumberInputLayout = TextInputLayout(ContextThemeWrapper(context, R.style.TextInputLayoutOutlinedBox)).apply {
        setErrorTextAppearance(R.style.TextInputLayoutOutlinedBox)
        hint = "Receiver number"
        boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val color4 = ContextCompat.getColor(context, R.color.white)
        boxBackgroundColor = color4
    }

    val phoneNumberEditText = TextInputEditText(phoneNumberInputLayout.context).apply {
        id = R.id.transferCoinPhoneEditText
    }



    // TextInputLayout and EditText for number of coins
    val coinNumberInputLayout = TextInputLayout(ContextThemeWrapper(context, R.style.TextInputLayoutOutlinedBox)).apply {
        setErrorTextAppearance(R.style.TextInputLayoutOutlinedBox)
        hint = "Number of coins"
        boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val color4 = ContextCompat.getColor(context, R.color.white)
        boxBackgroundColor = color4
    }

    val coinNumberEditText = TextInputEditText(coinNumberInputLayout.context).apply {
        id = R.id.transferCoinNumberOfCoinEditText
    }



    // Transfers Button
    val transferButton = MaterialButton(context).apply {
        text = "Transfer"
        textSize = 16f
        isAllCaps = false
        setBackgroundColor(Color.parseColor("#1976D2"))
        setTextColor(Color.WHITE)
        setPadding(0, 0, 0, 0)
        insetTop = 0
        insetBottom = 0
        typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)

        val radius = 60 // specify the radius in pixels
        val shapeAppearanceModel = shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        this.shapeAppearanceModel = shapeAppearanceModel // "this" refers to the button itself
        id = R.id.transferCoinButton
    }


    init {
        // Add child views to your custom ViewGroup
        addView(transferLayoutTitle)

        // Country Code
        countryCodeInputLayout.addView(countryCodeEditText, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ))
        addView(countryCodeInputLayout)

        // Phone Number
        phoneNumberInputLayout.addView(phoneNumberEditText, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ))
        addView(phoneNumberInputLayout)

        // CoinBox
        coinNumberInputLayout.addView(coinNumberEditText, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ))
        addView(coinNumberInputLayout)


        //TransferButton
        addView(transferButton)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // Transfer Layout Title
        val titleLeft = Metrics.dpToPx(16)
        val titleTop =  Metrics.dpToPx(23)
        val titleRight = titleLeft + transferLayoutTitle.measuredWidth
        val titleBottom = titleTop + transferLayoutTitle.measuredHeight
        transferLayoutTitle.layout(titleLeft, titleTop, titleRight, titleBottom)

        // Layout Country Code
        val leftCountryCode = Metrics.dpToPx(16)
        val topCountryCode = titleBottom + Metrics.dpToPx(31)
        val rightCountryCode = leftCountryCode + countryCodeInputLayout.measuredWidth
        val bottomCountryCode = topCountryCode + countryCodeInputLayout.measuredHeight
        countryCodeInputLayout.layout(leftCountryCode, topCountryCode, rightCountryCode, bottomCountryCode)

        // Layout Phone Number
        val leftPhoneNumber = rightCountryCode + Metrics.dpToPx(10)
        val topPhoneNumber = titleBottom + Metrics.dpToPx(32)
        val rightPhoneNumber = leftPhoneNumber + phoneNumberInputLayout.measuredWidth
        val bottomPhoneNumber = topPhoneNumber + phoneNumberInputLayout.measuredHeight
        phoneNumberInputLayout.layout(leftPhoneNumber, topPhoneNumber, rightPhoneNumber, bottomPhoneNumber)

        // Layout Coin Input Layout
        val leftCoinInputLayout = Metrics.dpToPx(16)
        val topCoinInputLayout = bottomCountryCode + Metrics.dpToPx(33)
        val rightCoinInputLayout = leftCoinInputLayout + coinNumberInputLayout.measuredWidth
        val bottomCoinInputLayout = topCoinInputLayout + coinNumberInputLayout.measuredHeight
        coinNumberInputLayout.layout(leftCoinInputLayout, topCoinInputLayout, rightCoinInputLayout, bottomCoinInputLayout)


        // Login Button
        val buttonWidth = transferButton.measuredWidth
        val buttonHeight = transferButton.measuredHeight
        val buttonLeft = (parentWidth - buttonWidth) / 2
        val buttonTop = bottomCoinInputLayout + Metrics.dpToPx(32)
        val buttonRight = buttonLeft + buttonWidth
        val buttonBottom = buttonTop + buttonHeight
        transferButton.layout(buttonLeft, buttonTop, buttonRight, buttonBottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)


        // Measure Title
        transferLayoutTitle.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        // Measure Country Code Input Layout
        countryCodeInputLayout.measure(
            Measure.getExactSpec(Metrics.dpToPx(64)),
            Measure.wrapContentSpec
        )

        // Measure Phone Number Input Layout
        phoneNumberInputLayout.measure(
            Measure.getExactSpec(width - Metrics.dpToPx(105)),
            Measure.wrapContentSpec
        )

        // Measure Coin Input Layout
        coinNumberInputLayout.measure(
            Measure.getExactSpec(width - Metrics.dpToPx(35)),
            Measure.wrapContentSpec
        )

        //  Measure TransferButton
        transferButton.measure(
            Measure.getExactSpec(Metrics.dpToPx(380)),
            Measure.getExactSpec(Metrics.dpToPx(60))
        )



        setMeasuredDimension(
            width,
            height
        )
    }
}

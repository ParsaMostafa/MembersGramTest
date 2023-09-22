package com.example.membersgramtest.ui.layout

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
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
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputEditText

class CoinTransferLayout(
    context: Context,
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
        val cornerRadius = resources.getDimension(R.dimen.corner_radiusR) // Replace with your desired float value resource
        setBoxCornerRadii(cornerRadius, cornerRadius, cornerRadius, cornerRadius)

    }

    val countryCodeEditText = TextInputEditText(countryCodeInputLayout.context).apply {
        showSoftInputOnFocus = false
        isFocusable = false
        isClickable = false
        isLongClickable = false
        inputType = InputType.TYPE_NULL
        setText("98")
        id = R.id.transferCoinCountryEditText // Make sure to set the correct ID
        letterSpacing = 0.0f

    }



    val phoneNumberInputLayout = TextInputLayout(context).apply {
        val customTypeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        setErrorTextAppearance(R.style.CustomErrorAppearance)
        setHintTextAppearance(R.style.CustomErrorAppearance)




        hint = "Receiver number"
        boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val color4 = ContextCompat.getColor(context, R.color.white)
        boxBackgroundColor = color4
        val cornerRadius = resources.getDimension(R.dimen.corner_radiusR) // Replace with your desired float value resource
        setBoxCornerRadii(cornerRadius, cornerRadius, cornerRadius, cornerRadius)




    }

    val phoneNumberEditText = TextInputEditText(phoneNumberInputLayout.context).apply {
        id = R.id.transferCoinPhoneEditText
        inputType = InputType.TYPE_CLASS_NUMBER
        setTextColor(Color.parseColor("#212121"))
        typeface = ResourcesCompat.getFont(context ,R.font.product_sans_regular)

        val paddingTop = 40 // Adjust this value as needed
        val paddingBottom = 40 // Adjust this value as needed
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
        letterSpacing = 0.0f
    }





    // TextInputLayout and EditText for number of coins
    val coinNumberInputLayout = TextInputLayout(context).apply {
        setErrorTextAppearance(R.style.CustomErrorAppearance)
        setHintTextAppearance(R.style.CustomErrorAppearance)
        val cornerRadius = resources.getDimension(R.dimen.corner_radiusR) // Replace with your desired float value resource
        setBoxCornerRadii(cornerRadius, cornerRadius, cornerRadius, cornerRadius)
        hint = "Number of coins"
        boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val color4 = ContextCompat.getColor(context, R.color.white)
        boxBackgroundColor = color4

    }

     val coinNumberEditText = TextInputEditText(coinNumberInputLayout.context).apply {
         id = R.id.transferCoinNumberOfCoinEditText
         inputType = InputType.TYPE_CLASS_NUMBER
         setTextColor(Color.parseColor("#212121"))
         typeface = ResourcesCompat.getFont(context ,R.font.product_sans_regular)

         val paddingTop = 40 // Adjust this value as needed
         val paddingBottom = 40 // Adjust this value as needed
         setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
         letterSpacing = 0.0f

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
        letterSpacing = 0.0f

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
            LinearLayout.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.button_padding)
        ))
        addView(countryCodeInputLayout)

        // Phone Number
        phoneNumberInputLayout.addView(phoneNumberEditText, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.button_padding)
        )
        )
        addView(phoneNumberInputLayout)

        // CoinBox
        coinNumberInputLayout.addView(coinNumberEditText, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.button_padding)

        )

        )
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
        val topCountryCode = titleBottom + Metrics.dpToPx(32)
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
        val buttonTop = Metrics.dpToPx(280)
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
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        // Measure Phone Number Input Layout
        phoneNumberInputLayout.measure(
            Measure.getExactSpec(width - Metrics.dpToPx(103)),
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

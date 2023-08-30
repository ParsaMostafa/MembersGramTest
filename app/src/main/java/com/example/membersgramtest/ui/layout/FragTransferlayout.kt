package com.example.membersgramtest.ui.layout

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.ui.fragment.CountryCodeDialog
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FragTransferlayout(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val text1 : TextView
    private val phoneNumInputLayout: TextInputLayout
    val phoneNumEditText: EditText


    private val phoneNumInputLayout2: TextInputLayout
    val phoneNumEditText2: EditText

    private val phoneNumInputLayout3: TextInputLayout
    val phoneNumEditText3: EditText

    val button : MaterialButton

    private lateinit var countryCodeDialog: CountryCodeDialog










    init {


        text1 = TextView(context)
        text1.text = "Coin Transfer"
        text1.textSize = 16F
        text1.setTextColor(Color.parseColor("#212121")) // Set text color to black
        text1.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)// Set the typeface to bold
        addView(text1)




         // در بخش init
        phoneNumInputLayout = TextInputLayout(ContextThemeWrapper(context, R.style.TextInputLayoutOutlinedBox))
        phoneNumEditText = TextInputEditText(phoneNumInputLayout.context)
        phoneNumEditText.setShowSoftInputOnFocus(false) // اضافه کردن این خط
        // ...

        phoneNumEditText.isFocusable = false // Disable focus
        phoneNumEditText.isClickable = false // Disable click
        phoneNumEditText.isLongClickable = false // Disable long click
        phoneNumEditText.inputType = InputType.TYPE_NULL // Disable editing

         // ...



        // تنظیم مقدار اولیه برای phoneNumEditText
        phoneNumEditText.setText("+98")
        phoneNumInputLayout.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val color = ContextCompat.getColor(context, R.color.white)
        phoneNumInputLayout.setBoxBackgroundColor(color)

        phoneNumInputLayout.addView(phoneNumEditText,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ))
        addView(phoneNumInputLayout)

        countryCodeDialog = CountryCodeDialog(context, object : CountryCodeDialog.OnCountryCodeSelectedListener {
            override fun onCountryCodeSelected(countryCode: String) {

                phoneNumEditText.setText(countryCode)
            }
        })

        phoneNumEditText.setOnClickListener {
            countryCodeDialog.show()

        }









        phoneNumInputLayout2 = TextInputLayout(ContextThemeWrapper(context, R.style.TextInputLayoutOutlinedBox))
        phoneNumEditText2 = TextInputEditText(phoneNumInputLayout2.context)

        phoneNumEditText2.hint = "Receive number "
        phoneNumInputLayout2.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val color2 = ContextCompat.getColor(context, R.color.white)
        phoneNumInputLayout2.setBoxBackgroundColor(color2)

        phoneNumInputLayout2.addView(phoneNumEditText2,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ))
        addView(phoneNumInputLayout2)




        phoneNumInputLayout3 = TextInputLayout(ContextThemeWrapper(context, R.style.TextInputLayoutOutlinedBox))
        phoneNumEditText3 = TextInputEditText(phoneNumInputLayout3.context)

        phoneNumEditText3.hint = "Number of coins  "
        phoneNumInputLayout3.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        val color3 = ContextCompat.getColor(context, R.color.white)
        phoneNumInputLayout3.setBoxBackgroundColor(color3)

        phoneNumInputLayout3.addView(phoneNumEditText3,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ))
        addView(phoneNumInputLayout3)

        phoneNumEditText.inputType = InputType.TYPE_CLASS_NUMBER
        phoneNumEditText2.inputType = InputType.TYPE_CLASS_NUMBER
        phoneNumEditText3.inputType = InputType.TYPE_CLASS_NUMBER


        button = MaterialButton(context)
        button.text = "Transfer"
        button.textSize = 16f
        button.isAllCaps = false
        button.setBackgroundColor(Color.parseColor("#1976D2")) // Set button background color
        button.setTextColor(Color.WHITE) // Set button text color
        button.setPadding(0,0,0,0)
        button.insetTop = 0
        button.insetBottom = 0
        button.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        val radius = 60 // specify the radius in pixels
        val shapeAppearanceModel = button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        button.shapeAppearanceModel = shapeAppearanceModel
        addView(button)

        updateButtonState()






    }




    private fun updateButtonState() {
        val isFieldsEmpty = phoneNumEditText.text.isNullOrEmpty() ||
                phoneNumEditText2.text.isNullOrEmpty() ||
                phoneNumEditText3.text.isNullOrEmpty()

        if (isFieldsEmpty) {
            button.setBackgroundColor(Color.parseColor("#E0E0E0")) // Inactive color
            button.setTextColor(Color.parseColor("#616161")) // Inactive text color
        } else {
            button.setBackgroundColor(Color.parseColor("#1976D2")) // Active color
            button.setTextColor(Color.parseColor("#FFFFFF")) // Active text color
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        //Text1
        val tleft = Metrics.dpToPx(16)
        val ttop =  Metrics.dpToPx(23)
        val tright = tleft + text1.measuredWidth
        val tbottom = ttop+ text1.measuredHeight
        text1.layout(tleft, ttop, tright, tbottom)

        // Layout phoneNumInputLayout
        val lefti = Metrics.dpToPx(16)
        val topi = tbottom + Metrics.dpToPx(31)
        val righti = lefti + phoneNumInputLayout.measuredWidth
        val bottomi = topi + phoneNumInputLayout.measuredHeight
        phoneNumInputLayout.layout(lefti, topi, righti, bottomi)

        // Layout phoneNumInputLayout
        val leftii = righti + Metrics.dpToPx(10)
        val topii = tbottom + Metrics.dpToPx(31)
        val rightii = parentWidth - Metrics.dpToPx(16)
        val bottomii = topii + phoneNumInputLayout.measuredHeight
        phoneNumInputLayout2.layout(leftii, topii, rightii, bottomii)

        // Layout number of coins
        val leftia = Metrics.dpToPx(16)
        val topia = bottomii + Metrics.dpToPx(33)
        val rightia = leftia + phoneNumInputLayout3.measuredWidth
        val bottomia = topia + phoneNumInputLayout3.measuredHeight
        phoneNumInputLayout3.layout(leftia, topia, rightia, bottomia)
        // Login Button
        val buttonWidth = button.measuredWidth
        val buttonHeight = button.measuredHeight
        val buttonLeft = (parentWidth - buttonWidth) / 2
        val buttonTop = bottomia + Metrics.dpToPx(32)
        val buttonRight = buttonLeft + buttonWidth
        val buttonBottom = buttonTop + buttonHeight
        button.layout(buttonLeft, buttonTop, buttonRight, buttonBottom)

        updateButtonState()

    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)



        text1.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )

        // Measure phoneNumInputLayout
        phoneNumInputLayout.measure(
            Measure.getExactSpec(Metrics.dpToPx(64)),
            Measure.getExactSpec(Metrics.dpToPx(60))
        )
        phoneNumInputLayout2.measure(
            Measure.getExactSpec(Metrics.dpToPx(305)),
            Measure.getExactSpec(Metrics.dpToPx(60))
        )
        phoneNumInputLayout3.measure(
            Measure.getExactSpec(Metrics.dpToPx(380)),
            Measure.getExactSpec(Metrics.dpToPx(60))
        )
        button.measure(
            Measure.getExactSpec(Metrics.dpToPx(380)),
            Measure.getExactSpec(Metrics.dpToPx(60))
        )




        setMeasuredDimension(
            width,
            height
        )
    }
}

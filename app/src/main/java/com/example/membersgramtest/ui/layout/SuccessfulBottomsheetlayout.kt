package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class SuccessfulBottomsheetlayout(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,

) : ViewGroup(context, attrs, defStyleAttr) {

    val imageView: ImageView
    var lineView: View
    val textview1: TextView
    val textview2: TextView

    val button: MaterialButton
    val bottomPadding = Metrics.dpToPx(48)

    private var phoneNumberText: String = ""

    init {
        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.clip_path_group)
        addView(imageView)

        lineView = View(context)
        lineView.setBackgroundColor(Color.parseColor("#E7E7E7"))
        addView(lineView)

        textview1 = TextView(context)
        textview1.text = "Successful transfer"
        textview1.textSize = 18F
        textview1.setTextColor(Color.parseColor("#212121"))// Set text color to black
        textview1.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview1)

        textview2 = TextView(context)
        textview2.text = "200 coins transfer to $phoneNumberText" // استفاده از phoneNumberText
        textview2.textSize = 14F
        textview2.setTextColor(Color.parseColor("#616161"))// Set text color to black
        textview2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview2)

        button = MaterialButton(context)
        button.text = "Ok"
        button.textSize = 16f
        button.isAllCaps = false
        button.setBackgroundColor(Color.parseColor("#1976D2")) // Set button background color
        button.setTextColor(Color.WHITE) // Set button text color
        button.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        button.setPadding(0, 0, 0, 0) // Set top and bottom insets to 0dp
        button.minimumHeight = 0 // Set minimum height to 0
        button.minimumWidth = 0 // Set minimum width to 0
        button.insetTop = 0
        button.insetBottom = 0
        val radius = 60 // specify the radius in pixels
        val shapeAppearanceModel = button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        button.shapeAppearanceModel = shapeAppearanceModel
        addView(button)

        button.setOnClickListener {

        }
    }

    fun setPhoneNumber(phone: String) {
        phoneNumberText = phone
        textview2.text = "200 coins transfer to $phoneNumberText"
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // imageview
        val leftimage = Metrics.dpToPx(115)
        val topimage = Metrics.dpToPx(58)
        val rightimage = leftimage + imageView.measuredWidth
        val bottomimage = topimage + imageView.measuredHeight
        imageView.layout(leftimage, topimage, rightimage, bottomimage)

        // lineview
        val left = (parentWidth - lineView.measuredWidth) / 2
        val top = Metrics.dpToPx(14)
        val right = left + lineView.measuredWidth
        val bottom = top + lineView.measuredHeight
        lineView.layout(left, top, right, bottom)

        //textview1
        val lefttext = rightimage + Metrics.dpToPx(9)
        val toptext = Metrics.dpToPx(58)
        val righttext = lefttext + textview1.measuredWidth
        val bottomtext = toptext + textview1.measuredHeight
        textview1.layout(lefttext, toptext, righttext, bottomtext)

        //textview2
        val leftt = Metrics.dpToPx(108)
        val topt = bottomtext + Metrics.dpToPx(8)
        val rightt = leftt + textview2.measuredWidth
        val bottomt = topt + textview2.measuredHeight
        textview2.layout(leftt, topt, rightt, bottomt)

        // button
        val leftb = (parentWidth - button.measuredWidth) / 2
        val topb = bottomt + Metrics.dpToPx(54)
        val rightb = leftb + button.measuredWidth
        val bottomb = topb + button.measuredHeight
        button.layout(leftb, topb, rightb, bottomb)


    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {


        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)


        imageView.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )


        // Line View
        val lineViewHeight = Metrics.dpToPx(4) // Set line view height as desired
        val lineViewWitdh = Metrics.dpToPx(36)
        lineView.measure(
            MeasureSpec.makeMeasureSpec(lineViewWitdh, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(lineViewHeight, MeasureSpec.EXACTLY)
        )


        textview1.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )


        textview2.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )


        button.measure(
            View.MeasureSpec.makeMeasureSpec(width - Metrics.dpToPx(48), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(Metrics.dpToPx(48), View.MeasureSpec.EXACTLY)
        )




        setMeasuredDimension(width, Metrics.dpToPx(210))


    }
}



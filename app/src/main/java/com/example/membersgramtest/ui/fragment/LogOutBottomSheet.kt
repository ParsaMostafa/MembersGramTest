package com.example.membersgramtest.ui.fragment

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

class LogOutBottomSheet(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val imageView: ImageView
    var lineView: View
    val textview1 : TextView
    val textview2: TextView

    val imageView2: ImageView
    val textview7 : TextView
    val textview8: TextView
    // BTN
    val Button = MaterialButton(context).apply {
        text = "Transfer"
        textSize = 16f
        isAllCaps = false
        setBackgroundColor(Color.WHITE)
        setTextColor(Color.parseColor("#1976D2"))
        setPadding(0, 0, 0, 0)
        insetTop = 0
        insetBottom = 0
        typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        letterSpacing = 0.0f



        setBackgroundColor(Color.WHITE)
    }


    // BTN
    val SButton = MaterialButton(context).apply {
        text = "Log out"
        textSize = 16f
        isAllCaps = false

        setTextColor(Color.parseColor("#FFFFFF"))
        setPadding(0, 0, 0, 0)
        insetTop = 0
        insetBottom = 0
        typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        letterSpacing = 0.0f




        setBackgroundColor(Color.parseColor("#1976D2"))
    }






    init {
        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.group_9706)
        addView(imageView)

        lineView = View(context)
        lineView.setBackgroundColor(Color.parseColor("#E7E7E7"))
        addView(lineView)

        textview1 = TextView(context)
        textview1.text = "Log out"
        textview1.textSize = 20F
        textview1.setTextColor(Color.parseColor("#212121"))// Set text color to black
        textview1.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        addView(textview1)


        textview2 = TextView(context)
        textview2.text = "Are you sure to log out of the user account?"
        textview2.textSize = 14F
        textview2.setTextColor(Color.parseColor("#616161"))// Set text color to black
        textview2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview2)








        imageView2 = ImageView(context)
        imageView2.setImageResource(R.drawable.person_black_24dp__1_)
        addView(imageView2)

        textview7 = TextView(context)
        textview7.text = "50"
        textview7.textSize = 16F
        textview7.setTextColor(Color.parseColor("#212121"))// Set text color to black
        textview7.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview7)


        textview8 = TextView(context)
        textview8.text = "eslamic_arts"
        textview8.textSize = 16F
        textview8.setTextColor(Color.parseColor("#212121"))// Set text color to black
        textview8.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview8)

        // btn




        // Get the corner radius from the dimension resource
        val radiuse = context.resources.getDimensionPixelSize(R.dimen.corner_radius)

        // Create a shapeAppearanceModel with rounded corners
        val shapeAppearanceModele = Button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radiuse.toFloat())
            .build()

        // Apply the shapeAppearanceModel to the SButton
        Button.shapeAppearanceModel = shapeAppearanceModele
        addView(Button)


        //sButton
        // Get the corner radius from the dimension resource
        val radius = context.resources.getDimensionPixelSize(R.dimen.corner_radius)

       // Create a shapeAppearanceModel with rounded corners
        val shapeAppearanceModel = SButton.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()

        // Apply the shapeAppearanceModel to the SButton
        SButton.shapeAppearanceModel = shapeAppearanceModel
        addView(SButton)





    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // imageview
        val leftimage = Metrics.dpToPx(147)
        val topimage = Metrics.dpToPx(50)
        val rightimage = leftimage + imageView.measuredWidth
        val bottomimage = topimage + imageView.measuredHeight
        imageView.layout(leftimage,topimage,rightimage,bottomimage)



        //textview1
        val lefttext =rightimage + Metrics.dpToPx(16)
        val toptext = Metrics.dpToPx(49)
        val righttext = lefttext + textview1.measuredWidth
        val bottomtext = toptext + textview1.measuredHeight
        textview1.layout(lefttext,toptext,righttext,bottomtext)

        //textview2
        val leftt =  Metrics.dpToPx(86)
        val topt = bottomtext + Metrics.dpToPx(36)
        val rightt = leftt + textview2.measuredWidth
        val bottomt = topt+textview2.measuredHeight
        textview2.layout(leftt,topt,rightt,bottomt)

        // button
        val leftb = Metrics.dpToPx(16)
        val topb =  bottomt + Metrics.dpToPx(24)
        val rightb = leftb + Button.measuredWidth
        val bottomb = topb + Button.measuredHeight
        Button.layout(leftb, topb, rightb, bottomb)

        // sbutton
        val rightsb =  parentWidth - Metrics.dpToPx(16)
        val topsb =  bottomt + Metrics.dpToPx(24)
        val leftsb = rightsb - SButton.measuredWidth
        val bottomsb = topsb + SButton.measuredHeight
        SButton.layout(leftsb, topsb, rightsb, bottomsb)


    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {


        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)


        imageView.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )


        // Line View
        val lineViewHeight = Metrics.dpToPx(4) // Set line view height as desired
        val lineViewWitdh =  Metrics.dpToPx(36)
        lineView.measure(
            View.MeasureSpec.makeMeasureSpec(lineViewWitdh , View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(lineViewHeight, View.MeasureSpec.EXACTLY)
        )


        textview1.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )


        textview2.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )



        imageView2.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )

        textview7.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )

        textview8.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )
        Button.measure(
            View.MeasureSpec.makeMeasureSpec(  Metrics.dpToPx(152), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(  Metrics.dpToPx(48), View.MeasureSpec.EXACTLY )
        )


        SButton.measure(
            View.MeasureSpec.makeMeasureSpec(  Metrics.dpToPx(152), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(  Metrics.dpToPx(48), View.MeasureSpec.EXACTLY )
        )





        setMeasuredDimension(width, Metrics.dpToPx(230))




    }






}
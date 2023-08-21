package com.example.membersgramtest.ui.layout

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.R
import com.example.membersgramtest.ui.fragment.MyBottomSheetDialogFragment
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class ItemMemberinorder2(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val imageView: ImageView
    val textView: TextView
    var imageview2 : ImageView
    val button: MaterialButton
    val customView: TextView
    val textview1: TextView
    val textview2: TextView
    val text: TextView
    val discounttext: TextView
    val whtitebuttun: MaterialButton
    val custom2: TextView
    val custom3: TextView
    val imageViewcoin : ImageView
    var imageviewcoinc :Boolean = true
    val textviewmembercount : TextView
    var coin :Boolean = true
    init {
        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.person_bue_24dp__2_)
        addView(imageView)

        textView = TextView(context)
        textView.text = "1,000"
        textView.setTextColor(Color.parseColor("#212121"))
        textView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)

// Get the text from the TextView and remove commas
        val originalText = textView.text.toString()
        val parsedText = originalText.replace(",", "")

// Convert the parsed text to an integer
        val intValue = parsedText.toInt()

// Now you can use the intValue as needed

        addView(textView)


        imageview2 = ImageView(context)
        imageview2.setImageResource(R.drawable.ic_fire_box)
        addView(imageview2)

        button = MaterialButton(context)
        button.text = "OnePost"
        button.isAllCaps = false
        val color = Color.parseColor("#E3F2FD")
        button.backgroundTintList = ColorStateList.valueOf(color)
        val textColorss = Color.parseColor("#616161")
        button.setTextColor(textColorss)
        button.setTextSize(14F)
        button.typeface = ResourcesCompat.getFont(MyApp.appContext, R.font.producsansmedium)
        button.insetTop = 0
        button.insetBottom = 0
        val radius = 60
        val shapeAppearanceModelaq = button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        button.shapeAppearanceModel = shapeAppearanceModelaq

        val borderColor = Color.parseColor("#E0E0E0") // Change the color as needed
        val borderWidth = context.resources.getDimensionPixelSize(R.dimen.border_width)
        val borderColors = ColorStateList.valueOf(borderColor)
        button.strokeWidth = borderWidth
        button.strokeColor = borderColors
        button.letterSpacing = 0.0f
        button.stateListAnimator = null



        customView = TextView(context)
        customView.background = ContextCompat.getDrawable(context, R.drawable.shape)
        customView.text = "25%"
        customView.setTextColor(Color.parseColor("#C62828"))
        customView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        customView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        customView.gravity = Gravity.CENTER


        textview1 = TextView(context)
        textview1.text = "10,900"
        textview1.setTextColor(Color.parseColor("#757575"))
        textview1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textview1.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        textview1.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        textview1.gravity = Gravity.CENTER
        addView(textview1)


        textview2 = TextView(context)
        textview2.text = "Best offer"
        textview2.setTextColor(Color.parseColor("#757575"))
        textview2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textview2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)


        text = TextView(context)
        text.text = "50"
        text.setTextColor(Color.parseColor("#212121"))
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        text.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        text.visibility = View.INVISIBLE
        addView(text)

        discounttext = TextView(context)
        discounttext.text = "20"
        discounttext.setTextColor(Color.parseColor("#757575"))
        discounttext.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        discounttext.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        discounttext.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(discounttext)

        whtitebuttun = MaterialButton(context)
        whtitebuttun.text = "900"
        whtitebuttun.isAllCaps = false
        whtitebuttun.textSize = 14f
        whtitebuttun.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        whtitebuttun.insetTop = 0
        whtitebuttun.insetBottom = 0

        // Set the corner radius for rounded corners
        val radiusaaa = context.resources.getDimensionPixelSize(R.dimen.corner_radius)

        // Create a shapeAppearanceModel with rounded corners
        val shapeAppearanceModel = whtitebuttun.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radiusaaa.toFloat())
            .build()

        // Apply the shapeAppearanceModel to the button
        whtitebuttun.shapeAppearanceModel = shapeAppearanceModel

        // Set the border
        val borderColoraaa = 0xFFE7E7E7.toInt() // Convert color to integer value
        val borderWidthaaa = context.resources.getDimensionPixelSize(R.dimen.border_width)

        // Create a ColorStateList for the border color
        val borderColorsaaa = ColorStateList.valueOf(borderColor)

        // Set the border stroke color and width
        whtitebuttun.strokeWidth = borderWidth
        whtitebuttun.strokeColor = borderColors

        // Disable the shadow (remove elevation animations)
        whtitebuttun.stateListAnimator = null
        whtitebuttun.letterSpacing = 0.0f
        addView(whtitebuttun)

        custom2 = TextView(context)
        custom2.background = ContextCompat.getDrawable(context, R.drawable.shape)
        custom2.text = "25%"
        custom2.setTextColor(Color.parseColor("#C62828"))
        custom2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        custom2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        custom2.gravity = Gravity.CENTER
        addView(custom2)

        custom3 = TextView(context)
        custom3.background = ContextCompat.getDrawable(context, R.drawable.shape1)
        custom3.text = "x2"
        custom3.setTextColor(Color.parseColor("#212121"))
        custom3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
        custom3.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        custom3.gravity = Gravity.CENTER
        addView(custom3)

        imageViewcoin = ImageView(context)
        imageViewcoin.setImageResource(R.drawable.group)

        addView(imageViewcoin)


        textviewmembercount = TextView(context)
        textviewmembercount.text = "7878787"
        textviewmembercount.setTextColor(Color.parseColor("#757575"))
        textviewmembercount.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

        textviewmembercount.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)

        addView(textviewmembercount)



        whtitebuttun.setOnClickListener {
            val bottomSheetFragment = MyBottomSheetDialogFragment()
            bottomSheetFragment.show((context as AppCompatActivity).supportFragmentManager, bottomSheetFragment.tag)
        }

    }



    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        //coin
        val l = Metrics.dpToPx(16)

        val t: Int = if (coin) {
            Metrics.dpToPx(24)

        } else {
            Metrics.dpToPx(24)
        }

        val r = l + imageView.measuredWidth
        val b =  t + imageView.measuredHeight

        imageView.layout(l, t, r, b)

        //textview
        val ll = r+Metrics.dpToPx(15)
        val tt = Metrics.dpToPx(29)
        val rr = ll + textView.measuredWidth
        val bb = tt + textView.measuredHeight
        textView.layout(ll, tt, rr, bb)

        //imageview2
        val lll = rr+Metrics.dpToPx(7)
        val ttt =  Metrics.dpToPx(28)
        val rrr = lll + imageview2.measuredWidth
        val bbb = ttt + imageview2.measuredHeight
        imageview2.layout(lll,ttt,rrr,bbb)
        //
        val br = parentWidth - Metrics.dpToPx(16)
        val bt = Metrics.dpToPx(9)
        val bl = br - button.measuredWidth
        val Bb = bt + button.measuredHeight
        button.layout(bl,bt,br,Bb)

        // CustomView
        val sl = bl - customView.measuredWidth - Metrics.dpToPx(8)  // Calculate left based on button's position
        val st = bt + Metrics.dpToPx(3) // Adjust as necessary to align vertically with button
        val sr = sl + customView.measuredWidth
        val sb = st + customView.measuredHeight
        customView.layout(sl, st, sr, sb)





        // text
        val leftt = r + Metrics.dpToPx(16)
        val topt = Metrics.dpToPx(14)
        val rightt = leftt + text.measuredWidth
        val bottomt = topt + text.measuredHeight
        text.layout(leftt,topt,rightt,bottomt)
        //discounttext
        val ldis = r + Metrics.dpToPx(16)
        val tdis = bottomt + Metrics.dpToPx(15)
        val  rdis = ldis + discounttext.measuredWidth
        val bdis = tdis + discounttext.measuredHeight
        discounttext.layout(
            ldis,tdis,rdis,bdis
        )
        //whitebutton
        val rightb  = parentWidth - Metrics.dpToPx(16)
        val topb =  Metrics.dpToPx(14)
        val leftb = rightb - whtitebuttun.measuredWidth
        val bottomb = topb + whtitebuttun.measuredHeight
        whtitebuttun.layout(
            leftb,topb,rightb,bottomb
        )




        //textview1
        val tr1 = rightb
        val tt1 = Bb + Metrics.dpToPx(10)
        val tl1 = leftb
        val tb1 = tt1 + textview1.measuredHeight
        textview1.layout(tl1, tt1, tr1, tb1)
        // coustomview2



        val leftCustom2 = leftb - Metrics.dpToPx(10) - custom2.measuredWidth
        val topCustom2 = Metrics.dpToPx(20)
        val rightCustom2 = leftb - Metrics.dpToPx(10)
        val bottomCustom2 = topCustom2 + custom2.measuredHeight


        custom2.layout(leftCustom2, topCustom2, rightCustom2, bottomCustom2)


        // custom3
        val cl = Metrics.dpToPx(30)
        val ct = Metrics.dpToPx(36)
        val cr = cl + custom3.measuredWidth
        val cb = ct + custom3.measuredHeight
        custom3.layout(cl,ct,cr,cb)


        // imageviewCoin
        val imgright = parentWidth - Metrics.dpToPx(73)
        val imgtop = Metrics.dpToPx(24)
        val imgleft = imgright - imageViewcoin.measuredWidth
        val imgbottom = imgtop + imageViewcoin.measuredHeight
       imageViewcoin.layout(imgleft,imgtop,imgright,imgbottom)

        // textviewmemebercount

        val leftco = Metrics.dpToPx(55)
        val topop = Metrics.dpToPx(23)
        val rightop = leftco + textviewmembercount.measuredWidth
        val bottomop = topop + textviewmembercount.measuredHeight




    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)


        imageView.measure(
            Measure.getExactSpec(Metrics.dpToPx(24)),
            Measure.getExactSpec(Metrics.dpToPx(24))
        )


        textView.measure(
            Measure.getExactSpec(Metrics.dpToPx(43)),
            Measure.getExactSpec(Metrics.dpToPx(19))
        )

        imageview2.measure(
            Measure.getExactSpec(Metrics.dpToPx(15)),
            Measure.getExactSpec(Metrics.dpToPx(16))
        )

        button.measure(
            Measure.wrapContentSpec,
            Measure.getExactSpec(Metrics.dpToPx(36))
        )

        customView.measure(
            Measure.getExactSpec(Metrics.dpToPx(30)),
            Measure.getExactSpec(Metrics.dpToPx(24))
        )

        textview2.measure(
            Measure.getExactSpec(Metrics.dpToPx(52)),
            Measure.getExactSpec(Metrics.dpToPx(15))

        )

        text.measure(
            Measure.getExactSpec(Metrics.dpToPx(20)),
            Measure.getExactSpec(Metrics.dpToPx(19))
        )

        discounttext.measure(
            Measure.getExactSpec(Metrics.dpToPx(17)),
            Measure.getExactSpec(Metrics.dpToPx(17))
        )
        whtitebuttun.measure(
            Measure.wrapContentSpec,
            Measure.getExactSpec(Metrics.dpToPx(36))
        )

        textview1.measure(
            Measure.getExactSpec(whtitebuttun.measuredWidth),
            Measure.getExactSpec(Metrics.dpToPx(15))

        )

        custom2.measure(
            Measure.getExactSpec(Metrics.dpToPx(30)),
            Measure.getExactSpec(Metrics.dpToPx(24))
        )
        custom3.measure(
            Measure.getExactSpec(Metrics.dpToPx(19)),
            Measure.getExactSpec(Metrics.dpToPx(13))
        )
        imageViewcoin.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )
        textviewmembercount.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )
        // Set the measured dimensions of this ViewGroup
        setMeasuredDimension(width, Metrics.dpToPx(48) + imageView.measuredHeight)
    }
}
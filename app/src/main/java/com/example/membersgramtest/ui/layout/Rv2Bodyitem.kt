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
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.ui.fragment.MyBottomSheetDialogFragment
import com.example.membersgramtest.ui.fragment.MyBottomSheetDialogFragment2
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.example.membersgramtest.utillity.Metrics.setSize
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class Rv2Bodyitem (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {


    var imageView: ImageView
    var textView: TextView

    var button: MaterialButton


    var textview2: TextView




    var imageViewCoin:ImageView

    var textView3:TextView

    var discountviewcount : TextView

    var imageviewfire:ImageView

    var  pricewithoutdiscount : TextView



    var dicountstringCoin : TextView

    var showPriceInsteadOfCoin: Boolean = true

    var showDiscountprice : Boolean = true

    var pricewithoutdiscountvisibility : Boolean = true

    val dollar : TextView

    var noDiscountatall : Boolean = true

    var  dollarCondition : Boolean = true
    var  coiniCondition  : Boolean = true








    init {
        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.visibility_black_24dp__2_)
        addView(imageView)

        textView = TextView(context)
        textView.text = "Test"
        textView.setTextColor(Color.parseColor("#212121"))
        textView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textView)


// Create a MaterialButton instance
        button = MaterialButton(context)

// Set the button properties
        button.text = "Selection"
        button.isAllCaps = false
        button.textSize = 14f
        button.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        button.insetTop = 0
        button.insetBottom = 0

        // Set the corner radius for rounded corners
        val radius = context.resources.getDimensionPixelSize(R.dimen.corner_radius)

       // Create a shapeAppearanceModel with rounded corners
        val shapeAppearanceModel = button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()

      // Apply the shapeAppearanceModel to the button
        button.shapeAppearanceModel = shapeAppearanceModel

       // Set the border
        val borderColor = 0xFFE7E7E7.toInt() // Convert color to integer value
        val borderWidth = context.resources.getDimensionPixelSize(R.dimen.border_width)

       // Create a ColorStateList for the border color
        val borderColors = ColorStateList.valueOf(borderColor)

      // Set the border stroke color and width
        button.strokeWidth = borderWidth
        button.strokeColor = borderColors

       // Disable the shadow (remove elevation animations)
        button.stateListAnimator = null

       // Add the button to the view
        addView(button)















        imageViewCoin = ImageView(context)
        imageViewCoin.setImageResource(R.drawable.group_1855__1_)
        addView(imageViewCoin)



        textView3 = TextView(context)
        textView3.text = "200"
        textView3.setTextColor(Color.parseColor("#616161"))
        textView3.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textView3)


        textview2 = TextView(context)
        textview2.text = "Economical"
        textview2.setTextColor(Color.parseColor("#616161"))
        textview2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textview2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview2)

        dollar = TextView(context)
        dollar.text = "$"
        dollar.setTextColor(Color.parseColor("#616161"))
        dollar.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(dollar)



        discountviewcount = TextView(context)
        discountviewcount.background = ContextCompat.getDrawable(context, R.drawable.shape1)
        discountviewcount.text = "x2"
        discountviewcount.setTextColor(Color.parseColor("#212121"))
        discountviewcount.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
        discountviewcount.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        discountviewcount.gravity = Gravity.CENTER
        addView( discountviewcount)






        imageviewfire = ImageView(context)
        imageviewfire.setImageResource(R.drawable.ic_fire_box)
        addView(imageviewfire)



        pricewithoutdiscount = TextView(context)
        pricewithoutdiscount.text = "price with out discount"
        pricewithoutdiscount.setTextColor(Color.parseColor("#757575"))
        pricewithoutdiscount.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        pricewithoutdiscount.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        pricewithoutdiscount.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        if (pricewithoutdiscountvisibility){pricewithoutdiscount.visibility = View.VISIBLE}else{pricewithoutdiscount.visibility = View.INVISIBLE}
        addView(pricewithoutdiscount)











        dicountstringCoin = TextView(context)
        dicountstringCoin.background = ContextCompat.getDrawable(context, R.drawable.shape)
        dicountstringCoin.text = "55%"
        dicountstringCoin.setTextColor(Color.parseColor("#C62828"))
        dicountstringCoin.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        dicountstringCoin.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        dicountstringCoin.gravity = Gravity.CENTER
        addView(dicountstringCoin)






        button.setOnClickListener {
            val bottomSheetFragment = MyBottomSheetDialogFragment2()
            bottomSheetFragment.show((context as AppCompatActivity).supportFragmentManager, bottomSheetFragment.tag)
        }






    }





    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        //val imageview
        val l = Metrics.dpToPx(16)
        val t = Metrics.dpToPx(20)
        val r = l + imageView.measuredWidth
        val b = t + imageView.measuredHeight
        imageView.layout(l,t,r,b)
        //textview
        val ll = r+ Metrics.dpToPx(15)
        val tt = Metrics.dpToPx(27)
        val rr = ll + textView.measuredWidth
        val bb = tt + textView.measuredHeight
        textView.layout(ll, tt, rr, bb)


        // buttun
        val br = parentWidth - Metrics.dpToPx(16)
        val bt = Metrics.dpToPx(18)
        val bl = br - button.measuredWidth
        val Bb = bt + button.measuredHeight
        button.layout(bl,bt,br,Bb)










       //coin
        val imgright = bl - Metrics.dpToPx(16)

        val imgtop: Int = if (coiniCondition) {
            Metrics.dpToPx(29)

        } else {
            Metrics.dpToPx(13)
        }

        val imgleft = imgright - imageViewCoin.measuredWidth
        val imgbt = imgtop + imageViewCoin.measuredHeight

        imageViewCoin.layout(imgleft, imgtop, imgright, imgbt)










        // disscountstring

        val disleft = Metrics.dpToPx(29)
        val distop = Metrics.dpToPx(38)
        val disright = disleft + discountviewcount.measuredWidth
        val disbottom = distop + discountviewcount.measuredHeight
        discountviewcount.layout(disleft,distop,disright,disbottom)

        //imageviewfire

        val imgl = ll + textView.measuredWidth + Metrics.dpToPx(4)
        val imgt = tt
        val imgr = imgl + imageviewfire.measuredWidth
        val imgb = imgt + imageviewfire.measuredHeight
        imageviewfire.layout(imgl, imgt, imgr, imgb)


        //Price with out discount

        val righttp = bl - Metrics.dpToPx(16)
        val toptp =  Metrics.dpToPx(46)
        val lefttp = righttp - pricewithoutdiscount.measuredWidth
        val bottomtp = toptp + pricewithoutdiscount.measuredHeight
        pricewithoutdiscount.layout(lefttp, toptp, righttp, bottomtp)


        val text3r: Int = if (showPriceInsteadOfCoin) {
            bl - Metrics.dpToPx(16)
        } else {
            imgleft - Metrics.dpToPx(4)
        }

        val text3t: Int = if (noDiscountatall) {
            Metrics.dpToPx(27)
        } else {
            Metrics.dpToPx(11)
        }

        val text3l = text3r - textView3.measuredWidth
        val textb = text3t + textView3.measuredHeight

        textView3.layout(text3l, text3t, text3r, textb)



        // textview 2
        val t2r = bl - Metrics.dpToPx(16)
        val t2t = textb + Metrics.dpToPx(8)
        val t2l = t2r - textview2.measuredWidth
        val b2t = t2t + textview2.measuredHeight
        textview2.layout(
            t2l,t2t,t2r,b2t
        )


        //dollar
        val rd = bl - Metrics.dpToPx(6)


        val td: Int = if (dollarCondition) {
            Metrics.dpToPx(27)
        } else {
            Metrics.dpToPx(11)
        }

        val ld = rd - dollar.measuredWidth
        val bd = td + dollar.measuredHeight

        dollar.layout(ld, td, rd, bd)





        //Discount string coin
        val discountWidth = dicountstringCoin.measuredWidth + dicountstringCoin.paddingStart + dicountstringCoin.paddingEnd

        // Discount string coin
        val dscRight : Int = if (showDiscountprice) {
            lefttp - Metrics.dpToPx(8) // 8dp to the left of the button
        }else {
            bl - Metrics.dpToPx(16)
        }

        val dscTop = toptp // aligned vertically with pricewithoutdiscount
        val dscLeft = dscRight - dicountstringCoin.measuredWidth
        val dscBottom = dscTop + dicountstringCoin.measuredHeight
        dicountstringCoin.layout(dscLeft, dscTop, dscRight, dscBottom)





    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)


        imageView.measure(
            Measure.getExactSpec(Metrics.dpToPx(32)),
            Measure.getExactSpec(Metrics.dpToPx(32))
        )


        textView.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )



        button.measure(
            Measure.wrapContentSpec,
            Measure.getExactSpec(Metrics.dpToPx(36))
        )





        textview2.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec)








        imageViewCoin.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )
        textView3.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )
        discountviewcount.measure(
            Measure.getExactSpec(Metrics.dpToPx(19)),
            Measure.getExactSpec(Metrics.dpToPx(13))
        )

        imageviewfire.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )


        pricewithoutdiscount.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )




        dicountstringCoin.measure(
            Measure.getExactSpec(Metrics.dpToPx(30)),
            Measure.getExactSpec(Metrics.dpToPx(24))

        )
        dollar.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec
        )





        // Set the measured dimensions of this ViewGroup
        setMeasuredDimension(width, Metrics.dpToPx(36) + button.measuredHeight)
    }
}
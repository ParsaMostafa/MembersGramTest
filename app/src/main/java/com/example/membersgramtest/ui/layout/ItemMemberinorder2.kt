package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.example.membersgramtest.utillity.Metrics.setSize
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily

class ItemMemberinorder2(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

        val imageView:ImageView
        val textView:TextView
        val imageview2 : ImageView
        val button:MaterialButton
        val customView: TextView
        val textview1 : TextView
        val textview2 : TextView
        val text : TextView





    init {

        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.order)

        addView(imageView)

        textView = TextView(context)
        textView.text = "1,000"
        textView.setTextColor(Color.parseColor("#212121"))
        textView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textView)



        imageview2 = ImageView(context)
        imageview2.setImageResource(R.drawable.ic_fire_box)
        addView(imageview2)



        button = MaterialButton(context)
        button.text = "9,900 $"
        button.isAllCaps = false

        button.setSize(14)

        button.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        button.insetTop = 0
        button.insetBottom = 0
        val radius = 60 // specify the radius in pixels
        val shapeAppearanceModel = button.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        button.shapeAppearanceModel = shapeAppearanceModel

        addView(button)


        // Initialize the customView as a TextView instead of ImageView
        customView = TextView(context)
        customView.background = ContextCompat.getDrawable(context, R.drawable.shape)
        // Set the text for customView
        customView.text = "25%"
        // You can also style the text as needed, here is an example:
        customView.setTextColor(Color.parseColor("#C62828"))
        customView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        customView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        customView.gravity = Gravity.CENTER
        addView(customView)

        //
        textview1 = TextView(context)

        textview1.text = "10,900 $"
        // You can also style the text as needed, here is an example:
        textview1.setTextColor(Color.parseColor("#616161"))
        textview1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textview1.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)

        addView(textview1)


        //
        textview2 = TextView(context)

        textview2.text = "Best offer"
        // You can also style the text as needed, here is an example:
        textview2.setTextColor(Color.parseColor("#616161"))
        textview2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textview2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)

        addView(textview2)

        //
        text = TextView(context)
        text.text = "50"
        text.setTextColor(Color.parseColor("#212121"))
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        text.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(text)





        // Set visibility of all items to INVISIBLE except imageView

        imageview2.visibility = View.INVISIBLE
        button.visibility = View.INVISIBLE
        customView.visibility = View.INVISIBLE
        textview1.visibility = View.INVISIBLE
        textview2.visibility = View.INVISIBLE

    }



    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        //val imageview
        val l = Metrics.dpToPx(16)
        val t = Metrics.dpToPx(24)
        val r = l + imageView.measuredWidth
        val b = t + imageView.measuredHeight
        imageView.layout(l,t,r,b)
        //textview
        val ll = r+Metrics.dpToPx(15)
        val tt = Metrics.dpToPx(27)
        val rr = ll + textView.measuredWidth
        val bb = tt + textView.measuredHeight
        textView.layout(ll, tt, rr, bb)
        textView.visibility = View.INVISIBLE
        //imageview2
        val lll = rr+Metrics.dpToPx(7)
        val ttt =  Metrics.dpToPx(28)
        val rrr = lll + imageview2.measuredWidth
        val bbb = ttt + imageview2.measuredHeight
        imageview2.layout(lll,ttt,rrr,bbb)
        //
        val bl = parentWidth - Metrics.dpToPx(16) - button.measuredWidth
        val bt = Metrics.dpToPx(9)
        val br = bl + button.measuredWidth
        val Bb = bt + button.measuredHeight
        button.layout(bl,bt,br,Bb)

        // CustomView
        val sl = bl - customView.measuredWidth - Metrics.dpToPx(8)  // Calculate left based on button's position
        val st = bt + Metrics.dpToPx(3) // Adjust as necessary to align vertically with button
        val sr = sl + customView.measuredWidth
        val sb = st + customView.measuredHeight
        customView.layout(sl, st, sr, sb)

        //textview1
        val tl1 = parentWidth - Metrics.dpToPx(33) - textview1.measuredWidth
        val tt1 = Bb + Metrics.dpToPx(2)
        val tr1 = tl1 + textview1.measuredWidth
        val tb1 = tt1 + textview1.measuredHeight
        textview1.layout( tl1,tt1,tr1,tb1
        )

        // textview 2
        val t2l = tl1 - Metrics.dpToPx(82)
        val t2t = sb + Metrics.dpToPx(8)
        val t2r = t2l + textview2.measuredWidth
        val b2t = t2t + textview2.measuredHeight
        textview2.layout(
            t2l,t2t,t2r,b2t
        )
        // text
        val leftt = l + Metrics.dpToPx(56)
        val topt = Metrics.dpToPx(14)
        val rightt = leftt + text.measuredWidth
        val bottomt = topt + text.measuredHeight
        text.layout(leftt,topt,rightt,bottomt)




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

        textview1.measure(
            Measure.getExactSpec(Metrics.dpToPx(46)),
            Measure.getExactSpec(Metrics.dpToPx(15))

        )

        textview2.measure(
            Measure.getExactSpec(Metrics.dpToPx(52)),
            Measure.getExactSpec(Metrics.dpToPx(15))

        )

        text.measure(
            Measure.getExactSpec(Metrics.dpToPx(20)),
            Measure.getExactSpec(Metrics.dpToPx(19))
        )

        // Set the measured dimensions of this ViewGroup
        setMeasuredDimension(width, Metrics.dpToPx(48) + imageView.measuredHeight)
    }
}
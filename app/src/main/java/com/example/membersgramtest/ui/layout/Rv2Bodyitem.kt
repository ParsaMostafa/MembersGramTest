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

    val imageView: ImageView
    val textView: TextView

    val button: MaterialButton
    val text11: TextView

    val textview2: TextView


    val whtitebuttun: MaterialButton



    init {
        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.visibility_black_24dp__2_)
        addView(imageView)

        textView = TextView(context)
        textView.text = "1,000"
        textView.setTextColor(Color.parseColor("#212121"))
        textView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textView)



        button = MaterialButton(context)
        button.text = "Selection"
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


        text11 = TextView(context)

        text11.text = "9,900 $"
        text11.setTextColor(Color.parseColor("#616161"))
        text11.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        text11.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        text11.gravity = Gravity.CENTER
        addView(text11)



        textview2 = TextView(context)
        textview2.text = "Best offer"
        textview2.setTextColor(Color.parseColor("#616161"))
        textview2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textview2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview2)





        whtitebuttun = MaterialButton(context)
        whtitebuttun.text = "900 $"
        whtitebuttun.isAllCaps = false
        val color = Color.parseColor("#E0E0E0")
        whtitebuttun.backgroundTintList = ColorStateList.valueOf(color)
        val textColor = Color.parseColor("#1565C0")
        whtitebuttun.setTextColor(textColor)
        whtitebuttun.setSize(14)
        whtitebuttun.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        whtitebuttun.insetTop = 0
        whtitebuttun.insetBottom = 0
        val radiuss = 60 // specify the radius in pixels
        val shapeAppearanceModell = whtitebuttun.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        whtitebuttun.shapeAppearanceModel = shapeAppearanceModel
       // addView(whtitebuttun)






        whtitebuttun.setOnClickListener {
            val bottomSheetFragment = MyBottomSheetDialogFragment()
            bottomSheetFragment.show((context as AppCompatActivity).supportFragmentManager, bottomSheetFragment.tag)
        }

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
        val ll = r+ Metrics.dpToPx(15)
        val tt = Metrics.dpToPx(30)
        val rr = ll + textView.measuredWidth
        val bb = tt + textView.measuredHeight
        textView.layout(ll, tt, rr, bb)


        // buttun
        val bl = parentWidth - Metrics.dpToPx(16) - button.measuredWidth
        val bt = Metrics.dpToPx(9)
        val br = bl + button.measuredWidth
        val Bb = bt + button.measuredHeight
        button.layout(bl,bt,br,Bb)

        // text 11
        val sl = bl - text11.measuredWidth - Metrics.dpToPx(16)  // Calculate left based on button's position
        val st = bt + Metrics.dpToPx(3) // Adjust as necessary to align vertically with button
        val sr = sl + text11.measuredWidth
        val sb = st + text11.measuredHeight
        text11.layout(sl, st, sr, sb)

        //whitebutton
        val leftb  = parentWidth - Metrics.dpToPx(16) - whtitebuttun.measuredWidth
        val topb =  Metrics.dpToPx(9)
        val rightb = leftb+ whtitebuttun.measuredWidth
        val bottomb = topb + whtitebuttun.measuredHeight
        whtitebuttun.layout(
            leftb,topb,rightb,bottomb
        )


        // textview 2
        val t2r =parentWidth - Metrics.dpToPx(122)
        val t2t = sb + Metrics.dpToPx(8)
        val t2l = t2r - textview2.measuredWidth
        val b2t = t2t + textview2.measuredHeight
        textview2.layout(
            t2l,t2t,t2r,b2t
        )











    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)


        imageView.measure(
            Measure.getExactSpec(Metrics.dpToPx(32)),
            Measure.getExactSpec(Metrics.dpToPx(32))
        )


        textView.measure(
            Measure.getExactSpec(Metrics.dpToPx(43)),
            Measure.getExactSpec(Metrics.dpToPx(19))
        )



        button.measure(
            Measure.wrapContentSpec,
            Measure.getExactSpec(Metrics.dpToPx(36))
        )

        text11.measure(
            Measure.wrapContentSpec,
            Measure.wrapContentSpec)



        textview2.measure(
            Measure.getExactSpec(Metrics.dpToPx(52)),
            Measure.getExactSpec(Metrics.dpToPx(15))

        )




        whtitebuttun.measure(
            Measure.wrapContentSpec,
            Measure.getExactSpec(Metrics.dpToPx(36))
        )



        // Set the measured dimensions of this ViewGroup
        setMeasuredDimension(width, Metrics.dpToPx(48) + imageView.measuredHeight)
    }
}
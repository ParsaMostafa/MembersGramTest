package com.example.membersgramtest.ui.layout


import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics

class ItemMemberinorder3(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr){
            val textView:TextView
            val imageView:ImageView
            val textView1 : TextView
            val lineView: View // Added gray line view
            val lineView1 : View
            val imageView2:ImageView
             val textview3 : TextView
             val imageView3 : ImageView
             val textview4 : TextView
    init {
        textView = TextView(context)
        textView.text = "You deserve the best:"
        textView.textSize = 12F
        textView.setTextColor(Color.parseColor("#757575"))// Set text color to black
        textView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textView)



        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.group_10084)
        addView(imageView)




        textView1 = TextView(context)
        textView1.text = "Best quality"
        textView1.textSize = 12F
        textView1.setTextColor(Color.parseColor("#757575"))// Set text color to black
        textView1.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textView1)

        lineView = View(context)
        lineView.setBackgroundColor(Color.parseColor("#E7E7E7"))
        addView(lineView)

        lineView1 = View(context)
        lineView1.setBackgroundColor(Color.parseColor("#E7E7E7"))
        addView(lineView1)

        imageView2 = ImageView(context)
        imageView2.setImageResource(R.drawable.group_10083)
        addView(imageView2)



        textview3 = TextView(context)
        textview3.text = "Instant start"
        textview3.textSize = 12F
        textview3.setTextColor(Color.parseColor("#757575"))// Set text color to black
        textview3.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview3)



        imageView3 = ImageView(context)
        imageView3.setImageResource(R.drawable.group_10085)
        addView(imageView3)


        textview4 = TextView(context)
        textview4.text = "Ongoing support"
        textview4.textSize = 12F
        textview4.setTextColor(Color.parseColor("#757575"))// Set text color to black
        textview4.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview4)


    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        val l  = ( (parentWidth - textView.measuredWidth) / 2)
        val t = Metrics.dpToPx(0)
        val r = l+textView.measuredWidth
        val b = t+textView.measuredHeight
        textView.layout(l,t,r,b)

        val ll = ( (parentWidth - imageView.measuredWidth) /2)
        val tt = b + Metrics.dpToPx(33)
        val rr = ll + imageView.measuredWidth
        val bb = tt + imageView.measuredHeight
        imageView.layout(ll,tt,rr,bb)


        val lll = ( (parentWidth - textView1.measuredWidth) /2)
        val ttt = bb + Metrics.dpToPx(8)
        val rrr = lll + textView1.measuredWidth
        val bbb = ttt + textView1.measuredHeight
        textView1.layout(lll,ttt,rrr,bbb)


        val llll =  rrr + Metrics.dpToPx(47)
        val tttt = b + Metrics.dpToPx(24)
        val rrrr = llll+ lineView.measuredWidth
        val bbbb = tttt + lineView.measuredHeight
         lineView.layout(llll,tttt,rrrr,bbbb)


        val llllr =  l - Metrics.dpToPx(47)
        val ttttr = b + Metrics.dpToPx(24)
        val rrrrr = llllr+ lineView1.measuredWidth
        val bbbbr = ttttr + lineView1.measuredHeight
        lineView1.layout(llllr,ttttr,rrrrr,bbbbr)


        // imagview2
        val left =  Metrics.dpToPx(48)
        val top = b + Metrics.dpToPx(33)
        val right = left + imageView2.measuredWidth
        val botoom = top + imageView2.measuredHeight
        imageView2.layout(left,top,right,botoom)

        //textview3
          val le =   Metrics.dpToPx(34)
          val to =  botoom + Metrics.dpToPx(8)
          val ri = le + textview3.measuredWidth
          val bo = to + textview3.measuredHeight
          textview3.layout(le,to,ri,bo)


        //imageview 3
        val right1 = parentWidth- Metrics.dpToPx(48)
        val top1 = b + Metrics.dpToPx(33)
        val left1 = right1 - imageView3.measuredWidth
        val botoom1 = top1 + imageView3.measuredHeight
        imageView3.layout(left1,top1,right1,botoom1)



        // textview4
        val rii =   parentWidth - Metrics.dpToPx(34)
        val too =  botoom1 + Metrics.dpToPx(8)
        val lee = rii - textview4.measuredWidth
        val boo = too + textview4.measuredHeight
        textview4.layout(lee,too,rii,boo)





    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)

        Log.e("ItemMemberinorder3", "Measured Width: $width, Measured Height: $height")
        textView.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )
        imageView.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        textView1.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)

        )
        // Line View
        val lineViewwidth = 1 // Set line view height as desired
        lineView.measure(
            MeasureSpec.makeMeasureSpec(lineViewwidth , MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        )



        lineView1.measure(
            MeasureSpec.makeMeasureSpec(lineViewwidth , MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        )

        imageView2.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        textview3.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)

        )
        imageView3.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )
        textview4.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        // Do your custom measurement logic here if needed

        // IMPORTANT: You must call setMeasuredDimension to save the measured width and height
        setMeasuredDimension(width, Metrics.dpToPx(105))
    }
}

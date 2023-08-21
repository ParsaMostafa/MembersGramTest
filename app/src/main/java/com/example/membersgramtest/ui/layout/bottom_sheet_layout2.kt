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
import com.example.membersgramtest.utillity.CryptUtil
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily
import org.json.JSONObject

class bottom_sheet_layout2 (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val imageView: ImageView
    var lineView: View
    val textview1 : TextView
    val textview2: TextView
    val lineview2 : View
    val textview3 : TextView
    val textview4 : TextView
    val textview5 : TextView
    val textview6 : TextView
    val imageView2: ImageView
    val textview7 : TextView
    val textview8: TextView
    val button: MaterialButton
    val bottomPadding = Metrics.dpToPx(48)




    init {
        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.baseline_assured_workload_24)
        addView(imageView)

        lineView = View(context)
        lineView.setBackgroundColor(Color.parseColor("#E7E7E7"))
        addView(lineView)

        textview1 = TextView(context)
        textview1.text = "Islamics Arts"
        textview1.textSize = 20F
        textview1.setTextColor(Color.parseColor("#212121"))// Set text color to black
        textview1.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview1)


        textview2 = TextView(context)
        textview2.text = "28K subscribers"
        textview2.textSize = 14F
        textview2.setTextColor(Color.parseColor("#616161"))// Set text color to black
        textview2.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview2)



        lineview2 = View(context)
        lineview2.setBackgroundColor(Color.parseColor("#E7E7E7"))
        addView(lineview2)



        textview3 = TextView(context)
        textview3.text = "Price"
        textview3.textSize = 14F
        textview3.setTextColor(Color.parseColor("#616161"))// Set text color to black
        textview3.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview3)



        textview4 = TextView(context)
        textview4.text = "Count"
        textview4.textSize = 14F
        textview4.setTextColor(Color.parseColor("#616161"))// Set text color to black
        textview4.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview4)



        textview5 = TextView(context)
        textview5.text = "Username"
        textview5.textSize = 14F
        textview5.setTextColor(Color.parseColor("#616161"))// Set text color to black
        textview5.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview5)


        textview6 = TextView(context)
        textview6.text = "200 $"
        textview6.textSize = 16F
        textview6.setTextColor(Color.parseColor("#212121"))// Set text color to black
        textview6.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(textview6)



        imageView2 = ImageView(context)
        imageView2.setImageResource(R.drawable.visibility_black_24dp__2_)
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


        button = MaterialButton(context)
        button.text = "Continue"
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
            val versionCode = 30180
            val packageName = "com.example.membersgramtest"
            val baseUrl = "https://api.membersgram.com/api/v2/zarinpal/member/gateway?data="
            fun orderMemberWithProvidedData(baseUrl: String, context: Context) {
                val jsonData = mapOf(
                    "phonenumber" to "989373449122",
                    "sku" to "z_member_01_m",
                    "price" to 5000,
                    "username" to "StopElon_BSC",
                    "tgChannelId" to 1352448969,
                    "title" to "STOPELON20OFFICIAL",
                    "tgPicDc_Id" to 5,
                    "tgPicVolume_Id" to 500047400704,
                    "tgPicLocal_Id" to 381959,
                    "tgPicSecret" to 7630722832590455152,
                    "tgAccessHash" to -4777718574595129344,
                    "market" to "zarinpal",
                    "lan" to "EN",
                    "versionc" to versionCode.toString(),
                    "packageName" to packageName
                )



                val encryptedData = CryptUtil.encrypt(JSONObject(jsonData).toString())
                val baseUrl = "https://api.membersgram.com/api/v2/zarinpal/member/gateway?data="
                com.example.membersgramtest.utillity.Browser.openUrl(context, "$baseUrl$encryptedData")

            }

        }



    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // imageview
        val leftimage = Metrics.dpToPx(27)
        val topimage = Metrics.dpToPx(50)
        val rightimage = leftimage + imageView.measuredWidth
        val bottomimage = topimage + imageView.measuredHeight
        imageView.layout(leftimage,topimage,rightimage,bottomimage)

        // lineview
        val left = (parentWidth - lineView.measuredWidth) / 2
        val top = Metrics.dpToPx(14)
        val right = left + lineView.measuredWidth
        val bottom = top + lineView.measuredHeight
        lineView.layout(left,top,right,bottom)

        //textview1
        val lefttext =rightimage + Metrics.dpToPx(16)
        val toptext = Metrics.dpToPx(49)
        val righttext = lefttext + textview1.measuredWidth
        val bottomtext = toptext + textview1.measuredHeight
        textview1.layout(lefttext,toptext,righttext,bottomtext)

        //textview2
        val leftt = rightimage + Metrics.dpToPx(16)
        val topt = bottomtext + Metrics.dpToPx(8)
        val rightt = leftt + textview2.measuredWidth
        val bottomt = topt+textview2.measuredHeight
        textview2.layout(leftt,topt,rightt,bottomt)

        // lineview
        val leftline = (parentWidth - lineview2.measuredWidth) / 2
        val topline = bottomt+ Metrics.dpToPx(32)
        val rightline = leftline + lineview2.measuredWidth
        val bottomline = topline + lineview2.measuredHeight
        lineview2.layout(leftline,topline,rightline,bottomline)

        // textview3
        val left3 =  Metrics.dpToPx(24)
        val top3 = bottomline + Metrics.dpToPx(39)
        val right3 = left3 + textview3.measuredWidth
        val bottom3 = top3 + textview3.measuredHeight
        textview3.layout(left3,top3,right3,bottom3)

        // textview 4
        val left4 = Metrics.dpToPx(24)
        val top4 = bottom3 + Metrics.dpToPx(31)
        val right4 = left4+ textview4.measuredWidth
        val bottom4 = top4 + textview4.measuredHeight
        textview4.layout(left4,top4,right4,bottom4)
        // textview5

        val left5 = Metrics.dpToPx(24)
        val top5 = bottom4 + Metrics.dpToPx(31)
        val right5 = left5 + textview5.measuredWidth
        val bottom5 = top5 + textview5.measuredHeight
        textview5.layout(left5,top5,right5,bottom5)

        // textview6

        val right6 = parentWidth - Metrics.dpToPx(24)
        val top6 = bottomline + Metrics.dpToPx(39)
        val left6 = right6 - textview6.measuredWidth
        val bottom6 = top6 + textview6.measuredHeight
        textview6.layout(left6,top6,right6,bottom6)

        // imageview2

        val righti = parentWidth - Metrics.dpToPx(24)
        val topi = bottom6 + Metrics.dpToPx(29)
        val lefti = righti - imageView2.measuredWidth
        val bottomi = topi + imageView2.measuredHeight
        imageView2.layout(lefti,topi,righti,bottomi)

        // textview7

        val right7 = parentWidth - Metrics.dpToPx(48)
        val top7 = bottom6 + Metrics.dpToPx(29)
        val left7 = right7 - textview7.measuredWidth
        val bottom7 = top7 + textview6.measuredHeight
        textview7.layout(left7,top7,right7,bottom7)

        // textview8

        val right8 = parentWidth - Metrics.dpToPx(48)
        val top8 = bottomi + Metrics.dpToPx(29)
        val left8 = right8 - textview8.measuredWidth
        val bottom8 = top8 + textview8.measuredHeight
        textview8.layout(left8,top8,right8,bottom8)


        // button
        val leftb = (parentWidth - button.measuredWidth) / 2
        val topb =  parentHeight - button.measuredHeight
        val rightb = leftb + button.measuredWidth
        val bottomb = topb + button.measuredHeight
        button.layout(leftb, topb, rightb, bottomb)


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


        // Line View2
        // Line View2 - Corrected the measurement for lineview2
        val lineViewHeight2 = Metrics.dpToPx(1) // Set line view height as desired
        val lineViewWidth2 = Metrics.dpToPx(312) // Corrected typo 'Witdh' to 'Width'
        lineview2.measure(
            View.MeasureSpec.makeMeasureSpec(lineViewWidth2, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(lineViewHeight2, View.MeasureSpec.EXACTLY)
        )


        textview3.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )


        textview4.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )

        textview5.measure(
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        )
        textview6.measure(
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
        button.measure(
            View.MeasureSpec.makeMeasureSpec( width - Metrics.dpToPx(48), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(Metrics.dpToPx(48), View.MeasureSpec.EXACTLY)
        )




        setMeasuredDimension(width, Metrics.dpToPx(392))




    }






}
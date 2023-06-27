package com.example.membersgramtest.ui.layout

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class IntroLayout(
    context: Context,
    attrs: AttributeSet? = null
) : ViewGroup(context, attrs) {
    val viewPager: ViewPager2
    val dotsIndicator: DotsIndicator
    private val languageImageView: ImageView
    private val languageTextView: TextView
    val loginButton: MaterialButton


    init {
        viewPager = ViewPager2(context)
        addView(viewPager)



        dotsIndicator = DotsIndicator(context)
        addView(dotsIndicator)



        languageImageView = ImageView(context)
        languageImageView.setImageResource(R.drawable.baseline_language_24)
        addView(languageImageView)




        languageTextView = TextView(context)
        languageTextView.text = "Language"
        addView(languageTextView)




        loginButton = MaterialButton(context)
        loginButton.text = "Login"
        addView(loginButton)




    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t



        // languageImageView
        val imageViewLeft = l + Metrics.dpToPx(5)
        val imageViewTop = t + Metrics.dpToPx(7)
        val imageViewRight = imageViewLeft + languageImageView.measuredWidth
        val imageViewBottom = imageViewTop + languageImageView.measuredHeight
        languageImageView.layout(imageViewLeft, imageViewTop, imageViewRight, imageViewBottom)

        // languageTextView
        val languageLeft = imageViewRight + Metrics.dpToPx(5)
        val languageTop = t + Metrics.dpToPx(5)
        val languageRight = languageLeft + languageTextView.measuredWidth
        val languageBottom = languageTop + languageTextView.measuredHeight
        languageTextView.layout(languageLeft, languageTop, languageRight, languageBottom)
        // viewPager
        val viewPagerLeft = l
        val viewPagerTop = languageTop + languageTextView.measuredHeight + Metrics.dpToPx(2)
        val viewPagerRight = parentWidth
        val viewPagerBottom = viewPagerTop + viewPager.measuredHeight

        viewPager.layout(viewPagerLeft, viewPagerTop, viewPagerRight, viewPagerBottom)

        // Login Button
        val buttonWidth = loginButton.measuredWidth
        val buttonHeight = loginButton.measuredHeight
        val buttonLeft = (parentWidth - buttonWidth) / 2
        val buttonTop = parentHeight - buttonHeight - Metrics.dpToPx(20)
        val buttonRight = buttonLeft + buttonWidth
        val buttonBottom = buttonTop + buttonHeight
        loginButton.layout(buttonLeft, buttonTop, buttonRight, buttonBottom)

        // dotsIndicator
        val dotsIndicatorWidth = dotsIndicator.measuredWidth
        val dotsIndicatorHeight = dotsIndicator.measuredHeight
        val dotsIndicatorLeft = (parentWidth - dotsIndicatorWidth) / 2 + Metrics.dpToPx(110)
        val dotsIndicatorTop = buttonTop - dotsIndicatorHeight - Metrics.dpToPx(20)
        val dotsIndicatorRight = dotsIndicatorLeft + dotsIndicatorWidth
        val dotsIndicatorBottom = dotsIndicatorTop + dotsIndicatorHeight
        dotsIndicator.layout(
            dotsIndicatorLeft,
            dotsIndicatorTop,
            dotsIndicatorRight,
            dotsIndicatorBottom
        )







    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)

        // Measure the languageTextView to get its dimensions
        languageTextView.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        // Measure the viewPager to match the available width and height
        viewPager.measure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(height - languageTextView.measuredHeight, MeasureSpec.EXACTLY)
        )

        // Measure the dotsIndicator to get its dimensions
        dotsIndicator.measure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        // Measure the languageImageView to get its dimensions
        languageImageView.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        // Measure the loginButton to get its dimensions
        loginButton.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        setMeasuredDimension(width, height)
    }

}

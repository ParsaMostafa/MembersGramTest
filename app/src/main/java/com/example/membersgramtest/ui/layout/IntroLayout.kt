package com.example.membersgramtest.ui.layout
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import me.relex.circleindicator.CircleIndicator3

class IntroLayout(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
      val viewPager: ViewPager2
    val circleIndicator: CircleIndicator3

    val languageImageView: ImageView
     val languageTextView: TextView
    val loginButton: MaterialButton

    init {
        viewPager = ViewPager2(context)
        addView(viewPager)



        languageImageView = ImageView(context)
        languageImageView.setImageResource(R.drawable.baseline_language_24)
        languageImageView.setColorFilter(Color.parseColor("#1976D2")) // Set color filter
        addView(languageImageView)

        languageTextView = TextView(context)
        languageTextView.text = "Language"
        languageTextView.setTextColor(Color.parseColor("#1976D2")) // Set text color
        addView(languageTextView)

        loginButton = MaterialButton(context)
        loginButton.text = "Login"
        addView(loginButton)

        circleIndicator = CircleIndicator3(context)
        circleIndicator.setViewPager(viewPager)


        addView(circleIndicator)



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
        val languageTop = t + Metrics.dpToPx(8)
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

        // CircleIndicator
        val indicatorWidth = circleIndicator.measuredWidth
        val indicatorHeight = circleIndicator.measuredHeight
        val indicatorLeft = (parentWidth - indicatorWidth) / 2
        val indicatorTop = viewPagerTop + viewPager.measuredHeight + Metrics.dpToPx(10)
        val indicatorRight = indicatorLeft + indicatorWidth
        val indicatorBottom = indicatorTop + indicatorHeight
        circleIndicator.layout(indicatorLeft, indicatorTop, indicatorRight, indicatorBottom)

        for (i in 0 until circleIndicator.childCount) {
            val child = circleIndicator.getChildAt(i)
            child.setBackgroundResource(R.drawable.indicator) // Set the background drawable to change the color
        }





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




        // Measure the languageImageView to get its dimensions
        languageImageView.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        // Measure the loginButton to get its dimensions
        loginButton.measure(
            View.MeasureSpec.makeMeasureSpec(widthMeasureSpec-Metrics.dpToPx(60), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY)
        )

        circleIndicator.measure(
            MeasureSpec.makeMeasureSpec(Metrics.dpToPx(50), MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(Metrics.dpToPx(50), MeasureSpec.EXACTLY)
        )
        // Measure the viewPager to match the available width and height
        viewPager.measure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(height - languageTextView.measuredHeight-loginButton.measuredHeight -circleIndicator.measuredHeight -Metrics.dpToPx(66), MeasureSpec.EXACTLY)
        )




        setMeasuredDimension(width, height)
    }
}

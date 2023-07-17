package com.example.membersgramtest.ui.layout
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily
import me.relex.circleindicator.CircleIndicator3

class IntroLayout   (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
     val viewPager: ViewPager2
     val circleIndicator: CircleIndicator3

      val languageImageView: ImageView
      val languageTextView: TextView
      val loginButton: MaterialButton

     var selectedIndicatorPosition = 0

    init {
        viewPager = ViewPager2(context)
        addView(viewPager)

        languageImageView = ImageView(context)
        languageImageView.setImageResource(R.drawable.baseline_language_24)
        languageImageView.setColorFilter(Color.parseColor("#1976D2"))
        addView(languageImageView)

        languageTextView = TextView(context)
        languageTextView.text = "Language"

        languageTextView.setTextColor(Color.parseColor("#1976D2"))
        languageTextView.typeface = ResourcesCompat.getFont(context, R.font.product_sans_regular)
        addView(languageTextView)

        loginButton = MaterialButton(context)
        loginButton.text = "Log in"
        loginButton.isAllCaps = false

        loginButton.textSize = 16f
        loginButton.typeface = ResourcesCompat.getFont(context, R.font.producsansmedium)
        loginButton.insetTop = 0
        loginButton.insetBottom = 0
        val radius = 60 // specify the radius in pixels
        val shapeAppearanceModel = loginButton.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.toFloat())
            .build()
        loginButton.shapeAppearanceModel = shapeAppearanceModel

        addView(loginButton)

        circleIndicator = CircleIndicator3(context)
        circleIndicator.setViewPager(viewPager)
        addView(circleIndicator)

        // Add a page change listener to update the selected indicator position
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedIndicatorPosition = position
                updateIndicatorColors()
            }
        })
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // languageImageView
        val imageViewLeft = l + Metrics.dpToPx(16)
        val imageViewTop = t + Metrics.dpToPx(10)
        val imageViewRight = imageViewLeft + languageImageView.measuredWidth
        val imageViewBottom = imageViewTop + languageImageView.measuredHeight
        languageImageView.layout(imageViewLeft, imageViewTop, imageViewRight, imageViewBottom)

        // languageTextView
        val languageLeft = imageViewRight + Metrics.dpToPx(8)
        val languageTop = t + Metrics.dpToPx(12)
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
        val buttonBottom = parentHeight - Metrics.dpToPx(22)
        val buttonTop = buttonBottom - loginButton.measuredHeight
        val buttonRight = buttonLeft + buttonWidth
        loginButton.layout(buttonLeft, buttonTop, buttonRight, buttonBottom)

        // CircleIndicator
        val indicatorWidth = circleIndicator.measuredWidth
        val indicatorHeight = circleIndicator.measuredHeight
        val indicatorLeft = (parentWidth - indicatorWidth) / 2
        val indicatorBottom =  buttonTop - Metrics.dpToPx(5)
        val indicatorTop = indicatorBottom - circleIndicator.measuredHeight
        val indicatorRight = indicatorLeft + indicatorWidth

        circleIndicator.layout(indicatorLeft, indicatorTop, indicatorRight, indicatorBottom)

        for (i in 0 until circleIndicator.childCount) {
            val child = circleIndicator.getChildAt(i)
            child.setBackgroundResource(if (i == selectedIndicatorPosition) R.drawable.indicator else R.drawable.greyindicator)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)

        languageTextView.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        languageImageView.measure(
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        )

        loginButton.measure(
            View.MeasureSpec.makeMeasureSpec( width -Metrics.dpToPx(48), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(Metrics.dpToPx(48), View.MeasureSpec.EXACTLY)
        )

        circleIndicator.measure(
            MeasureSpec.makeMeasureSpec(Metrics.dpToPx(50), MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(Metrics.dpToPx(45), MeasureSpec.EXACTLY)
        )

        viewPager.measure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(
                height - languageTextView.measuredHeight - loginButton.measuredHeight - circleIndicator.measuredHeight - Metrics.dpToPx(
                    66
                ),
                MeasureSpec.EXACTLY
            )
        )

        setMeasuredDimension(width, height)
    }

    private fun updateIndicatorColors() {
        for (i in 0 until circleIndicator.childCount) {
            val child = circleIndicator.getChildAt(i)
            child.setBackgroundResource(if (i == selectedIndicatorPosition) R.drawable.indicator else R.drawable.greyindicator)
        }
    }
}

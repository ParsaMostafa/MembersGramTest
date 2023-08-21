package com.example.membersgramtest.ui.layout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class Viwepagercionlayout(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr)  {
    var tablayoutcoin : TabLayout
    var viewpager2coin : ViewPager2




    init {
        tablayoutcoin = TabLayout(context)
        addView(tablayoutcoin)


        viewpager2coin = ViewPager2(context)
        addView(viewpager2coin)


    }



    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t
        // Layout the tabLayout at the top
        val tabLayoutLeft = l
        val tabLayoutTop = t
        val tabLayoutRight = r
        val tabLayoutBottom = t + tablayoutcoin.measuredHeight
        tablayoutcoin.layout(tabLayoutLeft, tabLayoutTop, tabLayoutRight, tabLayoutBottom)

        // Layout the viewpager below the tabLayout
        val viewPagerLeft = l
        val viewPagerTop = tabLayoutBottom
        val viewPagerRight = r
        val viewPagerBottom = b
        viewpager2coin.layout(viewPagerLeft, viewPagerTop, viewPagerRight, viewPagerBottom)





    }









    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)

        tablayoutcoin.measure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST)

        )


        viewpager2coin.measure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(
                height-tablayoutcoin.measuredHeight,
                MeasureSpec.EXACTLY
            )
        )
    }
}
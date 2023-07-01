package com.example.membersgramtest.utillity

import android.view.View

object Measure {
    fun getExactSpec(size: Int) = View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.EXACTLY)

    fun getAtMostSpec(size: Int) = View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.AT_MOST)

    val wrapContentSpec get() = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
}
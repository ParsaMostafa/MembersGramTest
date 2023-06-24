package com.example.membersgramtest.utillity


import android.content.res.Resources

object Metrics {

    private val metrics by lazy {
        Resources.getSystem().displayMetrics
    }

    private val density by lazy {
        metrics.density
    }

    val displayWidth get() = metrics.widthPixels

    val displayHeight get() = metrics.heightPixels

    fun dpToPx(dp: Int) = (dp * density).toInt()

    fun dpToPx(dp: Float) = dp * density  }
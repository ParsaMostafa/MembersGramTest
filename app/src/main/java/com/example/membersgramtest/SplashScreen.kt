package com.example.membersgramtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()


    }
}
/*

  private lateinit var imageView: ImageView

    init {
        // ImageView initialization
        imageView = ImageView(context)
        imageView.setImageResource(R.drawable.person_add_black_24dp_1)
        addView(imageView)

        // Set the background using the drawable resource
        setBackgroundResource(R.drawable.group_2693)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t


        val imageLeft = l + Metrics.dpToPx(144)
        val imageTop = t + Metrics.dpToPx(364)
        val imageRight = imageLeft+ imageView.measuredWidth // centerX + imageView.measuredWidth / 2
        val imageBottom = imageTop + imageView.measuredHeight// centerY + imageView.measuredHeight / 2

        // Position the image view within the layout
        imageView.layout(imageLeft, imageTop, imageRight, imageBottom)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // Measure the imageView with desired dimensions
        val desiredWidth = Metrics.dpToPx(72)
        val desiredHeight = Metrics.dpToPx(72)
        val imageWidthMeasureSpec = MeasureSpec.makeMeasureSpec(desiredWidth, MeasureSpec.EXACTLY)
        val imageHeightMeasureSpec = MeasureSpec.makeMeasureSpec(desiredHeight, MeasureSpec.EXACTLY)
        imageView.measure(imageWidthMeasureSpec, imageHeightMeasureSpec)

    }
}

 */
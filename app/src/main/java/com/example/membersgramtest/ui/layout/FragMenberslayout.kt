package com.example.membersgramtest.ui.layout

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.InputType
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.R
import com.example.membersgramtest.utillity.Measure
import com.example.membersgramtest.utillity.Metrics
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FragMenberslayout ( context: Context,
                          attrs: AttributeSet? = null,
                          defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    val recyclerViewMyMembers : RecyclerView







    init {

        recyclerViewMyMembers = RecyclerView(context)
        addView(recyclerViewMyMembers)



    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t

        // RecyclerView
        val tleft = l
        val ttop = t
        val tright = l + parentWidth
        val tbottom = t + parentHeight
        recyclerViewMyMembers.layout(tleft, ttop, tright, tbottom)
    }




    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)

        // Create a measure specification for the RecyclerView's height that allows it to be as big as it wants, up to the specified size.
        val heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.AT_MOST)

        recyclerViewMyMembers.measure(widthMeasureSpec, heightSpec)

        // Let's measure the ViewGroup to be as big as it's allowed.
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

}

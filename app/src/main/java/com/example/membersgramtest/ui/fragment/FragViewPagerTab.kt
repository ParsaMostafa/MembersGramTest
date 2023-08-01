package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.R
import com.example.membersgramtest.adaptor.ViewPagerFragmentAdapter
import com.example.membersgramtest.ui.layout.FragViewPagerTablayout
import com.google.android.material.tabs.TabLayoutMediator

class FragViewPagerTab: Fragment() {

    lateinit var fragViewPagerTablayout: FragViewPagerTablayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragViewPagerTablayout = FragViewPagerTablayout(requireContext())
        return fragViewPagerTablayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!isAdded) {
            return
        }

        fragViewPagerTablayout.viewpager2.adapter = ViewPagerFragmentAdapter(this)


        // After attaching the TabLayoutMediator
        TabLayoutMediator(
            fragViewPagerTablayout.tablayout,
            fragViewPagerTablayout.viewpager2
        ) { tab, position ->
            // inflate custom tab view
            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_custom_view, null)
            val tabTitle = tabView.findViewById<TextView>(R.id.tab_title)
            val tabIcon = tabView.findViewById<ImageView>(R.id.tab_icon)

            // Set the tab's text and icon based on the position
            when (position) {
                0 -> {
                    tabTitle.text = "Member"
                    tabIcon.setImageResource(R.drawable.person_bue_24dp__2_) // Replace with your actual icon resource
                }

                1 -> {
                    tabTitle.text = "View"
                    tabIcon.setImageResource(R.drawable.visibility_black_24dp__2_) // Replace with your actual icon resource
                }
                // Add more positions if you have more tabs
            }

            // Set custom view to tab
            tab.customView = tabView
        }.attach()


    }
}

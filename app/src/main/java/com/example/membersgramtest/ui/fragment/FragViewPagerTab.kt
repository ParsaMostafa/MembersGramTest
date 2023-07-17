package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        // Setup the TabLayout to work with ViewPager2
        TabLayoutMediator(
            fragViewPagerTablayout.tablayout,
            fragViewPagerTablayout.viewpager2
        ) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }

}

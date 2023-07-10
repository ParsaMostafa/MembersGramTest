package com.example.membersgramtest.ui.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.membersgramtest.R
import com.example.membersgramtest.adaptor.PagerAdaptor
import com.example.membersgramtest.ui.layout.IntroLayout
import com.example.membersgramtest.utillity.MyData

class IntroFragment : Fragment() {
     lateinit var introLayout: IntroLayout
     lateinit var pagerAdapter: PagerAdaptor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        introLayout = IntroLayout(requireContext())
        return introLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create the data list
        val dataList = listOf(
            MyData(
                "Increase member",
                "Order as many members as you want for your  channels and groups",
                R.drawable.ic_intro_page_one
            ),
            MyData(
                "Visit increase",
                "The number of ordered members will be recorded on the last 5 posts",
                R.drawable.ic_intro_page_two
            ),
            MyData(
                "Get coins",
                "With each member in the channels, you can receive free coins and subscribe with coins",
                R.drawable.ic_intro_page_three
            )
        )

        // Initialize the PagerAdapter
        pagerAdapter = PagerAdaptor(dataList)


        introLayout.viewPager.adapter = pagerAdapter

        // Set up the DotsIndicator
      introLayout.circleIndicator.setViewPager(introLayout.viewPager)


        introLayout.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_privicyFragment)
        }

    }
}

package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.membersgramtest.R
import com.example.membersgramtest.adaptor.viewpagerCoinAdaptor
import com.example.membersgramtest.ui.layout.Viwepagercionlayout
import com.example.membersgramtest.viewmodel.MyRepository
import com.example.membersgramtest.viewmodel.TransferViewModel
import com.google.android.material.tabs.TabLayoutMediator

class FragviewpagerCoin : Fragment() {

    private lateinit var viwepagercionlayout: Viwepagercionlayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viwepagercionlayout = Viwepagercionlayout(requireContext())
        val fragmentList = arrayListOf<Fragment>(
            FragmentTransferCoin(),
            FragCoinBuy()
        )

        val adapter = viewpagerCoinAdaptor(
           requireActivity().supportFragmentManager,
            lifecycle,
            fragmentList
        )
        viwepagercionlayout.viewpager2coin.adapter = adapter
        return viwepagercionlayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!isAdded) {
            return
        }

        Log.d("FragviewpagerCoin", "onViewCreated")




        // After attaching the TabLayoutMediator
        TabLayoutMediator(
            viwepagercionlayout.tablayoutcoin,
            viwepagercionlayout.viewpager2coin
        ) { tab, position ->
            // inflate custom tab view
            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_custom_view, null)
            val tabTitle = tabView.findViewById<TextView>(R.id.tab_title)
            val tabIcon = tabView.findViewById<ImageView>(R.id.tab_icon)

            // Set the tab's text and icon based on the position
            when (position) {
                0 -> {
                    tabTitle.text = "Buy"
                }
                1 -> {
                    tabTitle.text = "Transfer"
                }
                // Add more positions if you have more tabs
            }

            // Set custom view to tab
            tab.customView = tabView
        }.attach()
    }

    override fun onStart() {
        super.onStart()
        Log.d("FragviewpagerCoin", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragviewpagerCoin", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragviewpagerCoin", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragviewpagerCoin", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragviewpagerCoin", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragviewpagerCoin", "onDestroy")
    }
}

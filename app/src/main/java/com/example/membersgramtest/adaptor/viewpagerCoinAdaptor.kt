package com.example.membersgramtest.adaptor

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.membersgramtest.ui.fragment.FragCoinBuy
import com.example.membersgramtest.ui.fragment.FragmentTransferCoin
import android.util.Log // Import the Log class
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.manager.Lifecycle
import com.example.membersgramtest.viewmodel.TransferViewModel

class viewpagerCoinAdaptor(fm: FragmentManager, lifecycle: androidx.lifecycle.Lifecycle, list:ArrayList<Fragment>) : FragmentStateAdapter(fm,lifecycle) {

    private val fragmentList : ArrayList <Fragment> = list
    override fun getItemCount(): Int {
        val itemCount = 2
        Log.d("viewpagerCoinAdaptor", "getItemCount() called with itemCount: $itemCount")
        return itemCount
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> FragCoinBuy()
            else -> FragmentTransferCoin()
        }
        Log.d("viewpagerCoinAdaptor", "createFragment() called with position: $position")
        return fragment
    }
}

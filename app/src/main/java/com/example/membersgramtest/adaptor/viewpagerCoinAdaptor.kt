package com.example.membersgramtest.adaptor



import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.membersgramtest.ui.fragment.FragCoinBuy
import com.example.membersgramtest.ui.fragment.FragmentTransferCoin


class viewpagerCoinAdaptor(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragCoinBuy()
            else -> FragmentTransferCoin()
        }
    }
}

package com.example.membersgramtest.adaptor
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.membersgramtest.ui.fragment.FragStoreDetails
import com.example.membersgramtest.ui.fragment.FragStoreDetails2


class ViewPagerFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragStoreDetails()
            else -> FragStoreDetails2()
        }
    }
}


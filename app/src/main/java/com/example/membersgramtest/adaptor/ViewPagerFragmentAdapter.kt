package com.example.membersgramtest.adaptor
import FragStoreDetails2
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.membersgramtest.ui.fragment.FragStoreDetails



class ViewPagerFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragStoreDetails()
            else -> FragStoreDetails2()
        }
    }
}


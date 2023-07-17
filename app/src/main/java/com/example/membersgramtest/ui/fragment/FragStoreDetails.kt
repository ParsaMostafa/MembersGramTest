package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.membersgramtest.ui.layout.FragStorelayout

class FragStoreDetails: Fragment() {

    private lateinit var fragStoreLayout: FragStorelayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragStoreLayout = FragStorelayout(requireContext())
        return fragStoreLayout
    }
}

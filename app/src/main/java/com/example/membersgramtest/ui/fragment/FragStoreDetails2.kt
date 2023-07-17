package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.membersgramtest.ui.layout.FragStorelayout2

class FragStoreDetails2:Fragment() {
    private lateinit var fragStoreLayout2: FragStorelayout2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragStoreLayout2 = FragStorelayout2(requireContext())
        return fragStoreLayout2
    }




}


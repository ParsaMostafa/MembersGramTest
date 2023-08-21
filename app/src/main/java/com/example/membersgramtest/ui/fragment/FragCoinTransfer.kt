package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.membersgramtest.ui.layout.FragCoinlayout
import com.example.membersgramtest.ui.layout.FragTransferlayout

class FragCoinTransfer: Fragment() {

    lateinit var fragTransferlayout: FragTransferlayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragTransferlayout = FragTransferlayout(requireContext())
        return fragTransferlayout
    }









}
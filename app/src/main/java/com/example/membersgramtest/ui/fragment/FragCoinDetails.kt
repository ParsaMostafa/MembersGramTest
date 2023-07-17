package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.membersgramtest.ui.layout.FragCoinlayout

class FragCoinDetails: Fragment() {

    lateinit var fragCoinlayout: FragCoinlayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragCoinlayout =FragCoinlayout(requireContext())
        return fragCoinlayout
    }









}
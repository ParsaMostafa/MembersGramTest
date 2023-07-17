package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.example.membersgramtest.ui.layout.FragCoinlayout
import com.example.membersgramtest.ui.layout.FragMenberslayout

class FragMeberDetails:  Fragment() {

    lateinit var fragMenberslayout: FragMenberslayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragMenberslayout = FragMenberslayout(requireContext())
        return fragMenberslayout
    }
}


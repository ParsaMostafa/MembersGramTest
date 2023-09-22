package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.membersgramtest.ui.layout.FragCoinlayout
import com.example.membersgramtest.ui.layout.FragMenberslayout
import com.example.membersgramtest.viewmodel.MemberDetViewmodel

class FragMeberDetails:  Fragment() {

    lateinit var fragMenberslayout: FragMenberslayout
    private val viewModel:MemberDetViewmodel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragMenberslayout = FragMenberslayout(requireContext())

        return fragMenberslayout
    }


}


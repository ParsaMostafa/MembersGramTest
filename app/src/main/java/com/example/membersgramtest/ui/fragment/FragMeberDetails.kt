package com.example.membersgramtest.ui.fragment

import MyMemberViewmodel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.membersgramtest.ui.layout.FragMenberslayout


class FragMeberDetails:  Fragment() {

    lateinit var fragMenberslayout: FragMenberslayout
    private val viewModel:MyMemberViewmodel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragMenberslayout = FragMenberslayout(requireContext())

        return fragMenberslayout
    }


}


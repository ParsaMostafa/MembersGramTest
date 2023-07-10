package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.membersgramtest.R
import com.example.membersgramtest.ui.layout.JoinBot
import com.example.membersgramtest.ui.layout.PrivacyPolicy

class JoinBotFragment :Fragment() {
    lateinit var joinBot: JoinBot

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        joinBot = JoinBot(requireContext())
        return joinBot
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        joinBot.button.setOnClickListener {
            findNavController().navigate(R.id.action_joinBotFragment_to_verifyFragment6)

        }
    }



}
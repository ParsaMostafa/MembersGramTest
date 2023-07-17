package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.membersgramtest.R
import com.example.membersgramtest.ui.layout.PrivacyPolicy

class privicyFragment : Fragment() {
     lateinit var privicypalicy :PrivacyPolicy

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         privicypalicy = PrivacyPolicy(requireContext())
        return privicypalicy
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        privicypalicy.button.setOnClickListener {
            findNavController().navigate(R.id.action_privicyFragment_to_joinBotFragment)
        }
    }
}
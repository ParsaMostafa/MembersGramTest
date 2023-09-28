package com.example.membersgramtest.ui.fragment

import MyMemberViewmodel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.membersgramtest.adaptor.AdaptorMyMembers
import com.example.membersgramtest.ui.layout.FragMenberslayout


class FragMeberDetails:  Fragment() {

    lateinit var fragMenberslayout: FragMenberslayout
    private val viewModel:MyMemberViewmodel by viewModels()
    private val adapter = AdaptorMyMembers()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragMenberslayout = FragMenberslayout(requireContext())
        return fragMenberslayout
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Set up RecyclerView with the adapter
         fragMenberslayout.recyclerViewMyMembers.layoutManager = LinearLayoutManager(requireContext())
        fragMenberslayout.recyclerViewMyMembers.adapter = adapter

        // Observe the data from the view model
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.TabMyMemberList.collect { memberList ->
                Log.d("CyberWolf" , memberList.toString())
                // Update the UI with the new data
                adapter.submitList(memberList)
            }
        }

        // Trigger the data creation in the view model
        viewModel.createListOfMyMemberTab()
    }
    }





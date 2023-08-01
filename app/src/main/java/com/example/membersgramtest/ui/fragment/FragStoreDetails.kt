package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.membersgramtest.adaptor.StoreAdaptor
import com.example.membersgramtest.ui.layout.FragStorelayout
import com.example.membersgramtest.viewmodel.VeryfiViewModel
import com.example.membersgramtest.viewmodel.ViewModelMember
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FragStoreDetails: Fragment() {

    private lateinit var fragStoreLayout: FragStorelayout
    private val viewModel: ViewModelMember by viewModels()
    private var adapter = StoreAdaptor()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragStoreLayout = FragStorelayout(requireContext())
        return fragStoreLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        observeApiResponse()
    }

    private fun observeApiResponse() {
        lifecycleScope.launchWhenStarted {
            viewModel.memberBundles.collect { memberBundles ->
                adapter.submitList(memberBundles)
            }
        }
    }


    private fun setupRecyclerView() {
        fragStoreLayout.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@FragStoreDetails.adapter
        }
    }
}

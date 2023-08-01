package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.R
import com.example.membersgramtest.adapter.BodyItemRv1Adapter
import com.example.membersgramtest.adaptor.AdaptorRv2
import com.example.membersgramtest.models.memberview.Rv1Model
import com.example.membersgramtest.viewmodel.ViewModelViewTab
import kotlinx.coroutines.launch

class FragStoreDetails2 : Fragment() {
    private val viewModel: ViewModelViewTab by viewModels()
    private lateinit var rv1Adapter: BodyItemRv1Adapter
    private lateinit var rv2Adapter: AdaptorRv2
    private lateinit var rv1: RecyclerView
    private lateinit var rv2: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rv_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv1 = view.findViewById(R.id.recyclerView1)
        rv2 = view.findViewById(R.id.recyclerView2)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        rv1Adapter = BodyItemRv1Adapter { rv1Model ->
            viewModel.filterDataX(rv1Model.count_post)
        }

        rv2Adapter = AdaptorRv2()

        rv1.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = rv1Adapter
        }

        rv2.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = rv2Adapter
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.RV1objects.collect { rv1Items ->
                rv1Adapter.submitList(rv1Items.filterIsInstance<Rv1Model.Rv1BodyModel>())
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.RV2objects.collect { rv2Items ->
                rv2Adapter.submitList(rv2Items)
            }
        }
    }

}

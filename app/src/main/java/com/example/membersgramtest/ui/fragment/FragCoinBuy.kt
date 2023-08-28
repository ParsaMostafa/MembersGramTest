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
import com.example.membersgramtest.adaptor.AdaptorBuyCoin
import com.example.membersgramtest.viewmodel.ViewModelBuyCoins
import kotlinx.coroutines.launch

class FragCoinBuy : Fragment() {

    private val viewModel: ViewModelBuyCoins by viewModels()
    private lateinit var rv: RecyclerView
    private lateinit var rvAdapter: AdaptorBuyCoin

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.buy_coin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.recyclerViewBuyCoin)

        setupRecyclerView()

        observeViewModel()


    }

    private fun observeViewModel() {
        // Use collect to observe the Items flow
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.Items.collect { items ->
                // Update the adapter's data when the Items flow emits new data
                rvAdapter.submitList(items)
            }
        }
    }

    private fun setupRecyclerView() {
        rvAdapter = AdaptorBuyCoin()

        rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = rvAdapter
        }
    }


}

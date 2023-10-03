package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.R
import com.example.membersgramtest.viewmodel.ViewModelPayment
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PaymentFragment : Fragment() {

    private val viewModelPayment: ViewModelPayment by viewModels()
   // private lateinit var adptorpaymentchips: AdaptorPaymentChips

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setting up Toolbar
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)

        // Set a click listener for the navigation icon (back button)
        toolbar.setNavigationOnClickListener {
            // Navigate back to the previous fragment using FragmentManager
            requireActivity().supportFragmentManager.popBackStack()
        }

        // Observe the transactionResponse StateFlow
        lifecycleScope.launch {
            viewModelPayment.transactionResponse.collect { response ->
                // Handle the response when it becomes available
                if (response != null) {
                    Log.d("CyberWolfFragment" , response.toString())
                    // You can update your UI or perform any actions with the response here
                }
            }
        }




        // ChipsPayment

        // Initialize your RecyclerView and adapter
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView1)
        // adptorpaymentchips = AdaptorPaymentChips()

        // Set up the RecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
           // adapter = adptorpaymentchips
        }


        // Observe the PagingData from ViewModel
        lifecycleScope.launch {
            viewModelPayment.getTransactionResponseFlow().collectLatest { pagingData ->
                Log.d("Cyber", pagingData.toString() )
              //  transactionAdapter.submitData(pagingData)
            }
        }
    }



    }


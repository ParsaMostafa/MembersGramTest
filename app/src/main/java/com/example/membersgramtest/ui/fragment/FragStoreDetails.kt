package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.membersgramtest.R
import com.example.membersgramtest.adaptor.AdaptorRv2member
import com.example.membersgramtest.adaptor.Rv1MemberAdaptorclass
import com.example.membersgramtest.models.memberresponse.RV1Member
import com.example.membersgramtest.viewmodel.ViewModelMember
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragStoreDetails: Fragment() {


    private val viewModel: ViewModelMember by viewModels()
    private lateinit var rv1: RecyclerView
    private lateinit var rv1Adapter: Rv1MemberAdaptorclass
    private lateinit var rv2: RecyclerView
    private lateinit var rv2Adapter: AdaptorRv2member
    private lateinit var loadingProgressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.rvs_member, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv1 = view.findViewById(R.id.rv1mem)
        rv2 = view.findViewById(R.id.rv2mem)
        // پیدا کردن ProgressBar از طریق آی‌دی
        loadingProgressBar = view.findViewById(R.id.loadingProgressBar)

        setupRecyclerView()
        observeViewModel()
        observeViewModelrv2()


        rv1Adapter.notifyDataSetChanged() // Notify the adapter of the changes
    }

    private fun observeViewModelrv2() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.RV2memberobjects.collect {
                Log.d("FragStorerv2", "RV2Items content: $it")
                loadingProgressBar.visibility = View.VISIBLE

                delay(3000)

                rv2Adapter.submitList(it)
                loadingProgressBar.visibility = View.GONE

                // Logging count_post values received from the response



            }
        }

    }

    private fun setupRecyclerView() {
        rv1Adapter = Rv1MemberAdaptorclass { rv1Model ->
            val countryCode = rv1Model.countryCode
            Log.d("vd", "$countryCode")
            viewModel.fetchCountryDetails(countryCode)
        }

        rv2Adapter = AdaptorRv2member()

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
            viewModel.RV1memberobjects.collect { rv1Items ->
                Log.d("FragStoreDetailsm", "RV2Items content: $rv1Items")
                loadingProgressBar.visibility = View.VISIBLE


                delay(3000)
                val bodyItems = rv1Items.filterIsInstance<RV1Member.RV1Model>()
                rv1Adapter.submitList(bodyItems)
                loadingProgressBar.visibility = View.GONE

                // Logging count_post values received from the response
                Log.d("Frag", "$bodyItems")
                bodyItems.forEach { rv1Model ->
                    val countryCode = rv1Model.countryCode
                    if (countryCode != null) {
                        Log.d("Frag2", "RV1 count_post: $countryCode")
                    } else {
                        Log.d("Frag2", "RV1 countryCode is null")
                    }
                }

            }
        }
    }
}






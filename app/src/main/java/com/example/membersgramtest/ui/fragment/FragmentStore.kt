package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.membersgramtest.R
import com.example.membersgramtest.databinding.MainStoreBinding

class FragmentStore : Fragment() {
    private lateinit var navController: NavController
    private var binding: MainStoreBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_store, container, false)
        // Replace "R.layout.main_store" with the layout file you're using for FragmentStore

        binding = MainStoreBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        graph.setStartDestination(R.id.fragViewPagerTab3)

        navController.graph = graph

        binding?.bottomNavigation?.setupWithNavController(navController)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}


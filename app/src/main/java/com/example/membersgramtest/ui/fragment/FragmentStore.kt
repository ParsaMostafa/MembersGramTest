package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.membersgramtest.R
import com.example.membersgramtest.databinding.MainStoreBinding
import com.example.membersgramtest.ui.layout.CoinTransferLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentStore : Fragment() {
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_store, container, false)
        // Replace "R.layout.main_store" with the layout file you're using for FragmentStore
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragmentContainerViewStore) as NavHostFragment
        navController = navHostFragment.navController

        // Setup the BottomNavigationView with the NavController
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setupWithNavController(navController)

    }


}


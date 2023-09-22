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
    private var binding: MainStoreBinding? = null
    private lateinit var coinTransferLayout: CoinTransferLayout // Declare an instance of CoinTransferLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_store, container, false)
        // Replace "R.layout.main_store" with the layout file you're using for FragmentStore

        binding = MainStoreBinding.bind(view)

        // Create an instance of CoinTransferLayout and add it to the fragment's layout
        coinTransferLayout = CoinTransferLayout(requireContext()) // Create an instance


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController



        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val phoneNumberInputLayout = coinTransferLayout.phoneNumberInputLayout
        val coinNumberInputLayout = coinTransferLayout.coinNumberInputLayout

        // Add an OnFocusChangeListener to the phoneNumberInputLayout
        phoneNumberInputLayout.editText?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Hide the BottomNavigationView when phoneNumberInputLayout gains focus
                bottomNavigationView.visibility = View.GONE
            } else {
                // Show the BottomNavigationView when phoneNumberInputLayout loses focus
                bottomNavigationView.visibility = View.VISIBLE
            }
        }

        // Add an OnFocusChangeListener to the coinNumberInputLayout
        coinNumberInputLayout.editText?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Hide the BottomNavigationView when coinNumberInputLayout gains focus
                bottomNavigationView.visibility = View.GONE
            } else {
                // Show the BottomNavigationView when coinNumberInputLayout loses focus
                bottomNavigationView.visibility = View.VISIBLE
            }
        }


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


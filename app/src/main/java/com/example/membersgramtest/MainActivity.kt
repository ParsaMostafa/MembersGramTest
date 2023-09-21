package com.example.membersgramtest

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import com.example.membersgramtest.viewmodel.TransferViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Window object
        val window = window

        // Set the Soft Input Mode to adjustPan
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)




        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val preferencesHelper = PreferencesHelper

        navController.addOnDestinationChangedListener { _, destination, _ ->
            // If user is already logged in and token is not null, navigate to the store fragment
            if (preferencesHelper.isLoggedIn && preferencesHelper.apiToken != null && destination.id != R.id.fragmentStore) {
                navController.navigate(R.id.fragmentStore)
            }
        }
    }
}

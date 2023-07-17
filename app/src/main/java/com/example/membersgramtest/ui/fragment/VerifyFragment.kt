package com.example.membersgramtest.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.membersgramtest.R
import com.example.membersgramtest.models.v1.MyResponse
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import com.example.membersgramtest.ui.layout.VerifyPage
import com.example.membersgramtest.viewmodel.VeryfiViewModel
import kotlinx.coroutines.launch

class VerifyFragment : Fragment() {
    lateinit var verifyPage: VerifyPage
    private lateinit var sharedPreferences: SharedPreferences
    private val viewModel: VeryfiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        verifyPage = VerifyPage(requireContext())
        return verifyPage
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        verifyPage.setFabAction {
            val phoneNumber = verifyPage.phoneNumEditText.text.toString()

            if(phoneNumber.isEmpty()) {
                verifyPage.phoneNumInputLayout.setError("Phone number cannot be empty")
                return@setFabAction
            }

            if(!isValidPhoneNumber(phoneNumber)) {
                verifyPage.phoneNumInputLayout.setError("Invalid phone number format")
                return@setFabAction
            }

            PreferencesHelper.phoneNumber = phoneNumber
            sendApiRequest(phoneNumber)
            findNavController().navigate(R.id.action_verifyFragment6_to_sendSmsFragment)
        }
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        // Phone number should be 12 digits and start with 98
        val regex = "^98\\d{10}$".toRegex()

        return phoneNumber.matches(regex)
    }


    private fun sendApiRequest(phoneNumber: String) {
        val market = "zarinpal"
        val tg_id = 745989997

        lifecycleScope.launch {
            viewModel.PhoneNumberv1(phoneNumber, market, tg_id)
                .collect {response ->
                    if (response.isSuccessful){
                        val myResponse: MyResponse? = response.body()
                        Log.d("API V1", "Success: $myResponse")
                    }  else
                    {
                        val errorBody = response.errorBody()?.string()
                        Log.d("API V1", "Error: $errorBody")
                    }
                }
        }
    }
}

package com.example.membersgramtest.ui.fragment
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.membersgramtest.R
import com.example.membersgramtest.models.v2.VerifyRegisterResponse
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import com.example.membersgramtest.ui.layout.SendanSMSlayout
import com.example.membersgramtest.viewmodel.VeryfiViewModel
import kotlinx.coroutines.launch


class SendSmsFragment : Fragment() {
    private lateinit var sendanSMSlayout: SendanSMSlayout
    private lateinit var sharedPreferences: SharedPreferences
    private val viewModel: VeryfiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sendanSMSlayout = SendanSMSlayout(requireContext())
        return sendanSMSlayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferencesHelper = PreferencesHelper


        val phoneNumber = preferencesHelper.phoneNumber


        val verificationCodeEditText = sendanSMSlayout.phoneNumEditText
        verificationCodeEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val verificationCode = s.toString()
                if (verificationCode.length == 5) {
                    // Call the API request function
                    sendApiRequest(phoneNumber, verificationCode)


                }
            }
        })
    }



    private fun sendApiRequest(phoneNumber: String?, verificationCode: String) {
        lifecycleScope.launch {
            viewModel.verifyPhoneNumber(phoneNumber ?: "", verificationCode.toInt()).collect { response ->
                if (response.isSuccessful) {
                    val verifyRegisterResponse: VerifyRegisterResponse? = response.body()
                    Log.d("API Response", "Success: $verifyRegisterResponse")

                    // Save token into shared preferences
                    val token = verifyRegisterResponse?.data?.data?.token
                    PreferencesHelper.apiToken = token
                    PreferencesHelper.isLoggedIn = true

                    // Log the saved token
                    Log.d("SavedToken", "Token: ${PreferencesHelper.apiToken ?: "null"}")

                    if (token != null) {
                        // Navigate to the store fragment only after the token is saved
                        findNavController().navigate(R.id.action_sendSmsFragment_to_fragmentStore)
                    } else {
                        // Show alert dialog if token is null
                        activity?.runOnUiThread {
                            AlertDialog.Builder(requireContext())
                                .setTitle("Error")
                                .setMessage("Token not received. Please try again.")
                                .setPositiveButton("OK", null)
                                .show()
                        }
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.d("API Response", "Error: $errorBody")
                }
            }
        }
    }






}

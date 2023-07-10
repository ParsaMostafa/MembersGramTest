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
import com.example.membersgramtest.utillity.Consts
import com.example.membersgramtest.viewmodel.VeryfiViewModel
import kotlinx.coroutines.flow.collect
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
            PreferencesHelper.phoneNumber = phoneNumber
            sendApiRequest(phoneNumber)
            findNavController().navigate(R.id.action_verifyFragment6_to_sendSmsFragment)
        }



    }

    private fun sendApiRequest(phoneNumber: String,
                               market: String = "zarinpal" ,
                               tg_id: Int = Consts.TG_ID) {

        lifecycleScope.launch {
            viewModel.PhoneNumberv1(phoneNumber,
                market ,
            tg_id)

                .collect {response ->
                    if (response.isSuccessful){
                        val myResponse:MyResponse? = response.body()
                        Log.d("API Response", "Success: $myResponse")
                    }  else
                    {
                        val errorBody = response.errorBody()?.string()
                        Log.d("myResponse", "Error: $errorBody")
                    }


                }
        }



    }


}
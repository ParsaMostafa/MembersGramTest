package com.example.membersgramtest.ui.fragment

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.membersgramtest.R
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import com.example.membersgramtest.ui.layout.CoinTransferLayout
import com.example.membersgramtest.viewmodel.TransferViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.i18n.phonenumbers.PhoneNumberUtil
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentTransferCoin : Fragment() {

    // Define a list of valid country codes
    private val validCountryCodes = listOf(
        "1", "20", "27", "30", "31", "32", "33", "34", "36", "39", "40",
        "41", "43", "44", "45", "46", "47", "48", "49", "51", "52",
        "53", "54", "55", "56", "57", "58", "60", "61", "62", "63",
        "64", "65", "66", "81", "82", "84", "86", "90", "91", "92",
        "93", "94", "98", "212", "213", "234", "254", "255", "256",
        "260", "263", "972"
    )

    private lateinit var coinTransferLayout: CoinTransferLayout
    private lateinit var phoneNumber: String
    private val viewModel: TransferViewModel by activityViewModels()

    private lateinit var sharedPreferences: SharedPreferences
    private var countDownTimer: CountDownTimer? = null
    private var isTimerRunning = false
    private val phoneNumberUtil = PhoneNumberUtil.getInstance()
    private lateinit var countryCodeDialog: CountryCodeDialog
    private val preferencesHelper = PreferencesHelper




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        coinTransferLayout = CoinTransferLayout(requireContext())


        return coinTransferLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve phone number from preferences
        val preferencesHelper = PreferencesHelper
        val number = preferencesHelper.phoneNumber
        val phoneNumber1 = coinTransferLayout.phoneNumberEditText.text.toString()
        val countrycode = coinTransferLayout.countryCodeEditText.text.toString()
        val coin = coinTransferLayout.coinNumberEditText.text.toString()
        val button = coinTransferLayout.transferButton

        // Set up a TextWatcher to update the ViewModel's phone number Flow
        coinTransferLayout.phoneNumberEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("FragmentTransferCoin", "beforeTextChanged")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setPhoneNumber(s.toString())
                Log.d("FragmentTransferCoin", "onTextChanged")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("FragmentTransferCoin", "afterTextChanged")
            }
        })

        coinTransferLayout.coinNumberEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("FragmentTransferCoin", "beforeCoinTextChanged")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("FragmentTransferCoin", "OnCoinTextChanged")
                viewModel.setCoinNumber(s.toString())

            }

            override fun afterTextChanged(s: Editable?) {

                Log.d("FragmentTransferCoin", "AfterCoinTextChanged")
            }
        })









        // Observe the ViewModel's phone number Flow and update the UI
        coinTransferLayout.phoneNumberEditText.setText(viewModel.phoneNumber222)
        val phoneNumber222 = viewModel.phoneNumber222
        Log.d("FragmentTransferCoin", "phoneNumber222: $phoneNumber222")

        // Observe the ViewModel's coin number Flow and update the UI
        coinTransferLayout.coinNumberEditText.setText(viewModel.coinNumber222)
        val coinNumber222 = viewModel.coinNumber222
        Log.d("FragmentTransferCoin", "coinNumber222: $coinNumber222")




        setupErrorFlowObservers()
        setupTimer()
        handleEvents()
        updateButtonState(button)


        // Observe the bottomSheetVisibleState flow to show/hide the bottom sheet
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.bottomSheetVisibleState.collect { isVisible ->
                Log.d("FragmentTransferCoin", "bottomSheetVisibleState collect")

                Log.d("FragmentTransferCoin", isVisible.toString())
                if (isVisible) {
                    Log.d("FragmentTransferCoin", isVisible.toString())
                    // Show the bottom sheet
                    showBottomSheet()
                } else {
                    // Hide the bottom sheet (if it's currently shown)
                    hideBottomSheet()
                }
            }
        }







        countryCodeDialog = CountryCodeDialog(requireContext(), object : CountryCodeDialog.OnCountryCodeSelectedListener {
            override fun onCountryCodeSelected(countryCode: String) {
                coinTransferLayout.countryCodeEditText.setText(countryCode)
            }
        })

        coinTransferLayout.countryCodeEditText.setOnClickListener {
            countryCodeDialog.show()
        }
    }

        private fun updateButtonState(button: MaterialButton) {
            val phoneNumberEditText = coinTransferLayout.countryCodeEditText.text.toString()
            val phoneNumberRest = coinTransferLayout.phoneNumberEditText.text.toString()
             val coin = coinTransferLayout.coinNumberEditText.text.toString()

       val isAnyFieldEmpty =
            phoneNumberRest.isEmpty() && coin.isEmpty()

      if (isAnyFieldEmpty) {
           val buttonDisabledColor = Color.parseColor("#E0E0E0")
            val buttonTextDisabledColor = Color.parseColor("#616161")
          button.isEnabled = false
           button.setBackgroundColor(buttonDisabledColor)
        button.setTextColor(buttonTextDisabledColor)
       } else
       if ( phoneNumberRest.isNotEmpty() && coin.isNotEmpty()){
          button.isEnabled = true
           button.setBackgroundColor(Color.parseColor("#1976D2"))
           button.setTextColor(Color.parseColor("#FFFFFF"))
       }
    }


    private fun setupErrorFlowObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.errorFlowPhoneNumber.collectLatest { error ->
                if (error.isEmpty()) {
                    Log.d("FragmentTransferCoin", "ERROR Phonenumber inputlayout COLLECT : $error")
                    coinTransferLayout.phoneNumberInputLayout.error = null
                } else {
                    val customTypeface = context?.let { ResourcesCompat.getFont(it, R.font.product_sans_regular) }
                    Log.d("FragmentTransferCoin", "ERROR Phonenumber inputlayout COLLECT : $error")
                    coinTransferLayout.phoneNumberInputLayout.error = error

                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.errorFlowCoinNumber.collectLatest {
                if (it.isEmpty()) {
                coinTransferLayout.coinNumberInputLayout.error = null
                } else {

                    coinTransferLayout.coinNumberInputLayout.error = it
                }
            }
        }
    }

    private fun setupTimer() {
        coinTransferLayout.transferButton.setOnClickListener {
            Log.d("FragmentTransferCoin", "setOnClickListener :$it")
            viewModel.startTimer(60) // Replace 60 with your desired duration in seconds
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.timerState.collect { timerState ->
                if (timerState.isRunning) {
                    Log.d("FragmentTransferCoin", "Timer State is running  :$timerState")
                    coinTransferLayout.transferButton.text = "Retry in ${timerState.secondsRemaining} seconds"
                    coinTransferLayout.transferButton.isEnabled = false
                    coinTransferLayout.transferButton.setBackgroundColor(Color.GRAY)
                    coinTransferLayout.transferButton.setTextColor(Color.WHITE)
                } else {
                    Log.d("FragmentTransferCoin", "Timer State is Stoped  :$timerState")
                    coinTransferLayout.transferButton.text = "Transfer"
                    coinTransferLayout.transferButton.isEnabled = true
                    coinTransferLayout.transferButton.setBackgroundColor(Color.parseColor("#1976D2"))
                    coinTransferLayout.transferButton.setTextColor(Color.parseColor("#FFFFFF"))
                }
            }
        }
    }

    private fun showBottomSheet() {
        val phoneNumber1 = coinTransferLayout.phoneNumberEditText.text.toString()
        val countrycode = coinTransferLayout.countryCodeEditText.text.toString()
        val coin = coinTransferLayout.coinNumberEditText.text.toString()
        val bundle = Bundle()
        bundle.putString("phoneNumber", "$phoneNumber1")
        bundle.putString("coin", "$coin")
        // Create your BottomSheetDialogFragment
        val bottomSheetFragment = SuccessfultransferBottomsheet()

        // Set arguments if needed
        bottomSheetFragment.arguments = bundle

        // Show the bottom sheet
        bottomSheetFragment.show(
            (requireActivity() as AppCompatActivity).supportFragmentManager,
            bottomSheetFragment.tag
        )
        Log.d("FragmentTransferCoin", "showBottomSheet")
    }

    private fun hideBottomSheet() {
        // Dismiss the bottom sheet if it's currently shown
        Log.d("FragmentTransferCoin", "hideBottomSheet")
        val bottomSheetFragment =
            (requireActivity() as AppCompatActivity).supportFragmentManager
                .findFragmentByTag(MyBottomSheetDialogFragment::class.java.simpleName)

        if (bottomSheetFragment != null) {
            (bottomSheetFragment as MyBottomSheetDialogFragment).dismiss()
        }
    }


    private fun handleEvents() {
        val button = coinTransferLayout.transferButton
        Log.d("FragmentTransferCoin", "handleEvents")

        // Initialize variables to store the previous error messages

        var previousCoinError: String? = null

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("FragmentTransferCoin", "handleEventsBeforeTextChange")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("FragmentTransferCoin", "handleEventsOnTextChange")
                updateButtonState(button)
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.errorFlowPhoneNumber.emit("")
                    viewModel.errorFlowCoinNumber.emit("")
                }
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("FragmentTransferCoin", "handleEventsAfterTextChange")
            }
        }





        coinTransferLayout.countryCodeEditText.addTextChangedListener(textWatcher)
        coinTransferLayout.coinNumberEditText.addTextChangedListener(textWatcher)
        coinTransferLayout.phoneNumberEditText.addTextChangedListener(textWatcher)


        //button state
        val textWatcher2 = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Check if both EditText fields have non-empty text
                val phoneNumber = coinTransferLayout.phoneNumberEditText.text.toString()
                val coin = coinTransferLayout.coinNumberEditText.text.toString()

                if (phoneNumber.isEmpty() && coin.isEmpty()) {
                    // Both fields are empty, disable the button
                    button.isEnabled = false
                    button.setBackgroundColor(Color.parseColor("#E0E0E0"))
                    button.setTextColor(Color.parseColor("#B0B0B0"))
                } else {
                    // At least one field is not empty, enable the button
                    button.isEnabled = true
                    button.setBackgroundColor(Color.parseColor("#1976D2"))
                    button.setTextColor(Color.parseColor("#FFFFFF")) // Light/Grey/textColorSecondary
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing here
            }
        }


        // Add the textWatcher to both EditText fields
        coinTransferLayout.phoneNumberEditText.addTextChangedListener(textWatcher2)
        coinTransferLayout.coinNumberEditText.addTextChangedListener(textWatcher2)

        coinTransferLayout.transferButton.setOnClickListener {
            Log.d("FragmentTransferCoin", "button Transfer Clicked")
            val phoneNumber = coinTransferLayout.phoneNumberEditText.text.toString()
            val countrycode = coinTransferLayout.countryCodeEditText.text.toString()
            val coin = coinTransferLayout.coinNumberEditText.text.toString()
            val phoneNumberSharedpref = preferencesHelper.phoneNumber
             viewLifecycleOwner.lifecycleScope.launch {
                 if (phoneNumber == null || phoneNumber == "") {
                 Log.d("TransferViewModel", "phonenumberempty")
                 viewModel.errorFlowPhoneNumber.emit("phonenumber cant be empty ")
             }
                 if (coin == null || coin == "") {
                     Log.d("TransferViewModel", "coinempty")
                     viewModel.errorFlowCoinNumber.emit("Coins cant be empty ")
                 }else
                 {

                     viewModel.handleCoinTransfer(countrycode, phoneNumber, coin.toInt())
                 }


             }


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentTransferCoin", "Fragment Destroyed")


    }
}

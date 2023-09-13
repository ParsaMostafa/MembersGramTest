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
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import com.example.membersgramtest.ui.layout.CoinTransferLayout
import com.example.membersgramtest.viewmodel.TransferViewModel
import com.google.i18n.phonenumbers.PhoneNumberUtil
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentTransferCoin : Fragment() {

    private val TAG = "FragmentTransferCoin"

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
    private val viewModel: TransferViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences
    private var countDownTimer: CountDownTimer? = null
    private var isTimerRunning = false
    private val phoneNumberUtil = PhoneNumberUtil.getInstance()
    private lateinit var countryCodeDialog: CountryCodeDialog

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

        setupErrorFlowObservers()
        setupTimer()
        handleEvents()

        // Observe API response
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel._apiResponse.collectLatest { it ->
                Log.d(TAG, "API Response Collected")
                if (it?.body()?.data != null) {
//                    viewModel.bottomSheetVisibleState.tryEmit(true)
                    viewModel.setButtonStateToLoading()
                }
            }
        }

        // Observe the bottomSheetVisibleState flow to show/hide the bottom sheet
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.bottomSheetVisibleState.collect { isVisible ->
                Log.d("tagMag", "bottomSheetVisibleState collect")
                Log.d("tagMag", isVisible.toString())
                if (isVisible) {
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


    private fun setupErrorFlowObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.errorFlowPhoneNumber.collectLatest {
                coinTransferLayout.phoneNumberInputLayout.error = it
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.errorFlowCoinNumber.collectLatest {
                coinTransferLayout.coinNumberInputLayout.error = it
            }
        }
    }

    private fun setupTimer() {
        coinTransferLayout.transferButton.setOnClickListener {
            viewModel.startTimer(60) // Replace 60 with your desired duration in seconds
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.timerState.collect { timerState ->
                if (timerState.isRunning) {
                    coinTransferLayout.transferButton.text = "Retry in ${timerState.secondsRemaining} seconds"
                    coinTransferLayout.transferButton.isEnabled = false
                    coinTransferLayout.transferButton.setBackgroundColor(Color.GRAY)
                    coinTransferLayout.transferButton.setTextColor(Color.WHITE)
                } else {
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
        Log.d("tagMag", "showBottomSheet")
    }

    private fun hideBottomSheet() {
        // Dismiss the bottom sheet if it's currently shown
        val bottomSheetFragment =
            (requireActivity() as AppCompatActivity).supportFragmentManager
                .findFragmentByTag(MyBottomSheetDialogFragment::class.java.simpleName)

        if (bottomSheetFragment != null) {
            (bottomSheetFragment as MyBottomSheetDialogFragment).dismiss()
        }
    }


    private fun handleEvents() {
        val button = coinTransferLayout.transferButton

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                coinTransferLayout.phoneNumberInputLayout.error = null
                coinTransferLayout.coinNumberInputLayout.error = null
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        coinTransferLayout.countryCodeEditText.addTextChangedListener(textWatcher)
        coinTransferLayout.coinNumberEditText.addTextChangedListener(textWatcher)
        coinTransferLayout.phoneNumberEditText.addTextChangedListener(textWatcher)

        coinTransferLayout.transferButton.setOnClickListener {
            Log.d(TAG, "Transfer Button Clicked")
            val phoneNumber = coinTransferLayout.phoneNumberEditText.text.toString()
            val countrycode = coinTransferLayout.countryCodeEditText.text.toString()
            val coin = coinTransferLayout.coinNumberEditText.text.toString()

            viewModel.handleCoinTransfer(countrycode, phoneNumber, coin.toInt())
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.bottomSheetVisibleState.emit(true)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Fragment Destroyed")


    }
}

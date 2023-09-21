package com.example.membersgramtest.viewmodel

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.transferCoin.ResponseCoin
import com.example.membersgramtest.models.transferCoin.TransferCoinRequest
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import com.google.i18n.phonenumbers.PhoneNumberUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response

class TransferViewModel : ViewModel() {
    private val Api = RetrofitInstance.api
    private val preferencesHelper = PreferencesHelper
    private val phoneNumberUtil = PhoneNumberUtil.getInstance()

    private var countDownTimer: CountDownTimer? = null
    private var isTimerRunning = false

    private val phoneNumber = preferencesHelper.phoneNumber
    lateinit var bundle: Bundle
    var showbottomsheet : Boolean = false

    // Inside TransferViewModel
    val loadingState = MutableStateFlow(false)
    val phoneNumberEditTextEnabled = MutableStateFlow(true)
    val coinNumberEditTextEnabled = MutableStateFlow(true)

    val _apiResponse = MutableStateFlow<Response<ResponseCoin>?>(null)
    lateinit var tr: ResponseCoin

    // Inside TransferViewModel
    val buttonStateFlow = MutableStateFlow(ButtonState(false, Color.parseColor("#E0E0E0"), Color.parseColor("#616161")))

    // Inside TransferViewModel
    val bottomSheetVisibleState = MutableSharedFlow<Boolean>()


    var phoneNumber222: String = ""
    var coinNumber222:String = ""






    data class ButtonState(
        val isEnabled: Boolean,
        val backgroundColor: Int,
        val textColor: Int
    )

    // StateFlow to represent timer state
    val timerState = MutableStateFlow(TimerState(0, false))

    val errorFlowPhoneNumber = MutableStateFlow("")
    val errorFlowCoinNumber = MutableStateFlow("")





    init {
        Log.d("TransferViewModel", "ViewModel created")

        viewModelScope.launch {
            errorFlowCoinNumber.collect{
                Log.d("Transfer", "SSSS: $it")

            }
        }





    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TransferViewModel", "ViewModel Destroyed")
    }

    fun setPhoneNumber(phoneNumber: String) = viewModelScope.launch {
        // phoneNumberFlow.emit(phoneNumber)
        phoneNumber222 = phoneNumber
        Log.d("TransferViewModel", phoneNumber)
    }

    fun setCoinNumber(coinNumber: String) = viewModelScope.launch{

        coinNumber222 = coinNumber
        Log.d("TransferViewModel", coinNumber)
    }


    fun handleCoinTransfer(countryCode: String, phoneNumber: String, coinCount: Int) = viewModelScope.launch {
        val fullPhoneNumber = "$countryCode$phoneNumber"
        Log.d("TransferViewModel", "Full Phone Number: $fullPhoneNumber")
        Log.d("TransferViewModel", "Coin: $coinCount")

        // Check coin count constraints


        if (coinCount < 10) {
            Log.d("TransferViewModel", "coin<10 ran")
            errorFlowCoinNumber.emit("You can't transfer under 10 coins")
        } else if (coinCount > 500) {
            Log.d("TransferViewModel", "coin>500 ran")
            errorFlowCoinNumber.emit("You can't transfer more than 500 coins")
        } else {
            Log.d("TransferViewModel", "transferCoin(fullPhoneNumber, coinCount)")
            transferCoin(fullPhoneNumber, coinCount)
        }
    }

    fun setButtonStateToLoading() {

        Log.d("TransferViewModel", "setButtonStateToLoading()")

        // Update loading state
        loadingState.value = true

        // Disable EditText fields
        phoneNumberEditTextEnabled.value = false
        coinNumberEditTextEnabled.value = false

        startTimer(60)
    }

    fun transferCoin (phoneNumber: String, coin: Int) {

        Log.d("TransferViewModel", "transferCoin")

        viewModelScope.launch {
            try {
                val request = TransferCoinRequest(TransferCoinRequest.Data(
                    phoneNumber,
                    coin
                ))
                val response = Api.transferCoin(request)
                tr = response.body()!!

                Log.d("TransferViewModel", "response: ${tr.data}")
                val preferencesHelper = PreferencesHelper
                val number = preferencesHelper.phoneNumber

                when {
                    tr.data != null &&
                            phoneNumber != number &&
                            isValidPhoneNumber(phoneNumber) &&
                            coin.toInt() >= 10 &&
                            coin.toInt() <= 500 -> {
                        Log.d("TransferViewModel", " bottomSheetVisibleState.emit(true)")
                         bottomSheetVisibleState.emit(true)
                         setButtonStateToLoading()
                            Log.d("TransferViewModel", "run the condition")
                            // Add your code here for the first condition
                    }
                    tr.data == null -> {

                        if (phoneNumber != number && isValidPhoneNumber(phoneNumber)) {

                            errorFlowPhoneNumber.emit("Number Doesn't Exist!!")
                            bottomSheetVisibleState.emit(false)
                            Log.d("TransferViewModel", "Number doesn't exist")
                        }
                        if (!isValidPhoneNumber(phoneNumber)) {
                            Log.d("TransferViewModel", "isValidPhoneNumber : Invalid Number heh heh!!")
                            errorFlowPhoneNumber.emit("Invalid Number heh heh!!")
                            bottomSheetVisibleState.emit(false)
                        }
                        if (phoneNumber == number) {
                            Log.d("TransferViewModel", "You Can't Transfer to your account ran ")
                            errorFlowPhoneNumber.emit("You Can't Transfer to your account")
                            bottomSheetVisibleState.emit(false)
                        }
                    }
                }

                _apiResponse.value = response
            } catch (e: Exception) {
                // Handle errors or exceptions as needed
                _apiResponse.value = null // Set the StateFlow value to null on error
            }
        }
    }

    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        // Remove any leading '+' character and whitespace
        val sanitizedPhoneNumber = phoneNumber.trimStart('+')

        // Check if the sanitized phone number has at least 10 characters
        if (sanitizedPhoneNumber.length < 10) {
            return false
        }

        try {
            val numberProto = phoneNumberUtil.parse("+$sanitizedPhoneNumber", null)
            val isValid = phoneNumberUtil.isValidNumber(numberProto)
            Log.d("TransferViewModel", "Input: $phoneNumber, Sanitized: $sanitizedPhoneNumber, isValid: $isValid")
            return isValid
        } catch (e: Exception) {
            Log.e("TransferViewModel", "Error Validation: ${e.message}")
            return false
        }
    }


    // Inside TransferViewModel
    fun updateButtonState(phoneNumberEditText: String, phoneNumberRest: String, coin: String) {
        Log.e("TransferViewModel", "updateButtonState")
        val isAnyFieldEmpty = phoneNumberEditText.isEmpty() || phoneNumberRest.isEmpty() || coin.isEmpty()
        val buttonState = if (isAnyFieldEmpty) {
            ButtonState(false, Color.parseColor("#E0E0E0"), Color.parseColor("#616161"))
        } else {
            ButtonState(true, Color.parseColor("#1976D2"), Color.parseColor("#FFFFFF"))
        }
        buttonStateFlow.value = buttonState
    }

    // Function to start the timer
    fun startTimer(duration: Long) = viewModelScope.launch {
        Log.e("TransferViewModel", "startTimer")
        viewModelScope.launch {
            for (secondsRemaining in duration downTo 0) {
                // Update timer state
                timerState.emit(TimerState(secondsRemaining.toInt(), true))
                delay(1000) // Delay for 1 second
            }

            // Timer finished
            timerState.emit(TimerState(0, false))
        }
    }

    data class TimerState(val secondsRemaining: Int, val isRunning: Boolean)
}

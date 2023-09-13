package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.membersgramtest.R
import com.example.membersgramtest.ui.layout.SuccessfulBottomsheetlayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SuccessfultransferBottomsheet : BottomSheetDialogFragment() {
    lateinit var successfulBottomsheetlayout: SuccessfulBottomsheetlayout
    // Declare the navArgs property
    private val args: SuccessfultransferBottomsheetArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize successfulBottomsheetlayout here
        successfulBottomsheetlayout = SuccessfulBottomsheetlayout(requireContext())
        return successfulBottomsheetlayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Now you can safely access successfulBottomsheetlayout
        successfulBottomsheetlayout.button.setOnClickListener {
            // Your button click logic here

            // Dismiss the bottom sheet when the button is clicked
            dismiss()
        }

        // Retrieve the phoneNumber and coin arguments
        val phoneNumber = args.phoneNumber
        val coin = args.coin
        Log.d("botom","$phoneNumber$coin")

        // Use phoneNumber and coin as needed
        successfulBottomsheetlayout.textview2.text = "$coin coins transfer to $phoneNumber"
    }


}


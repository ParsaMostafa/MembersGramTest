package com.example.membersgramtest.ui.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.membersgramtest.R
import com.google.android.material.appbar.MaterialToolbar

class PaymentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)

        // Set a click listener for the navigation icon (back button)
        toolbar.setNavigationOnClickListener {
            // Navigate back to the previous fragment using FragmentManager
            requireActivity().supportFragmentManager.popBackStack()
        }
    }


}




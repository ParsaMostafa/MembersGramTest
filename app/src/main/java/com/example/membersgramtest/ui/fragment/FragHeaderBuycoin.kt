package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.membersgramtest.ui.layout.ItemHeaderBuyCoin

class FragHeaderBuycoin : Fragment(){



    lateinit var itemHeaderBuyCoin: ItemHeaderBuyCoin

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        itemHeaderBuyCoin= ItemHeaderBuyCoin(requireContext())
        return itemHeaderBuyCoin
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)











    }



}





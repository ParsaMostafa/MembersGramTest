package com.example.membersgramtest.ui.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.ui.layout.FragMenberslayout
import com.example.membersgramtest.ui.layout.ItemHeaderBuyCoin
import com.example.membersgramtest.utillity.CryptUtil
import org.json.JSONObject

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





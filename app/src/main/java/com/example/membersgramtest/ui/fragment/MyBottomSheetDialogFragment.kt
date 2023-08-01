package com.example.membersgramtest.ui.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.membersgramtest.MyApp
import com.example.membersgramtest.ui.layout.bottom_sheet_layout
import com.example.membersgramtest.utillity.CryptUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.json.JSONObject


class MyBottomSheetDialogFragment: BottomSheetDialogFragment() {
    lateinit var bottomSheetLayout: bottom_sheet_layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bottomSheetLayout = bottom_sheet_layout(requireContext())
        return  bottomSheetLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheetLayout.button.setOnClickListener {
            Log.d("MyBottomSheetDialog", "Button clicked")
            orderMemberWithProvidedData("https://api.membersgram.com/api/v2/zarinpal/member/gateway?data=", MyApp.appContext)
        }
    }

    fun orderMemberWithProvidedData(baseUrl: String, context: Context) {
        val versionCode = 30180
        val packageName = "com.example.membersgramtest"

        val jsonData = mapOf(
            "phonenumber" to "989373449122",
            "sku" to "z_member_01_m",
            "price" to 5000,
            "username" to "StopElon_BSC",
            "tgChannelId" to 1352448969,
            "title" to "STOPELON20OFFICIAL",
            "tgPicDc_Id" to 5,
            "tgPicVolume_Id" to 500047400704,
            "tgPicLocal_Id" to 381959,
            "tgPicSecret" to 7630722832590455152,
            "tgAccessHash" to -4777718574595129344,
            "market" to "zarinpal",
            "lan" to "EN",
            "versionc" to versionCode.toString(),
            "packageName" to packageName
        )

        val encryptedData = CryptUtil.encrypt(JSONObject(jsonData).toString())
        Log.d("MyBottomSheetDialog", "Opening URL: $baseUrl$encryptedData")
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("$baseUrl$encryptedData")
        startActivity(intent)
    }
}

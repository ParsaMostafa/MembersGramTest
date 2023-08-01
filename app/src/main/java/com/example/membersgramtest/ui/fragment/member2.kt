package com.example.membersgramtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.membersgramtest.ui.layout.FragMenberslayout
import com.example.membersgramtest.ui.layout.ItemMemberinorder2

class member2 :  Fragment() {

    lateinit var itemMemberinorder2: ItemMemberinorder2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        itemMemberinorder2 = ItemMemberinorder2(requireContext())
        return itemMemberinorder2
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        itemMemberinorder2.whtitebuttun.setOnClickListener {
            val bottomSheetFragment = MyBottomSheetDialogFragment()
            bottomSheetFragment.show((context as AppCompatActivity).supportFragmentManager, bottomSheetFragment.tag)
        }

    }
}


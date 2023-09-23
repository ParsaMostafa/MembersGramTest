package com.example.membersgramtest.models.MyMemberModel

import android.widget.ImageView

sealed class MyMemberModel {

    data  class MyMemberHeaderModel(val accountImage : Int , val title: String , val number : String?) : MyMemberModel()


    data class MyMemberBodyModel(val icon1: Int, val title1: String, val icon2: Int, val title2: String, val icon3: Int, val title3: String, val icon4: Int, val title4: String) : MyMemberModel()


    object MyMemberFooterModel :  MyMemberModel()
}

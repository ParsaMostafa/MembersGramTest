package com.example.membersgramtest.models.MyMemberModel

import android.widget.ImageView

sealed class MyMemberModel {

    data  class MyMemberHeaderModel(val accountImage : Int , val title: String , val number : String?) : MyMemberModel()


    data class MyMemberBodyModel(val icon: Int, val title: String , var showdivider:Boolean ) : MyMemberModel()


    object MyMemberFooterModel :  MyMemberModel()

}

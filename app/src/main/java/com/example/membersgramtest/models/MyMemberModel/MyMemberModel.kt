package com.example.membersgramtest.models.MyMemberModel

import android.widget.ImageView

sealed class MyMemberModel {

    data  class MyMemberHeaderModel(val accountImage : ImageView , val title: String , val number : String) : MyMemberModel()


    data  class MyMemberBodyModel(val icon : ImageView , val icontitle: String ) : MyMemberModel()

    object MyMemberFooterModel :  MyMemberModel()
}

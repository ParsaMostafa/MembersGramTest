package com.example.membersgramtest.models.memberview

sealed class Rv1Model {


    data class Rv1BodyModel (
        val count_post: Int
            ):Rv1Model()

}

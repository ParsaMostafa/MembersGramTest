package com.example.membersgramtest.api

import com.example.membersgramtest.models.member.ApiResponse
import com.example.membersgramtest.models.member.GetMemberBundlesResponse
import com.example.membersgramtest.models.memberview.Getview
import com.example.membersgramtest.models.v1.MyRequest
import com.example.membersgramtest.models.v1.MyResponse
import com.example.membersgramtest.models.v2.VerifyRegisterRequest
import com.example.membersgramtest.models.v2.VerifyRegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface NewsApi {

    @Headers("lan: EN", "versionc: 30180", "market: zarinpal")
    @POST("/api/v2/register")
    suspend fun register(@Body request: MyRequest): Response<MyResponse>


    @Headers("lan: EN", "versionc: 30180", "market: zarinpal")
    @POST("/api/v2/verifyRegister")
    suspend fun verifyRegister(@Body request: VerifyRegisterRequest): Response<VerifyRegisterResponse>


    @POST("api/v2_2/getmembers")
    suspend fun getMembers(): Response<GetMemberBundlesResponse>


    @POST("api/v2/view/getviews")
    suspend fun getViews(): Response<Getview>

}

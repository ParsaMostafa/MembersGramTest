package com.example.membersgramtest.api

import com.example.membersgramtest.models.Transaction.TransactionResponse
import com.example.membersgramtest.models.ViewTabModel.Getview
import com.example.membersgramtest.models.getcoins.GetCoins
import com.example.membersgramtest.models.memberresponse.MemberResponse
import com.example.membersgramtest.models.transferCoin.ResponseCoin
import com.example.membersgramtest.models.transferCoin.TransferCoinRequest
import com.example.membersgramtest.models.v1.MyRequest
import com.example.membersgramtest.models.v1.MyResponse
import com.example.membersgramtest.models.v2.VerifyRegisterRequest
import com.example.membersgramtest.models.v2.VerifyRegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiCalls {

    @Headers("lan: EN", "versionc: 30180", "market: zarinpal")
    @POST("/api/v2/register")
    suspend fun register(@Body request: MyRequest): Response<MyResponse>


    @Headers("lan: EN", "versionc: 30180", "market: zarinpal")
    @POST("/api/v2/verifyRegister")
    suspend fun verifyRegister(@Body request: VerifyRegisterRequest): Response<VerifyRegisterResponse>


    @POST("api/v2_2/getmembers")
    suspend fun getMembers(): Response<MemberResponse>


    @POST("api/v2/view/getviews")
    suspend fun getViews(): Response<Getview>


    @POST("api/v2/getcoins")
    suspend fun getCoins() : Response<GetCoins>


    @POST("api/v2/sendcoin")
    suspend fun transferCoin(@Body request: TransferCoinRequest): Response<ResponseCoin>




    @POST("api/v2_1/getUserTransActions")
    suspend fun UserTransActions(
        @Query("page") pageNumber: Int,
        @Query("filter") status: String
    ): Response<TransactionResponse>





}

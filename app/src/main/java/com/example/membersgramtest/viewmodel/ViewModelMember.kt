package com.example.membersgramtest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersgramtest.R
import com.example.membersgramtest.api.RetrofitInstance
import com.example.membersgramtest.models.ViewTabModel.Rv2model
import com.example.membersgramtest.models.memberresponse.MemberResponse
import com.example.membersgramtest.models.memberresponse.RV1Member
import com.example.membersgramtest.models.memberresponse.RV2MEMBER
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelMember : ViewModel() {
    val Apicalls = RetrofitInstance.api

    val _RV1memberobjects = MutableStateFlow<List<RV1Member>>(emptyList())
    val RV1memberobjects: StateFlow<List<RV1Member>> = _RV1memberobjects


    private val _RV2memberobjects = MutableStateFlow<List<RV2MEMBER>>(emptyList())
    val RV2memberobjects: StateFlow<List<RV2MEMBER>> = _RV2memberobjects

    private val defaultCountrycode = null
    init {
        getCountryies()
        fetchCountryDetails(defaultCountrycode)

    }


    private fun getCountryies() {
        viewModelScope.launch {
            try {
                Log.d("ViewModelMember", "Fetching members...")
                val responseMember = Apicalls.getMembers()
                Log.d("ViewModelMember", "$responseMember")
                if (responseMember.isSuccessful) {
                    Log.d("ViewMem", "${responseMember.body()}")
                    RV1response(responseMember.body())
                } else {
                    Log.e("ViewMeror", "API call failed with code: ${responseMember.code()}")
                }
            } catch (e: Exception) {
                Log.e("ViewModelMember", "Exception: ${e.message}")
            }
        }
    }

    private fun RV1response(body: MemberResponse?) {
        val Rv1Items = mutableListOf<RV1Member>()
        body?.data?.data?.forEach {
            val countryCode = it.buyCountries.countryCode
            Log.d("1LogTag", "Size of Posts: $countryCode")
            val flag = it.buyCountries.flag
            Log.d("1LogTag", "Size of Posts: $flag")
            val name = it.buyCountries.name
            val flagemoji = it.buyCountries.flagEmoji
            val namefa = it.buyCountries.nameFa
            val nameen = it.buyCountries.nameEn
            val countrycode = it.buyCountries.countryCode

            Rv1Items.add(
                RV1Member.RV1Model(
                    flag = it.buyCountries.flag,
                    name = it.buyCountries.name,
                    flagEmoji = it.buyCountries.flagEmoji,
                    nameFa = it.buyCountries.nameFa,
                    nameEn = it.buyCountries.nameEn,
                    countryCode = it.buyCountries.countryCode
                )
            )
        }
        _RV1memberobjects.value = Rv1Items
        Log.d("ViewModelMember", "RV1response processed")
    }

    // RecyclerView2 Functions


    fun fetchCountryDetails(countryCode: String?) {
        viewModelScope.launch {
            val response = Apicalls.getMembers()
            Log.d("rrr", "Filtering data for countryCode: ${response.body()}")
            if (response.isSuccessful) {
                rv2Response(response.body(), countryCode)
                Log.d("rrr", "Filtering data for countryCode: $countryCode")
            } else {
                Log.e("ResponseError", "Error: ${response.code()}")
            }

        }
    }

    private fun rv2Response(body: MemberResponse?, countryCode: String?) {
        val rv2ModelItems = mutableListOf<RV2MEMBER>()

        // Add the header
        rv2ModelItems.add(RV2MEMBER.Rv2HeaderModel("Get Member"))

        body?.data?.data?.filter { it.buyCountries.countryCode == countryCode }?.forEach { dataX ->
            Log.d("rv2member", "Filtering data for countryCode: $dataX")

            dataX.purchase_getmember.forEach {
                Log.d("rvpur2", "Processing coin: ${it.price}")

                // Create an instance of RV2MEMBER.Rv2BodyModel
                rv2ModelItems.add( RV2MEMBER.Rv2BodyModel(
                    ABtest = it?.ABtest,
                    Id = it?.Id,
                    __v = it?.__v,
                    _id = it?._id,
                    animationMode = it?.animationMode,
                    buyCountries = it?.buyCountries,
                    by_coin = it.by_coin,
                    coin = it?.coin,
                    country = it.country,
                    daily = it.daily,
                    darsad = it?.darsad,
                    dayCount = it?.dayCount,
                    discount = it.discount,
                    discountString = it?.discountString,
                    discount_member_count = it?.discount_member_count,
                    hidden = it.hidden,
                    id = it?.id,
                    image = it?.image,
                    is_active = it.is_active,
                    market = it?.market,
                    memberTypeNumber = it?.memberTypeNumber,
                    member_count = it?.member_count,
                    member_count_real = it?.member_count_real,
                    onvan = it?.onvan,
                    price = it.price,
                    shop_type = it?.shop_type,
                    sku = it?.sku,
                    sortCountry = it?.sortCountry,
                    type = it?.type,
                    world = it.world
                )
                )
            }



            rv2ModelItems.add(RV2MEMBER.Rv2HeaderModel("Get Member by coins"))

            dataX.coin_getmember.forEach {
                Log.d("rvcoin2", "Processing coin: ${it.coin}")

                // Create an instance of RV2MEMBER.Rv2BodyModel
                rv2ModelItems.add( RV2MEMBER.Rv2BodyModel(
                    ABtest = it?.ABtest,
                    Id = it?.Id,
                    __v = it?.__v,
                    _id = it?._id,
                    animationMode = it?.animationMode,
                    buyCountries = it?.buyCountries,
                    by_coin = it.by_coin,
                    coin = it.coin,
                    country = it.country,
                    daily = it.daily,
                    darsad = it?.darsad,
                    dayCount = it?.dayCount,
                    discount = it.discount,
                    discountString = it?.discountString,
                    discount_member_count = it?.discount_member_count,
                    hidden = it.hidden,
                    id = it?.id,
                    image = it?.image,
                    is_active = it.is_active,
                    market = it?.market,
                    memberTypeNumber = it?.memberTypeNumber,
                    member_count = it?.member_count,
                    member_count_real = it?.member_count_real,
                    onvan = it?.onvan,
                    price = it.price,
                    shop_type = it?.shop_type,
                    sku = it?.sku,
                    sortCountry = it?.sortCountry,
                    type = it?.type,
                    world = it.world

                )
                )
            }
            rv2ModelItems.add(RV2MEMBER.FooterModel)

            _RV2memberobjects.value =  rv2ModelItems
    }
        }
    }






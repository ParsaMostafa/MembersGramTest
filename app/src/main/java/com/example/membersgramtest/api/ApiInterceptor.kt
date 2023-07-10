package com.example.membersgramtest.api

import android.content.SharedPreferences
import android.util.Log
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import com.example.membersgramtest.utillity.CryptUtil
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import org.json.JSONObject


class ApiInterceptor() : Interceptor {
    private lateinit var sharedPreferences: SharedPreferences

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        val apiToken = PreferencesHelper.apiToken


        if (apiToken != null) {
            requestBuilder.addHeader(
                "apitoken",
                apiToken
            )
        }
        requestBuilder.addHeader(
            "market",
            "zarinpal"
        )
        requestBuilder.addHeader(
            "lan",
            "EN"
        )
        requestBuilder.addHeader(
            "versionc",
            "31096"
        )
        requestBuilder.addHeader(
            "versionName",
            "9.4.6"
        )
        requestBuilder.addHeader(
            "packageName",
           "gram.members.android"
        )
        var request = requestBuilder.build()
        val methodName = request.url().toString().substringAfterLast('/')
        val requestURL = request.url().toString()
        Log.d("tagXX", requestURL)
        val oldBody = request.body()
        val buffer = Buffer().apply {
            oldBody?.writeTo(this)
        }
        val strOldBody = buffer.readUtf8().let {
            if (it.isEmpty()) {
                "\"data : {}\""
            } else {
                it
            }
        }
        Log.d("tagXX", strOldBody)
        val mediaType = MediaType.parse("application/json; charset=utf-8")
        val encryptedBody = try {
            CryptUtil.encrypt(strOldBody)
        } catch (ex: Exception) {
            ""
        }
        val strNewBody = "{\"data\":\"$encryptedBody\"}"
        Log.d("tagXX", strNewBody)
        val body = RequestBody.create(mediaType, strNewBody)
        request = request
            .newBuilder()
            .header(
                "Content-Type",
                body.contentType().toString()
            )
            .header(
                "Content-Length",
                body.contentLength().toString()
            )
            .method(
                request.method(),
                body
            ).build()
        var response = chain.proceed(request)
        var responseString = response.body()?.string() ?: ""
        Log.d("tagXX", responseString)
        var decrypted = false
        try {
            responseString = CryptUtil.decrypt(responseString)
            Log.d("tagXX", responseString)
            decrypted = true
        } catch (ex: Exception) {

        }
        if (response.isSuccessful && decrypted) {
            val newResponse = response.newBuilder()
            var contentType = response.header("Content-Type")
            if (contentType.isNullOrEmpty()) {
                contentType = "application/json"
            }
            newResponse.body(
                ResponseBody.create(
                    MediaType.parse(contentType),
                    responseString
                )
            )
            response = newResponse.build()
        }
        val responseJson = try {
            JSONObject(responseString)
        } catch (ex: Exception) {
            null
        }
        return response
    }

}
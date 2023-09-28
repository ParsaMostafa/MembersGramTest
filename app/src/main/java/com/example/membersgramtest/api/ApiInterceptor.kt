package com.example.membersgramtest.api

import android.util.Log
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import com.example.membersgramtest.utillity.CryptUtil
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer

class ApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        val apiToken = PreferencesHelper.apiToken
        Log.d("API T", "token is : $apiToken")

        if (apiToken != null) {

            requestBuilder.addHeader("apitoken", apiToken)
        }

        requestBuilder.addHeader("market", "zarinpal")
        requestBuilder.addHeader("lan", "EN")
        requestBuilder.addHeader("versionc", "31096")
        requestBuilder.addHeader("versionName", "9.4.6")
        requestBuilder.addHeader("packageName", "gram.members.android")


        var request = requestBuilder.build()
        // Log all the headers
        for (name in request.headers().names()) {
            Log.d("APIInterceptor", "Header: $name = ${request.header(name)}")
        }

        val oldBody = request.body()
        val buffer = Buffer().apply { oldBody?.writeTo(this) }
        val strOldBody = buffer.readUtf8().let { if (it.isEmpty()) "\"data : {}\"" else it }

        val mediaType = MediaType.parse("application/json; charset=utf-8")
        val encryptedBody = try {
            CryptUtil.encrypt(strOldBody)
        } catch (ex: Exception) {
            ""
        }
        val strNewBody = "{\"data\":\"$encryptedBody\"}"
        val body = RequestBody.create(mediaType, strNewBody)

        request = request.newBuilder()
            .header("Content-Type", body.contentType().toString())
            .header("Content-Length", body.contentLength().toString())
            .method(request.method(), body)
            .build()

        var response = chain.proceed(request)
        val responseBody = response.peekBody(Long.MAX_VALUE)
        var responseString = responseBody.string()


        var decrypted = false
        try {
            responseString = CryptUtil.decrypt(responseString)
            decrypted = true
        } catch (ex: Exception) {
            // handle the exception here
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

        return response

    }
}

package com.example.membersgramtest.sharedPerf

import android.content.Context
import android.content.SharedPreferences
import com.example.membersgramtest.MyApp

object PreferencesHelper {
    private const val PREFERENCES_NAME = "Mypref"
    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private val PRIVATE_MODE = 0

    init {
        preferences = MyApp.appContext.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE )
        editor = preferences.edit()
    }

    var phoneNumber: String?
        get() = preferences.getString("phoneNumber", null)
        set(value) {
            editor.putString("phoneNumber", value).apply()
        }

    var apiToken: String?
        get() = preferences.getString("apiToken", null)
        set(value) {
            editor.putString("apiToken", value).apply()
        }

}

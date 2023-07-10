package com.example.membersgramtest

import android.app.Application
import android.content.Context
import com.example.membersgramtest.sharedPerf.PreferencesHelper

class MyApp : Application() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this // this is the Application context
        // other initializations...
    }
}

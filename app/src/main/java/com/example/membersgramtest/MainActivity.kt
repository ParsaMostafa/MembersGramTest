package com.example.membersgramtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainActivityLayout = MainActivityLayout(this)
        setContentView(mainActivityLayout)
    }

}
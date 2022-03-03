package com.example.flavordemo.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flavordemo.BuildConfig
import com.example.flavordemo.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callService("URL Implementation TO:DO")
    }

    fun callService(url: String) {
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show()
    }
}





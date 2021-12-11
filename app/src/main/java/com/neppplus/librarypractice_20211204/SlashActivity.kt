package com.neppplus.librarypractice_20211204

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SlashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash)
        setupEvents()
        setValues()
    }

    fun setupEvents(){

    }

    fun setValues(){

        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed( {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
            finish()
        }, 2000 )
    }
}
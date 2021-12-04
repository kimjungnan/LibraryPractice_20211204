package com.neppplus.librarypractice_20211204

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents(){

//        전화연결 시 권한 획득

        btnCall.setOnClickListener {
            val myUri = Uri.parse("tel : 010-6290-1236")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)

        }

        imgProfile.setOnClickListener {

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }
    }

    fun setValues(){


    }
}
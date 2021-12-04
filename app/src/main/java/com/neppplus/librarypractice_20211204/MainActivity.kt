package com.neppplus.librarypractice_20211204

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

//        전화연결 시 권한 획득

        val pl = object : PermissionListener {
            override fun onPermissionGranted() {
//                권한 최종 승인

                Toast.makeText(applicationContext, "전화연결", Toast.LENGTH_SHORT).show()

                // TODO("Not yet implemented")
                btnCall.setOnClickListener {
                    val myUri = Uri.parse("tel : 010-6290-1236")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                //  TODO("Not yet implemented")
                Toast.makeText(applicationContext, "전화거부", Toast.LENGTH_SHORT).show()
            }


        }

        TedPermission.create()
            .setPermissionListener(pl)
            .setPermissions(Manifest.permission.CALL_PHONE)
            .check()


        imgProfile.setOnClickListener {

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }
    }

    fun setValues(){


    }
}
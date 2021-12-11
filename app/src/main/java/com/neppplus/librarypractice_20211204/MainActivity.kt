package com.neppplus.librarypractice_20211204

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
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
                Toast.makeText(applicationContext, "전화거부2", Toast.LENGTH_SHORT).show()

            }


        }

        TedPermission.create()
            .setPermissionListener(pl)
            .setPermissions(Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA)
            .check()


        imgProfile.setOnClickListener {

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }
    }

    fun setValues(){

//        인터넷상에 있는 이미지를  곧바로 이미지뷰에 적용

//        이미지 주소를 변수에 담아주자
        val imageURL = "https://s3.ap-northeast-2.amazonaws.com/elasticbeanstalk-ap-northeast-2-176213403491/media/magazine_img/magazine_262/%EC%8D%B8%EB%84%A4%EC%9D%BC.jpg"


//        glide이용 > imageURL 주소으 ㅣ기름을 반영

        Glide.with(this).load(imageURL).into(imgInter)


    }
}
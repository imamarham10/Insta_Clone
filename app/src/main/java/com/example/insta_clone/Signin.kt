package com.example.insta_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signin.*

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        buSignUP.setOnClickListener{
            startActivity(Intent(this,Signup::class.java))
        }

    }


}
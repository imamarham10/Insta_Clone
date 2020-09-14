package com.example.insta_clone

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signin.*

class Signin : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        mAuth = FirebaseAuth.getInstance();
        buSignUP.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }
    }
     /*   buSignin.setOnClickListener {
            val email = tlEmail.text.toString()
            val password = tlPassword.text.toString()
            LoginToFirebase(email,password)
        }

    }


    private fun LoginToFirebase(email: String, password: String)
    {
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(applicationContext,"Please enter email!",Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(applicationContext,"Please Enter the password",Toast.LENGTH_LONG).show()
            return
        }
        if(password.length<8)
        {
            Toast.makeText(applicationContext,"Password too short",Toast.LENGTH_LONG).show()
            return
        }
        mAuth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful)
                {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(applicationContext,"Login Successful",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Login Failed or User not available",Toast.LENGTH_LONG).show()
                }
            }

    }*/
     fun buSignIn(view: View)
     {
         val email = tlEmail.text.toString()
         val password = tlPassword.text.toString()
         LoginToFirebase(email, password)

     }

    fun LoginToFirebase(email:String,password:String)
    {
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(applicationContext,"Please enter email!",Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(applicationContext,"Please Enter the password",Toast.LENGTH_LONG).show()
            return
        }
        if(password.length<8)
        {
            Toast.makeText(applicationContext,"Password too short",Toast.LENGTH_LONG).show()
            return
        }
        mAuth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful)
                {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(applicationContext,"Login Successful",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Login Failed or User not available",Toast.LENGTH_LONG).show()
                }
            }

    }




}



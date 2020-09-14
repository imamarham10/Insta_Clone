

package com.example.insta_clone

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*


class Signup : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private var database = FirebaseDatabase.getInstance()
    private var myRef = database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_signup)
        buSignin.setOnClickListener {
            startActivity(Intent(this, Signin::class.java))
        }
        signup.setOnClickListener {
            createAccount()
        }

    }

    private fun createAccount() {
        var Gender:String?=null
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val fullname = etFullName.text.toString()
        if(male.isChecked())
        {
            Gender = "Male"
        }
        if(female.isChecked())
        {
            Gender = "Female"
        }
        if (Gender != null) {
            signupToFirebase(email, password,fullname,Gender)
        }
    }

    private fun signupToFirebase(email: String, password: String, fullname : String, gender: String)
    {
        if (TextUtils.isEmpty(fullname))
        {
            Toast.makeText(applicationContext,"please enter your name",Toast.LENGTH_LONG).show()
            return
        }
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(
                applicationContext,
            "Please Enter Email",
            Toast.LENGTH_LONG
            ).show()
            return
    }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(applicationContext,"Please Enter Password",Toast.LENGTH_LONG).show()
            return
        }
        if(password.length <8)
        {
            Toast.makeText(applicationContext,"Password too short",Toast.LENGTH_LONG).show()
            return
        }
        mAuth!!.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful)
                {
                   // var progressbar = ProgressBar(this.findViewById(R.id.progressbar))
                    var currentuser = mAuth!!.currentUser
                    Toast.makeText(applicationContext,"Account Created",Toast.LENGTH_LONG).show()
                    //save in database
                    var information = UserInfo(fullname,email,password,gender)
                    myRef.child("Users").child(currentuser!!.uid).setValue(information)


                    LoadMain()
                }
                else
                {
                    Toast.makeText(applicationContext,"Authentication Failed",Toast.LENGTH_LONG).show()

                }

                // ...
            }
    }

    private fun LoadMain()
    {
        var currentUser = mAuth!!.currentUser
        if(currentUser!=null)
        {
            var intent = Intent(this,Signin::class.java)
            startActivity(intent)
            finish()

        }
    }


}
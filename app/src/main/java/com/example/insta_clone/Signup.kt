

package com.example.insta_clone

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_account_settings.*
import kotlinx.android.synthetic.main.activity_signup.*



class Signup : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_signup)
        buSignin.setOnClickListener {
            startActivity(Intent(this, Signin::class.java))
        }

       buRegister.setOnClickListener {
           createAccount()
       }
    }

    private fun createAccount() {
        val fullName = Fullname_signup.editText.toString()
        val email = Email_SignUp.editText.toString()
        val username = Username_Edit_Text.editText.toString()
        val password = Password_signup.editText.toString()
        when {
            TextUtils.isEmpty(fullName) -> {
                Toast.makeText(this, "Full Name is required", Toast.LENGTH_LONG).show()
            }
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this, "Email is required", Toast.LENGTH_LONG).show()
            }
            TextUtils.isEmpty(username) -> {
                Toast.makeText(this, "Username is required", Toast.LENGTH_LONG).show()
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this, "Password is required", Toast.LENGTH_LONG).show()
            }

            else ->
            {
                /*val progessDialog = ProgressBar(this)
                progessDialog.
                progessDialog.setMessage("Please wait, this may take a while.")
                progessDialog.setCanceledOnTouchOutside(false)
                progessDialog.show()*/
                mAuth!!.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                        this
                    ) { task ->
                        if (task.isSuccessful) {
                            saveUserInfo(fullName,username,email)
                        } else {
                           val message = task.exception.toString()
                            Toast.makeText(this, "Error: $message",Toast.LENGTH_LONG).show()
                            mAuth!!.signOut()
                            //progessDialog.dismiss()
                        }

                        // ...
                    }

            }
        }
    }

    private fun saveUserInfo(fullName: String, username: String, email: String)
    {
        val currentUserID = FirebaseAuth.getInstance().currentUser!!.uid
        val usersRef : DatabaseReference = FirebaseDatabase.getInstance().reference.child("Users")
        val userMap = HashMap<String,Any>()
        userMap["uid"] = currentUserID
        userMap["fullName"] = currentUserID
        userMap["username"] = currentUserID
        userMap["email"] = currentUserID
        userMap["bio"] = "hey,I am Arham, developer of this ig clone."
        userMap["image"] = "https://firebasestorage.googleapis.com/v0/b/instagram-concept.appspot.com/o/Default%20Images%2Fprofile.png?alt=media&token=d0e20016-a4cc-4c50-a94c-b4981a72d412"
        usersRef.child(currentUserID).setValue(userMap)
            .addOnCompleteListener { task->
                if (task.isSuccessful)
                {
                   // progessDialog.dismiss()
                    Toast.makeText(this,"Account has been created successfully",Toast.LENGTH_LONG).show()

                    val intent = Intent(this,MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                }
                else
                {
                     val message = task.exception.toString()
                     Toast.makeText(this,"Error $message",Toast.LENGTH_LONG)
                    FirebaseAuth.getInstance().signOut()
                   // progessDialog.dismiss()
                }
            }

    }
}


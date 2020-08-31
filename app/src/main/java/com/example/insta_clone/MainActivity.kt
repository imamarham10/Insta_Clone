package com.example.insta_clone

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.insta_clone.R.id.message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    private lateinit var textmessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            item ->
        when (item.itemId) {
            R.id.nav_home -> {
                textmessage.text = "HOME"
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                textmessage.text = "SEARCH"
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_Addpost -> {
                textmessage.text = "ADD POST"
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notifications -> {
                textmessage.text = "NOTIFICATIONS"
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                textmessage.text = "PROFILE"
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var navView: BottomNavigationView = findViewById(R.id.nav_view)
        textmessage = findViewById(R.id.textmessage)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

}
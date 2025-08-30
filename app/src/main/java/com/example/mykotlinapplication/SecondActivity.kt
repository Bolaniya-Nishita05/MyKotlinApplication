package com.example.mykotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txtWelcome = findViewById<TextView>(R.id.txtWelcome)
        val username = intent.getStringExtra("username")
        txtWelcome.text = "Welcome, $username!"
    }
}

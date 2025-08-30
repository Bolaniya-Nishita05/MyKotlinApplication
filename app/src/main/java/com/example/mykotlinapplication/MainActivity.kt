package com.example.mykotlinapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtName = findViewById<EditText>(R.id.edtName)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnFragment = findViewById<Button>(R.id.btnFragment)
        val btnAlert = findViewById<Button>(R.id.btnAlert)
        val btnDate = findViewById<Button>(R.id.btnDate)
        val btnTime = findViewById<Button>(R.id.btnTime)

        // Explicit Intent Example
        btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("username", edtName.text.toString())
            startActivity(intent)
        }

        // Load Fragment Example
        btnFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, DemoFragment())
                .commit()
        }

        // AlertDialog Example
        btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Hello!")
                .setMessage("This is an AlertDialog demo.")
                .setPositiveButton("OK", null)
                .show()
        }

        // Date Picker Dialog Example
        btnDate.setOnClickListener {
            val datePicker = DatePickerDialog(this, { _, year, month, day ->
                Toast.makeText(this, "Date: $day/${month+1}/$year", Toast.LENGTH_SHORT).show()
            }, 2025, 7, 30)
            datePicker.show()
        }

        // Time Picker Dialog Example
        btnTime.setOnClickListener {
            val timePicker = TimePickerDialog(this, { _, hour, minute ->
                Toast.makeText(this, "Time: $hour:$minute", Toast.LENGTH_SHORT).show()
            }, 12, 0, true)
            timePicker.show()
        }
    }
}

package com.example.homework3_application1

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        val inputView = findViewById<TextView>(R.id.inputView)
        val restButton = findViewById<ImageButton>(R.id.restButton)
        val countButton = findViewById<ImageButton>(R.id.countButton)
        restButton.setOnClickListener {
            count = 0
            inputView.text = count.toString()
        }
        countButton.setOnClickListener {
            count += 1
            inputView.text = count.toString()
        }
    }
}
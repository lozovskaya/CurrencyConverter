package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var et : TextView = findViewById(R.id.textView);
        et.setText("hooray");
        editTextNumberSigned.text;
        button.setOnClickListener() {
            var value = editTextNumberSigned.text.toString().toDouble();
            et.setText("${value / 74}")
        }
    }
}

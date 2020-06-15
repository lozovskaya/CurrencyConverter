package com.example.currencyconverter

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


var money : MutableMap<String, Float> = mutableMapOf("CAD" to 1.5347F,
    "HKD" to 8.7607F,
    "ISK" to 152.1F,
    "PHP" to 56.763F,
    "DKK" to 7.4551F,
    "HUF" to 346.0F,
    "CZK" to 26.698F,
    "AUD" to 1.6447F,
    "RON" to 4.8343F,
    "SEK" to 10.5103F,
    "IDR" to 16058.24F,
    "INR" to 85.7875F,
    "BRL" to 5.7388F,
    "RUB" to 78.7662F,
    "HRK" to 7.566F,
    "JPY" to 121.26F,
    "THB" to 34.986F,
    "CHF" to 1.0697F,
    "SGD" to 1.5718F,
    "PLN" to 4.4484F,
    "BGN" to 1.9558F,
    "TRY" to 7.7224F,
    "CNY" to 7.999F,
    "NOK" to 10.8475F,
    "NZD" to 1.7553F,
    "ZAR" to 19.2794F,
    "USD" to 1.1304F,
    "MXN" to 25.445F,
    "ILS" to 3.9189F,
    "GBP" to 0.89653F,
    "KRW" to 1360.45F,
    "MYR" to 4.824F,
    "EUR" to 1F);


fun convert(curr1: String, value: Float, curr2 : String) : Float {
    var answer : Float = value;
    for (key in money.keys) {
        if (key == curr1) {
            answer /= money[key]?.toFloat()!!
            break
        }
    }
    for (key in money.keys) {
        if (key == curr2) {
            answer *= (money[key]?.toFloat())!!
            break
        }
    }
    return answer
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://api.exchangeratesapi.io/latest"


        val spinner1: Spinner = findViewById(R.id.spinner1)
        ArrayAdapter.createFromResource(
            this,
            R.array.currency,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter
        }
        val spinner2: Spinner = findViewById(R.id.spinner2)
        ArrayAdapter.createFromResource(
            this,
            R.array.currency,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter
        }


        var et : TextView = findViewById(R.id.textView);
        button.setOnClickListener() {
            if (editTextNumberSigned.text.toString() != "") {
                val value : Float = editTextNumberSigned.text.toString().toFloat();
                val curr1 : String = spinner1.getSelectedItem().toString()
                val curr2 : String = spinner2.getSelectedItem().toString()
                et.setText("The result: ${convert(curr1, value, curr2)}")
            }
        }
    }
}

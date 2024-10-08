package com.example.lab33

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val infoType = intent.getStringExtra("info_type") ?: "default"
        val textView = findViewById<TextView>(R.id.textViewInfo)

        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            finish()
        }

        Log.d("SecondActivity", "infoType: $infoType")

        when (infoType) {
            "author" -> textView.text = "Дзендзелівська Анастасія Михайлівна"
            "faculty" -> textView.text = "Я навчаюсь на факультеті інформаційних технологій"
            "city" -> textView.text = "Я проживаю в місті Овруч"
            else -> textView.text = "Інформація відсутня"
        }
    }
}
package com.example.lab33

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val authorButton: Button = findViewById(R.id.authorButton)
        val facultyButton: Button = findViewById(R.id.facultyButton)
        val cityButton: Button = findViewById(R.id.cityButton)

        authorButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("info_type", "author")
            startActivity(intent)
        }

        facultyButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("info_type", "faculty")
            startActivity(intent)
        }

        cityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("info_type", "city")
            startActivity(intent)
        }
    }
}


package com.example.lab21

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val infoTextView = findViewById<TextView>(R.id.textViewInfo)

        // Получаем данные с проверкой на null
        val user = intent.getStringExtra("username") ?: "Георгий"
        val gift = intent.getStringExtra("gift") ?: "Курсовую"
        val sender = intent.getStringExtra("sender") ?: "Неизвестный"

        infoTextView.text = "$sender передал(а) $user: $gift"
    }
}
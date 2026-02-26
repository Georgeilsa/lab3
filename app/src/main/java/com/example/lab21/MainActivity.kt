package com.example.lab21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEditText = findViewById<EditText>(R.id.editTextUser)
        val giftEditText = findViewById<EditText>(R.id.editTextGift)
        val senderEditText =findViewById<EditText>(R.id.editTextSender)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        buttonSend.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)

            // Передаём данные с ключами
            intent.putExtra("username", userEditText.text.toString())
            intent.putExtra("gift", giftEditText.text.toString())
            intent.putExtra("sender", senderEditText.text.toString())

            startActivity(intent)
        }
    }
}


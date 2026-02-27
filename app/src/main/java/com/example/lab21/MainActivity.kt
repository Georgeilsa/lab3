package com.example.lab21

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: ConstraintLayout
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.root_layout)
        infoTextView = findViewById(R.id.textView)


        val redButton = findViewById<Button>(R.id.red_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val aboutButton = findViewById<Button>(R.id.button_about)


        redButton.setOnClickListener(buttonClickListener)
        yellowButton.setOnClickListener(buttonClickListener)
        greenButton.setOnClickListener(buttonClickListener)


        aboutButton.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }


    private val buttonClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.red_button -> {
                infoTextView.text = getString(R.string.red)
                rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.redColor))
            }
            R.id.yellow_button -> {
                infoTextView.text = getString(R.string.yellow)
                rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.yellowColor))
            }
            R.id.green_button -> {
                infoTextView.text = getString(R.string.green)
                rootLayout.setBackgroundColor(Color.GREEN)
            }
        }
    }
}
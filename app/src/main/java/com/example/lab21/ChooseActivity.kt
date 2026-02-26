package com.example.lab21

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ChooseActivity : AppCompatActivity() {

    companion object {
        // Ключ для передачи данных - правильный формат с .THIEF
        const val THIEF = "com.example.lab21.THIEF"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
    }

    // Обработчик выбора переключателя
    fun onRadioClick(v: View) {
        // Создаем Intent для возврата результата
        val answerIntent = Intent()

        // Определяем, какой переключатель был выбран
        when (v.id) {
            R.id.radioDog -> answerIntent.putExtra(THIEF, "Собака")
            R.id.radioCrow -> answerIntent.putExtra(THIEF, "Ворона")
            R.id.radioCow -> answerIntent.putExtra(THIEF, "Корова")
            else -> return
        }

        // Устанавливаем результат и закрываем активность
        setResult(RESULT_OK, answerIntent)
        finish()
    }
}
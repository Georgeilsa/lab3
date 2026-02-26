package com.example.lab21

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView  // Этого импорта не хватало!
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Код запроса для идентификации второй активности
    companion object {
        private const val CHOOSE_THIEF = 0
    }

    private lateinit var infoTextView: TextView
    private lateinit var chooseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация элементов интерфейса
        infoTextView = findViewById(R.id.textViewInfo)
        chooseButton = findViewById(R.id.buttonChoose)
    }

    // Обработчик нажатия на кнопку
    fun onClick(v: View) {
        // Создаем намерение для запуска второй активности
        val questionIntent = Intent(this, ChooseActivity::class.java)
        // Запускаем активность с ожиданием результата
        startActivityForResult(questionIntent, CHOOSE_THIEF)
    }

    // Обработчик получения результата от второй активности
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Проверяем, что результат пришел именно от нашей второй активности
        if (requestCode == CHOOSE_THIEF) {
            if (resultCode == RESULT_OK) {
                // Получаем данные из Intent
                val thiefName = data?.getStringExtra(ChooseActivity.THIEF)
                // Отображаем полученное имя
                infoTextView.text = thiefName
            } else {
                // Если пользователь нажал Back, стираем текст
                infoTextView.text = ""
            }
        }
    }
}
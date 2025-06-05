package com.nafi.mathappgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class About_us : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about_us)
        val texthome = findViewById<ImageView>(R.id.btnHome)
        texthome.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val textQuiz = findViewById<ImageView>(R.id.btnQuiz)
        textQuiz.setOnClickListener{
            val intent = Intent(this, daftar_soal::class.java)
            startActivity(intent)
        }
    }
}
package com.nafi.mathappgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Quiz : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        val texthome = findViewById<ImageView>(R.id.btnHome)
        texthome.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val texthelp = findViewById<ImageView>(R.id.BtnAbout)
        texthelp.setOnClickListener{
            val intent = Intent(this, About_us::class.java)
            startActivity(intent)
        }
        val texteasy = findViewById<RelativeLayout>(R.id.btnEasy)
        texteasy.setOnClickListener{
            val intent = Intent(this, easy::class.java)
            startActivity(intent)
        }
        val textmdm = findViewById<RelativeLayout>(R.id.btnMedium)
        textmdm.setOnClickListener{
            val intent = Intent(this, medium::class.java)
            startActivity(intent)
        }
        val texthrd = findViewById<RelativeLayout>(R.id.btnHard)
        texthrd.setOnClickListener{
            val intent = Intent(this, hard::class.java)
            startActivity(intent)
        }
    }
}
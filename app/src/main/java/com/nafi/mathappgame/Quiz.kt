package com.nafi.mathappgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Quiz : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
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
        val texteasy = findViewById<ImageView>(R.id.btnEasy)
        texteasy.setOnClickListener{
            val intent = Intent(this, FinalEasy::class.java)
            startActivity(intent)
        }
        val textmdm = findViewById<ImageView>(R.id.btnMedium)
        textmdm.setOnClickListener{
            val intent = Intent(this, FinalNormal::class.java)
            startActivity(intent)
        }
        val texthrd = findViewById<ImageView>(R.id.btnHard)
        texthrd.setOnClickListener{
            val intent = Intent(this, FinalHard::class.java)
            startActivity(intent)
        }
    }
}
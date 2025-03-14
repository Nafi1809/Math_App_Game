package com.nafi.mathappgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val textWishlist = findViewById<RelativeLayout>(R.id.btnPlay)
        textWishlist.setOnClickListener{
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
        }
        val textQuiz = findViewById<ImageView>(R.id.btnQuiz)
        textQuiz.setOnClickListener{
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
        }
        val texthelp = findViewById<ImageView>(R.id.BtnAbout)
        texthelp.setOnClickListener{
            val intent = Intent(this, About_us::class.java)
            startActivity(intent)
        }
    }
}
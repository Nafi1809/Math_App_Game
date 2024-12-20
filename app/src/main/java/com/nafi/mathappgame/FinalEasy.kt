package com.nafi.mathappgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FinalEasy : AppCompatActivity() {
    @SuppressLint("WrongViewCast",)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final_easy)
        val textmdm = findViewById<LinearLayout>(R.id.btnMedium)
        textmdm.setOnClickListener{
            val intent = Intent(this, medium::class.java)
            startActivity(intent)
        }
    }
}
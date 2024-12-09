package com.nafi.mathappgame

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputEmail = findViewById(R.id.InputEmail)
        inputPassword = findViewById(R.id.InputPassword)
        val textWishlist = findViewById<RelativeLayout>(R.id.Login)

        textWishlist.setOnClickListener {
            // Validate inputs before proceeding
            if (validateInputs()) {
                val intent = Intent(this, readypage::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(): Boolean {
        val email = inputEmail.text.toString().trim()
        val password = inputPassword.text.toString().trim()
        return email.isNotEmpty() && password.isNotEmpty()
    }
}
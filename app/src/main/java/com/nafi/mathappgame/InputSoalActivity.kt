package com.nafi.mathappgame

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore
import com.nafi.mathappgame.model.soal

class InputSoalActivity : Activity() {
    private lateinit var etQuestion: EditText
    private lateinit var etId: EditText
    private lateinit var etAnswerA: EditText
    private lateinit var etAnswerB: EditText
    private lateinit var etAnswerC: EditText
    private lateinit var etAnswerD: EditText
    private lateinit var etCorrectAnswer: EditText
    private lateinit var etDifficult: EditText
    private lateinit var btnSimpanSoal: Button
    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_soal)

        etQuestion = findViewById(R.id.etQuestion)
        etId = findViewById(R.id.etid)
        etAnswerA = findViewById(R.id.etAnswer_A)
        etAnswerB = findViewById(R.id.etAnswer_B)
        etAnswerC = findViewById(R.id.etAnswer_C)
        etAnswerD = findViewById(R.id.etAnswer_D)
        etCorrectAnswer = findViewById(R.id.etCorrect_Answer)
        etDifficult = findViewById(R.id.etDifficult)
        btnSimpanSoal = findViewById(R.id.btnSimpanSoal)

        btnSimpanSoal.setOnClickListener {
            saveSoal()
        }
    }

    private fun saveSoal() {
        val question = etQuestion.text.toString()

        val id = etId.text.toString()
        val answerA = etAnswerA.text.toString()
        val answerB = etAnswerB.text.toString()
        val answerC = etAnswerC.text.toString()
        val answerD = etAnswerD.text.toString()
        val correctAnswer = etCorrectAnswer.text.toString()
        val difficult = etDifficult.text.toString()

        val soal = soal(id = id, question = question, answer_A = answerA, answer_B = answerB, answer_C = answerC, answer_D = answerD, correct_answer = correctAnswer, difficult = difficult)

        firestore.collection("soal").add(soal).addOnSuccessListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}

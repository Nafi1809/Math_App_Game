package com.nafi.mathappgame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore

class EditSoalActivity : AppCompatActivity() {
    private lateinit var etquestion: EditText
    private lateinit var etanswer_A: EditText
    private lateinit var etanswer_B: EditText
    private lateinit var etanswer_C: EditText
    private lateinit var etanswer_D: EditText
    private lateinit var etcorrect_answer: EditText
    private lateinit var etdifficult: EditText
    private lateinit var btnUbah: Button
    private lateinit var btnHapus: Button
    private lateinit var firestore: FirebaseFirestore
    private lateinit var soalId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_soal)
        etquestion = findViewById(R.id.etQuestion)
        etanswer_A = findViewById(R.id.etAnswer_A)
        etanswer_B = findViewById(R.id.etAnswer_B)
        etanswer_C = findViewById(R.id.etAnswer_C)
        etanswer_D = findViewById(R.id.etAnswer_D)
        etcorrect_answer = findViewById(R.id.etCorrect_Answer)
        etdifficult = findViewById(R.id.etDifficult)
        btnUbah = findViewById(R.id.btnUbah)
        btnHapus = findViewById(R.id.btnHapus)
        firestore = FirebaseFirestore.getInstance()

        soalId = intent.getStringExtra("soalId") ?: ""
        ambilData()
        btnUbah.setOnClickListener {
            val update = mapOf(
                "question" to etquestion.text.toString(),
                "answer_A" to etanswer_A.text.toString(),
                "answer_B" to etanswer_B.text.toString(),
                "answer_C" to etanswer_C.text.toString(),
                "answer_D" to etanswer_D.text.toString(),
                "correct_answer" to etcorrect_answer.text.toString(),
                "difficult" to etdifficult.text.toString()
            )
            firestore.collection("soal").document(soalId).update(update).addOnSuccessListener {
                Toast.makeText(this, "Soal diubah", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        btnHapus.setOnClickListener {
            firestore.collection("soal").document(soalId).delete().addOnSuccessListener {
                Toast.makeText(this, "Soal dihapus", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
    private fun ambilData() {
        firestore.collection("soal").document(soalId).get().addOnSuccessListener { doc ->
            etquestion.setText(doc.getString("question"))
            etanswer_A.setText(doc.getString("answer_A"))
            etanswer_B.setText(doc.getString("answer_B"))
            etanswer_C.setText(doc.getString("answer_C"))
            etanswer_D.setText(doc.getString("answer_D"))
            etcorrect_answer.setText(doc.getString("correct_answer"))
            etdifficult.setText(doc.getString("difficult"))
        }
    }
}
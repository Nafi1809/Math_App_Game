package com.nafi.mathappgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.nafi.mathappgame.adapter.MenuAdapter
import com.nafi.mathappgame.model.soal

class daftar_soal : AppCompatActivity() {
    private lateinit var rvSoal: RecyclerView
    private lateinit var btnAddSoal: Button
    private lateinit var menuAdapter: MenuAdapter
    private val soalList = mutableListOf<soal>()
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_main)

        firestore = FirebaseFirestore.getInstance()
        rvSoal = findViewById(R.id.rvSoal)
        btnAddSoal = findViewById(R.id.btnAddSoal)
        menuAdapter = MenuAdapter(soalList)
        rvSoal.layoutManager = LinearLayoutManager(this)
        rvSoal.adapter = menuAdapter

        btnAddSoal.setOnClickListener {
            val intent = Intent(this, InputSoalActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_SOAL)
        }

        loadSoalData()
    }

    private fun loadSoalData() {
        firestore.collection("soal").get().addOnSuccessListener { documents ->
            soalList.clear()
            for (document in documents) {
                val soal = document.toObject(soal::class.java)
                soalList.add(soal)
            }
            menuAdapter.notifyDataSetChanged()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_SOAL && resultCode == RESULT_OK) {
            loadSoalData()
        }
    }

    companion object {
        const val REQUEST_CODE_ADD_SOAL = 1
    }
}
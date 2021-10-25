package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var edNote: EditText
    private lateinit var btnSub: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        edNote = findViewById(R.id.edNote)
        btnSub = findViewById(R.id.btnSub)

        btnSub.setOnClickListener {

            var s1 = edNote.text.toString()
            var dbhr = DBHlpr(applicationContext)
            var s = dbhr.saveData(s1)
            Toast.makeText(applicationContext,"notes added $s", Toast.LENGTH_LONG).show()
            edNote.text.clear()


        }
    }
}
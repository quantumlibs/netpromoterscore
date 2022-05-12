package com.quantum.nps

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import lib.quantum.nps.NPSRecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context: Context = this
        val npsRV = findViewById<NPSRecyclerView>(R.id.nps_rv)
        npsRV.setSelectedAnswer(15)
        npsRV.OnSelectAnswerListner(object : NPSRecyclerView.NPSAnswerSelectedListener {
            override fun onAnswerSelected(npsAnswer: Int) {
                Toast.makeText(context, ""+npsAnswer, Toast.LENGTH_SHORT).show()
            }
        })

        findViewById<Button>(R.id.click).setOnClickListener{ v->
            run{
                Toast.makeText(this, npsRV.getSelectedAnswer(), Toast.LENGTH_SHORT).show()
            }

        }

    }
}
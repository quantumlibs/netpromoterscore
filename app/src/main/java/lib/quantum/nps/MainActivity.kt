package lib.quantum.nps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<NPSRecyclerView>(R.id.nps_rv).setSelectedAnswer(15)

        findViewById<Button>(R.id.click).setOnClickListener{ v->
            run{
                Toast.makeText(this, findViewById<NPSRecyclerView>(R.id.nps_rv).getSelectedAnswer(), Toast.LENGTH_SHORT).show()
            }

        }

    }
}
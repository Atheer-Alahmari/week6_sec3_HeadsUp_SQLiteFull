package com.example.week6_sec3_headsup_sqlitefull

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_sec3_headsup_sqlitefull.Data_Base.Add_Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            intent = Intent(applicationContext, Game::class.java)
            startActivity(intent)
        }

        btnData.setOnClickListener {
            intent = Intent(applicationContext, Add_Data::class.java)
            startActivity(intent)
        }
    }
}
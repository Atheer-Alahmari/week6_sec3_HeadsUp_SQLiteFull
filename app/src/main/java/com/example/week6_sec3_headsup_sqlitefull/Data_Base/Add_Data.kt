package com.example.week6_sec3_headsup_sqlitefull.Data_Base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week6_sec3_headsup_sqlitefull.R
import kotlinx.android.synthetic.main.activity_add_data.*

class Add_Data : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        btn_Add.setOnClickListener {

            var name = name_ED.text.toString()
            var tabo1 = t1_ED.text.toString()
            var tabo2 = t2_ED.text.toString()
            var tabo3 = t3_ED.text.toString()

            if (name.isNotEmpty() && tabo1.isNotEmpty() && tabo2.isNotEmpty() && tabo3.isNotEmpty()) {
                //----------------Save DB--------------
                var dbhr = MyDBHelper(applicationContext)

                var status = dbhr.save_date(name, tabo1, tabo2, tabo3)

                Toast.makeText(
                    applicationContext,
                    "celebrity Added !  " + status,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(applicationContext, "Please Enter All  ", Toast.LENGTH_SHORT).show()

            }

        }

        //-------------------------------------------------------------------------------------
        updateDelete_btn.setOnClickListener {
            intent = Intent(applicationContext, Update_Delete::class.java)
            startActivity(intent)
        }




    }
}
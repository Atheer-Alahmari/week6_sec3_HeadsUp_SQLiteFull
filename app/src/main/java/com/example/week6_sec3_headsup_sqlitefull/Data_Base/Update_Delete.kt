package com.example.week6_sec3_headsup_sqlitefull.Data_Base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6_sec3_headsup_sqlitefull.Celebrity
import com.example.week6_sec3_headsup_sqlitefull.Game
import com.example.week6_sec3_headsup_sqlitefull.R
import com.example.week6_sec3_headsup_sqlitefull.RV_Adapter
import kotlinx.android.synthetic.main.activity_update_delete.*


class Update_Delete : AppCompatActivity() {
    private var list = ArrayList<Celebrity>()
    lateinit var list_RV: RecyclerView
    lateinit var dbhpr :MyDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)

        list_RV = findViewById(R.id.recycler_View)// Recycler View
        dbhpr= MyDBHelper(applicationContext)

        updateList()

        start_btn.setOnClickListener {
            intent = Intent(applicationContext, Game::class.java)
            startActivity(intent)
        }


    }
    //-------------------------------------------------------------------------------------

    fun updateList() {
        list=dbhpr.retrive()

        list_RV.adapter = RV_Adapter(this,list)
        list_RV.layoutManager = LinearLayoutManager(this)

        list_RV.scrollToPosition(list.size - 1)

    }

}
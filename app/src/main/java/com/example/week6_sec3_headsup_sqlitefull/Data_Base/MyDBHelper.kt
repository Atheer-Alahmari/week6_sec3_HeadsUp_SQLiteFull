package com.example.week6_sec3_headsup_sqlitefull.Data_Base

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.week6_sec3_headsup_sqlitefull.Celebrity

class MyDBHelper (context: Context): SQLiteOpenHelper(context,"celebrities.db", null ,1) {

    var sqliteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table celebrities (Myid integer primary key autoincrement , Name text , Taboo1 text ,Taboo2 text ,Taboo3 text )")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    //-------------------------------------------------------------------------------------

    fun save_date(name: String, tabo1: String, tabo2: String, tabo3: String): Long {

        val cv = ContentValues()
        cv.put("Name", name)
        cv.put("Taboo1", tabo1)
        cv.put("Taboo2", tabo2)
        cv.put("Taboo3", tabo3)
        var status = sqliteDatabase.insert("celebrities", null, cv)
        return status


    }
    //-------------------------------------------------------------------------------------

    fun retrive(): ArrayList<Celebrity> {
        var c: Cursor =sqliteDatabase.query("celebrities",null,null, null,null,null,null)

        c.moveToFirst()


        var listC =ArrayList <Celebrity>()

        while (!c.isAfterLast) {

            var id=c.getInt(c.getColumnIndex("Myid"))
            var names =  c.getString(c.getColumnIndex("Name"))
            var t1=  c.getString(c.getColumnIndex("Taboo1"))
            var t2 =  c.getString(c.getColumnIndex("Taboo2"))
            var t3 =  c.getString(c.getColumnIndex("Taboo3"))

            var obCelebrity=Celebrity(id,names,t1,t2,t3)
            listC.add(obCelebrity)

            c.moveToNext()
        }
        return listC

    }

    //-------------------------------------------------------------------------------------

    fun update(celeId: Int, inputName: String, inputT1: String, inputT2: String, inputT3: String) {
        sqliteDatabase = writableDatabase
        var cv = ContentValues()
        cv.put("Name",inputName)
        cv.put("Taboo1",inputT1)
        cv.put("Taboo2",inputT2)
        cv.put("Taboo3",inputT3)
        sqliteDatabase.update("celebrities", cv, "Myid = ?", arrayOf(celeId.toString()))


    }
    //-------------------------------------------------------------------------------------

    fun delete(celeId: Int) {
        sqliteDatabase = writableDatabase
        sqliteDatabase.delete("celebrities", "Myid = ?", arrayOf(celeId.toString()))

    }
}
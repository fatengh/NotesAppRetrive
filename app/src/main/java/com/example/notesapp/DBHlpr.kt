package com.example.notesapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.util.Currency
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log

class DBHlpr(context: Context?) : SQLiteOpenHelper(context, "notes.db", null, 1) {

    var sqlDB: SQLiteDatabase = writableDatabase // create database variable
    val sqlDBRead:SQLiteDatabase=readableDatabase


    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) { // cteate table
            db.execSQL("create table notes (notes text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    }


    fun saveData(s1: String): Long { // to return : Long
        // add data to ContentValues
        val cv = ContentValues()
        cv.put("notes", s1)
        // add to database 3 para (name of table , null , contentValuse)
        var s = sqlDB.insert("notes", null, cv)
        return s
        // to check data saved or not
        // var statuse= sqlDB.insert("student",null , cv)
        // return statuse
        // return -1 not saved
    }

    fun retrive(): ArrayList<String> {
        val list = ArrayList<String>()
        val c: Cursor = sqlDBRead.query("notes", null, null, null, null, null, null)
       if ( c.moveToFirst()){
           var note = c.getString(c.getColumnIndex("notes"))
           list.add(note)
        while (c.moveToNext()) {
            note = c.getString(c.getColumnIndex("notes"))
            list.add(note)        }

        }
        c.close()
        return list
    }
}




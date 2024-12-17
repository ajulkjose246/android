package com.example.myapplication
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SampleDatabaseHelper(context: Context) : SQLiteOpenHelper(context, "SampleDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE SampleTable (id INTEGER PRIMARY KEY, name TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS SampleTable")
        onCreate(db)
    }

    fun insertData(name: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply { put("name", name) }
        return db.insert("SampleTable", null, values)
    }

    fun getAllData(): List<String> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM SampleTable", null)
        val data = mutableListOf<String>()
        while (cursor.moveToNext()) {
            data.add(cursor.getString(cursor.getColumnIndexOrThrow("name")))
        }
        cursor.close()
        return data
    }
}

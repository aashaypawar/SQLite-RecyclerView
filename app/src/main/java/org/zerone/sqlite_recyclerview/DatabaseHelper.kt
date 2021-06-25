package org.zerone.sqlite_recyclerview

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DATABASE_NAME = "dbname"
const val TABLE_NAME = "userTable"
const val COL_1 = "Name"
const val COL_2 = "Age"

class DatabaseHelper(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME($COL_1 VARCHAR(256), $COL_2 INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(name: String, age:Int){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_1, name)
        cv.put(COL_2, age)
        db.insert(TABLE_NAME, null, cv)
        db.close()
    }

    fun readData(): MutableList<UserObj>{
        val list: MutableList<UserObj> = ArrayList()
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if(result.moveToFirst()){
            do {
                val temp = UserObj()
                temp.userName = result.getString(result.getColumnIndex(COL_1))
                temp.userAge = result.getInt(result.getColumnIndex(COL_2))

                list.add(temp)
            } while (result.moveToNext())
        }
        return list
    }
}
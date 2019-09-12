package com.example.app21

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

val DB_NAME = "StaffDB"
val TABLE_NAME = "Staff"
val COL1 = "city"
val COL2 = "sname"

class MyHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var create_table = "create table $TABLE_NAME ($COL1 varchar(250), $COL2 varchar(250))"
        p0?.execSQL(create_table)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(dto: Staff): Long{
        var cv = ContentValues()

        cv.put(COL1, dto.city)
        cv.put(COL2, dto.sname)

        var db = this.writableDatabase
        var res = db.insert(TABLE_NAME, null, cv)

        return res
    }

    fun readRecord(): ArrayList<Staff>{
        var list = ArrayList<Staff>()
        var db = this.readableDatabase
        var c = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (c != null){
            if(c.moveToFirst()){
                do{
                    var city = c.getString(c.getColumnIndex(COL1))
                    var name = c.getString(c.getColumnIndex(COL2))
                    list.add(Staff(city, name))
                }while (c.moveToNext())
            }
        }
        return list
    }

}
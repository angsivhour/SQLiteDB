package com.example.app21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun insert(v: View){
        var city: String = city.text.toString()
        var name: String = name.text.toString()

        var dto1 = Staff(city, name)

        var helper = MyHelper(this)

        var res = helper.insertData(dto1)

        if(res == (-1).toLong()){
            Toast.makeText(this, "Registration failed...", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this, "Registration success...", Toast.LENGTH_LONG).show()
        }
    }

    fun  viewData(v: View){
        var db = MyHelper(this)
        var list = db.readRecord()
        var str = ""
        for(i in list){
            str += i.city + " : " + i.sname + "\n"
        }
        textView.text = str
    }
}

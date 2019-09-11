package com.example.app21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

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

        if(res == -1.toLong()){
            Toast.makeText(this, "Registration failed...", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this, "Registration success...", Toast.LENGTH_LONG).show()
        }
    }
}

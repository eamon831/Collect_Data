package com.example.collectdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var form=findViewById<Button>(R.id.form);
        var datalist=findViewById<Button>(R.id.datalist)
        form.setOnClickListener(){
            var intent=Intent(this,Form::class.java)
            startActivity(intent)
        }
        datalist.setOnClickListener(){
            var intent=Intent(this,ListofData::class.java)
            startActivity(intent)
        }
    }
}
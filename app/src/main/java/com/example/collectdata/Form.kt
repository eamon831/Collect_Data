package com.example.collectdata

import Database.Model
import Database.ViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


class Form : AppCompatActivity() {
    lateinit var vname:EditText
    lateinit var veducation:EditText
    lateinit var vage:EditText
    lateinit var vnumber:EditText
    lateinit var vsubmit:Button
    lateinit var mViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        vname=findViewById(R.id.name)
        veducation=findViewById(R.id.education)
        vage=findViewById(R.id.age)
        vnumber=findViewById(R.id.number)
        vsubmit=findViewById(R.id.submit)
        mViewModel=ViewModelProvider(this).get(ViewModel::class.java)
        vsubmit.setOnClickListener(){
            ok()
        }
    }

    private fun ok() {
        var name:String=vname.text.toString()
        var education:String=veducation.text.toString()
        var age:String=vage.text.toString()
        var number:String=vnumber.text.toString()
        var tf:Boolean=false
        if(number.isEmpty()){
            checkerror(vnumber)
            tf=true
        }
        if(age.isEmpty()){
            checkerror(vage)
            tf=true
        }
        if(education.isEmpty()){
            checkerror(veducation)
            tf=true
        }
        if(name.isEmpty()){
            checkerror(vname)
            tf=true
        }
        if(tf){
            return
        }
        val model= Model(0,name,education,age,number)
        mViewModel.addModel(model)
        Toast.makeText(this,"Added Successfully",Toast.LENGTH_LONG).show()
        vname.setText("")
        veducation.setText("")
        vage.setText("")
        vnumber.setText("")



    }

    private fun checkerror(vnumber: EditText) {
        vnumber.setError("Invalid")
        vnumber.requestFocus()
    }
}
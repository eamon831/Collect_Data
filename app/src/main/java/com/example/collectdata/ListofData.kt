package com.example.collectdata

import Database.ViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListofData : AppCompatActivity() {
    lateinit var listofmodel:RecyclerView
    private lateinit var mModelViewModel:ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listof_data)
        listofmodel=findViewById(R.id.recview)
        val adapter=ListAdapter()
        listofmodel.adapter=adapter
        listofmodel.layoutManager=LinearLayoutManager(this)

        mModelViewModel=ViewModelProvider(this).get(ViewModel::class.java)
        mModelViewModel.reaAllData.observe(this, Observer { model->
            adapter.setdata(model)
        })



    }
}
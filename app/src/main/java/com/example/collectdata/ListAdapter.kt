package com.example.collectdata

import Database.Model
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var modelList= emptyList<Model>()
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
         val name:TextView=itemView.findViewById(R.id.rname)
         val education:TextView=itemView.findViewById(R.id.reducation)
         val age:TextView=itemView.findViewById(R.id.rage)
         val number:TextView=itemView.findViewById(R.id.rnumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.singlerow,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current=modelList[position]
        holder.name.text="Name : "+current.Name
        holder.education.text="Education : "+current.Education
        holder.age.text="Age : "+current.Age
        holder.number.text="Phone Number : "+current.Number
    }

    override fun getItemCount(): Int {
        return modelList.size
    }
    fun setdata(model: List<Model>){
        this.modelList=model
        notifyDataSetChanged()

    }
}
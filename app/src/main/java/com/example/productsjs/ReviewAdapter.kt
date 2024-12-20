package com.example.productsjs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.products.Review
import com.example.productsjs.MyAdapter.Holder

class ReviewAdapter(var mainActivity2: MainActivity2, var reviews: ArrayList<Review>) :RecyclerView.Adapter<ReviewAdapter.Holder>() {

    class Holder (view : View): RecyclerView.ViewHolder(view){

        var rating : TextView= view.findViewById(R.id.rating)
        var comment : TextView= view.findViewById(R.id.comment)
        var date   : TextView = view.findViewById(R.id.date)
        var revName : TextView = view.findViewById(R.id.revName)
        var revEmail : TextView = view.findViewById(R.id.revEmail)
        var rattibar : RatingBar = view.findViewById(R.id.Ratingbar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var layoutInflater = LayoutInflater.from(mainActivity2)
        var view : View= layoutInflater.inflate(R.layout.item_review,parent,false)
        var holder : Holder=Holder(view)
        return holder
    }

    override fun getItemCount(): Int {
      return  reviews.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        var model : Review = reviews[position]

        holder.rating.text= model.rating.toString()







        holder.comment.text = "comment : "+model.comment.toString()
        holder.date.text = "date : "+model.date
        holder.revName.text = " "+model.reviewerName
        holder.revEmail.text = " "+model.reviewerEmail
        holder.rattibar.rating= model.rating.toFloat()
    }
}
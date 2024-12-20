package com.example.productsjs

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.products.Product

class MyAdapter(var mainActivity: MainActivity, var List: ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    class  Holder (view: View) : RecyclerView.ViewHolder(view){

        var picture : ImageView=view.findViewById(R.id.picture)
        var title : TextView = view.findViewById(R.id.P_title)
        var ratting : RatingBar = view.findViewById(R.id.RatingBar)
      //  var reviews : TextView = view.findViewById(R.id.reviews)
        var price : TextView = view.findViewById(R.id.price)
        var discount : TextView = view.findViewById(R.id.discount)
        var warranty : TextView = view.findViewById(R.id.warranty)
        var linear : LinearLayout = view.findViewById(R.id.linearClik)
        var status : TextView = view.findViewById(R.id.availability)
        var rate : TextView = view.findViewById(R.id.rate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        var layoutInflater = LayoutInflater.from(mainActivity)
        var view : View= layoutInflater.inflate(R.layout.item_product,parent,false)
        var holder : Holder = Holder(view)
        return  holder

    }

    override fun getItemCount(): Int {

        return List.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        var model : Product = List[position]

         holder.title.text= model.title
         holder.ratting.rating= model.rating.toFloat()
         //holder.reviews.text= model.reviews[2].toString()
         holder.price.text= "₹ "+model.price.toString()
         holder.discount.text="▼ "+model.discountPercentage.toString() +"% Off"
         holder.warranty.text=model.warrantyInformation
         holder.status.text = model.availabilityStatus
         holder.rate.text = model.rating.toString()

        Glide.with(holder.picture)
            .load(model.thumbnail)
            .into(holder.picture)

         holder.linear.setOnClickListener {


             var inten : Intent = Intent(mainActivity , MainActivity2::class.java)
             inten.putExtra("id",model)
             mainActivity.startActivity(inten)


        }

    }
}
package com.example.productsjs

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.productsjs.MyAdapter.Holder

class AdapterPager(var mainActivity2: MainActivity2, var images: ArrayList<String>) : RecyclerView.Adapter<AdapterPager.Holder>() {


    class  Holder (view : View) : RecyclerView.ViewHolder(view){

        var picture : ImageView =view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        var layoutInflater = LayoutInflater.from(mainActivity2)
        var view : View= layoutInflater.inflate(R.layout.item_pager,parent,false)
        var holder : Holder=Holder(view)

        return  holder
    }

    override fun getItemCount(): Int {
      return images.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        Log.d("===*==", "image ${images[position]}")

        Glide.with(holder.picture)
            .load(images[position])
            .into(holder.picture)
    }
}
package com.example.productsjs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.products.Product
import com.example.productsjs.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()

        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        var model : Product? = intent.getSerializableExtra("id") as Product?


        if(model!= null)
        {
//            Glide.with(binding.image)
//                .load(model.thumbnail)
//                .into(binding.image)

            binding.product.text= model.title
            binding.category.text = model.category
            binding.RatingBar.rating= model.rating.toFloat()
            binding.rate.text = model.rating.toString()


            binding.brand.text="Brand : "+model.brand.toString()
            binding.stok.text= "stock : "+model.stock.toString()

            binding.dicountr.text =""+model.discountPercentage.toString()+"% Off"
            binding.price.text= "₹ "+model.price.toString()
            binding.description.text = "       "+model.description
            binding.returnPolicy.text = ""+model.returnPolicy

            binding.warranty.text= model.warrantyInformation
            binding.shiping.text= ""+model.shippingInformation
            binding.availability.text = "Status : "+model.availabilityStatus

            binding.width.text = "width "+model.dimensions.width.toString()+" ||"
            binding.height.text="height "+ model.dimensions.height.toString()+" ||"
            binding.depth.text = "depth "+model.dimensions.depth.toString()
            binding.created.text = model.meta.createdAt
            binding.updatedAt.text= model.meta.updatedAt
            binding.barcode.text = "Barcode : "+model.meta.barcode
            binding.qrCode.text = "qrCode : "+model.meta.qrCode
        }

        val layoutManager: LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recycler2.layoutManager = layoutManager

       var adapter : AdapterPager = AdapterPager(this@MainActivity2 , model!!.images)
        binding.recycler2.adapter=adapter
        binding.indicator.attachToRecyclerView(binding.recycler2)

        var adaptr : ReviewAdapter = ReviewAdapter(this@MainActivity2, model.reviews)
        binding.RecyView3.adapter=adaptr

    }

}



package com.example.productsjs

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.products.Dimension
import com.example.products.Meta
import com.example.products.Product
import com.example.products.Review
import com.example.productsjs.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        products()

    }

    private fun products() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://dummyjson.com/products"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->

                var mainOB: JSONObject = JSONObject(response.toString())

                var total: Int = mainOB.getInt("total")
                var skip: Int = mainOB.getInt("skip")
                var limit: Int = mainOB.getInt("limit")

                // binding.textView.text= skip.toString()

                var List = ArrayList<Product>()

                var PrArray: JSONArray = mainOB.getJSONArray("products")

                for (i in 0 until PrArray.length()) {

                    var ProductOB: JSONObject = PrArray.getJSONObject(i)

                    var id: Int = ProductOB.getInt("id")
                    var title: String = ProductOB.getString("title")
                    var description: String = ProductOB.getString("description")
                    var category: String = ProductOB.getString("category")
                    var price: Double = ProductOB.getDouble("price")
                    var discountPercentage: Double = ProductOB.getDouble("discountPercentage")
                    var rating: Double = ProductOB.getDouble("rating")
                    var stock: Int = ProductOB.getInt("stock")

                    var tagArray: JSONArray = ProductOB.getJSONArray("tags")
                    var tag: ArrayList<String> = ArrayList<String>()
                    for (j in 0 until tagArray.length()) {

                        tag.add(tagArray.toString(j))
                    }

                    var brand: String = "-"
                    if (ProductOB.has("brand")) {

                        brand = ProductOB.getString("brand")
                    }


                    var sku: String = ProductOB.getString("sku")
                    var weight: Int = ProductOB.getInt("weight")

                    var dimensionsObj: JSONObject = ProductOB.getJSONObject("dimensions")
                    var dimensions = Dimension(

                        dimensionsObj.getDouble("width"),
                        dimensionsObj.getDouble("height"),                  // Dimention Objecrt
                        dimensionsObj.getDouble("depth")
                    )

                    var warrantyInformation: String = ProductOB.getString("warrantyInformation")
                    var shippingInformation: String = ProductOB.getString("shippingInformation")
                    var availabilityStatus: String = ProductOB.getString("availabilityStatus")


                    var reviewsArray: JSONArray = ProductOB.getJSONArray("reviews")
                    var reviewsList = ArrayList<Review>()

                    for (l in 0 until reviewsArray.length()) {

                        var reviewObj: JSONObject = reviewsArray.getJSONObject(l)

                        var rating: Int = reviewObj.getInt("rating")
                        var comment: String = reviewObj.getString("comment")
                        var date: String = reviewObj.getString("date")
                        var reviewerName: String = reviewObj.getString("reviewerName")
                        var reviewerEmail: String = reviewObj.getString("reviewerEmail")

                        var revmodel = Review(rating, comment, date, reviewerName, reviewerEmail)
                        reviewsList.add(revmodel)
                    }

                    var returnPolicy: String = ProductOB.getString("returnPolicy")
                    var minimumOrderQuantity: String = ProductOB.getString("minimumOrderQuantity")

                    var metaObj: JSONObject = ProductOB.getJSONObject("meta")
                    var meta = Meta(
                        metaObj.getString("createdAt"),
                        metaObj.getString("updatedAt"),
                        metaObj.getString("barcode"),
                        metaObj.getString("qrCode")
                    )

                    var imagesArray: JSONArray = ProductOB.getJSONArray("images")
                    var images: ArrayList<String> = ArrayList<String>()
                    for (d in 0 until imagesArray.length()) {

                        images.add(imagesArray.getString(d))
                    }
                    var thumbnail: String = ProductOB.getString("thumbnail")

                    var model = Product(
                        id,
                        title,
                        description,
                        category,
                        price,
                        discountPercentage,
                        rating,
                        stock,
                        tag,
                        brand,
                        sku,
                        weight,
                        dimensions,
                        warrantyInformation,
                        shippingInformation,
                        availabilityStatus,
                        reviewsList,
                        returnPolicy,
                        minimumOrderQuantity,
                        meta,
                        images,
                        thumbnail
                    )
                    List.add(model)
                    // binding.textView.text= title[0].toString()
                }

                var adapter: MyAdapter = MyAdapter(this, List)
                binding.RecyView.adapter = adapter
                binding.progressCircular.visibility = View.GONE


            },

            {
//                textView.text = "That didn't work!"
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

}
//https://generateapi.onrender.com/modelPage
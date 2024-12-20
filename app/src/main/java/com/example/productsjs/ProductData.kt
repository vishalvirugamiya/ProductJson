package com.example.products

import java.io.Serializable

class Productdata(

    val products : ArrayList<Product>,
    val total    : Int,
    val skip     : Int,
    val limit    :Int

):Serializable

class  Product(

    var id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,

    val tags: ArrayList<String>,                                 // tag ArrayList<>
    val brand: String,
    val sku: String,
    val weight: Int,

    val dimensions: Dimension,                                  // Dimention ArrayList
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus:String,
    val reviews: ArrayList<Review>,                              // review ArrayList
    val returnPolicy: String,
    val minimumOrderQuantity: String,
    val meta: Meta,
    val images: ArrayList<String>,
    val thumbnail:String

):Serializable

class Dimension(

    val width : Double,
    val height : Double,
    val depth : Double

):Serializable

class  Review(

    val  rating  : Int,
    var  comment : String,
    val  date    : String,
    val  reviewerName : String,
    val  reviewerEmail : String

):Serializable

class  Meta(
    val createdAt : String,
    val updatedAt  : String,
    val barcode  : String,
    val qrCode   : String

):Serializable
package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class Good(
    @SerializedName("costGood")
    val costGood: Int, // 2
    @SerializedName("idCompany")
    val idCompany: Int, // 4
    @SerializedName("idGoods")
    val idGoods: Int, // 6
    @SerializedName("modelGoods")
    val modelGoods: String, // bests a4
    @SerializedName("nameGoods")
    val nameGoods: String, // مودم
    @SerializedName("unitCostGoods")
    val unitCostGoods: Int, // 1000000
    @SerializedName("urlImg")
    val urlImg: String, // https://cdn1.bigcommerce.com/n-yp39j5/3myxvgmu/products/287/images/599/arris_tg2472__59907.1510379659.1280.1280.jpg?c=2
    var isModemCheched:Boolean=false
)
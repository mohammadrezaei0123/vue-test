package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class  Modem (
    @SerializedName("id")
    val id:Int,
    @SerializedName("model")
    val model:String,
    @SerializedName("price")
    val price:Int,
    var isModemCheched:Boolean=false
)



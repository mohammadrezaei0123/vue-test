package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class Sale (
    @SerializedName("id")
    val id:Int,
    @SerializedName("iduser")
    val iduser:String,
    @SerializedName("idpackage")
    val idpackage:String,
    @SerializedName("idmodem")
    val idmodem:String,
    @SerializedName("takhfif")
    val takhfif:Int,
    @SerializedName("gheimat")
    val gheimat:Int
)

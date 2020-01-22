package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class Package (
    @SerializedName("id")
    val id:Int,
    @SerializedName("bandwidth(mb)")
    val bandwidth:Int,
    @SerializedName("traffic(gb)")
    val traffic:Int,
    @SerializedName("time(moon)")
    val time:Int,
    @SerializedName("price")
    val price:Int
)
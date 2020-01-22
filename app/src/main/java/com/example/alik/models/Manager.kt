package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class Manager (
    @SerializedName("id")
    var id:String,
    @SerializedName("user")
    var user:String,
    @SerializedName("pass")
    var password:String
)
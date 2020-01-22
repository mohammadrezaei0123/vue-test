package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    var id:String,
    @SerializedName("name")
    var name:String,
    @SerializedName("fname")
    var fname:String,
    @SerializedName("phone")
    var phone:String,
    @SerializedName("user")
    var user:String,
    @SerializedName("password")
    var password:String
)
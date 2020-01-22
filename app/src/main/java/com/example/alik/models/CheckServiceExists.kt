package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class CheckServiceExists(
    @SerializedName("existsservice")
    val existsservice: Boolean // true
)
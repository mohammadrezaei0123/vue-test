package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class Computerunit(
    @SerializedName("idComputerUnit")
    val idComputerUnit: Int, // 4
    @SerializedName("nameUnit")
    val nameUnit: String, // مگابایت
    @SerializedName("smallUnit")
    val smallUnit: String // mb
)

package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class SizeCompany2(
    @SerializedName("cost")
    val cost: List<CostX>,
    @SerializedName("idCompany")
    val idCompany: Int, // 4
    @SerializedName("nameCompany")
    val nameCompany: String // رایتل
)
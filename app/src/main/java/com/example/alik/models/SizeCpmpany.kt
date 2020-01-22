package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class SizeCpmpany(
    @SerializedName("computerunit")
    val computerunit: List<Computerunit>,
    @SerializedName("cost")
    val cost: List<Cost>,
    @SerializedName("idCompany")
    val idCompany: Int, // 4
    @SerializedName("nameCompany")
    val nameCompany: String // رایتل
)
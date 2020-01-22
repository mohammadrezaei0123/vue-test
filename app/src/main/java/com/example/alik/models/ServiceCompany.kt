package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class ServiceCompany(
    @SerializedName("computerunit")
    val computerunit: List<Computerunit>,
    @SerializedName("existsservise")
    val existsservise: List<Existsservise>,
    @SerializedName("goods")
    val goods: List<Good>,
    @SerializedName("idCompany")
    val idCompany: Int, // 4
    @SerializedName("isconfig")
    val isconfig: Boolean, // false
    @SerializedName("nameCompany")
    val nameCompany: String // رایتل
)
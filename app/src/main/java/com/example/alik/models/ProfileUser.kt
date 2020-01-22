package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class ProfileUser(
    @SerializedName("computerunit")
    val computerunit: List<Computerunit>,
    @SerializedName("idCompany")
    val idCompany: Int, // 1
    @SerializedName("idCreatedService")
    val idCreatedService: Int, // 46
    @SerializedName("idSizeService")
    val idSizeService: Int, // 1
    @SerializedName("idUnitPeriod")
    val idUnitPeriod: Int, // 2
    @SerializedName("idUser")
    val idUser: Int, // 1
    @SerializedName("numCost")
    val numCost: String, // 20
    @SerializedName("numLimit")
    val numLimit: String, // 5
    @SerializedName("numPeriod")
    val numPeriod: Int, // 1
    @SerializedName("numSpeed")
    val numSpeed: String, // 128
    @SerializedName("offCost")
    val offCost: String, // 1000
    @SerializedName("offLimit")
    val offLimit: String, // 2
    @SerializedName("unitCost")
    val unitCost: String, // 1000
    @SerializedName("unitLimit")
    val unitLimit: Int, // 2
    @SerializedName("unitSpeed")
    val unitSpeed: Int // 1
)
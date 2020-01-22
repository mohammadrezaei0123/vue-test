package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class Existsservise(
    @SerializedName("finalLimit")
    val finalLimit: Int, // 387
    @SerializedName("finaleCost")
    val finaleCost: Int, // 159000
    @SerializedName("idCompany")
    val idCompany: Int, // 4
    @SerializedName("idCreatedService")
    val idCreatedService: Int, // 204
    @SerializedName("idSizeService")
    val idSizeService: Int, // 8
    @SerializedName("idUnitPeriod")
    val idUnitPeriod: Int, // 3
    @SerializedName("nameUnitPeriod")
    val nameUnitPeriod: String, // سال
    @SerializedName("numCost")
    val numCost: Int, // 160
    @SerializedName("numLimit")
    val numLimit: Int, // 125
    @SerializedName("numPeriod")
    val numPeriod: Int, // 1
    @SerializedName("numSpeed")
    val numSpeed: Int, // 1028
    @SerializedName("offCost")
    val offCost: Int, // -1000
    @SerializedName("offLimit")
    val offLimit: Int, // 262
    @SerializedName("unitCost")
    val unitCost: Int, // 1000
    @SerializedName("unitLimit")
    val unitLimit: Int, // 2
    @SerializedName("unitSpeed")
    val unitSpeed: Int // 4
)
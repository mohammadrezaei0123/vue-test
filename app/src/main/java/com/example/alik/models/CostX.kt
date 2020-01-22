package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class CostX(
    @SerializedName("finalLimit")
    val finalLimit: Int, // 3
    @SerializedName("finaleCost")
    val finaleCost: Int, // 199000
    @SerializedName("idCompany")
    val idCompany: Int, // 4
    @SerializedName("idCreatedService")
    val idCreatedService: Int, // 241
    @SerializedName("idSizeService")
    val idSizeService: Int, // 10
    @SerializedName("idUnitPeriod")
    val idUnitPeriod: Int, // 2
    @SerializedName("nameUnitPeriod")
    val nameUnitPeriod: String, // ماه
    @SerializedName("numCost")
    val numCost: Int, // 2
    @SerializedName("numLimit")
    val numLimit: Int, // 1
    @SerializedName("numPeriod")
    val numPeriod: Int, // 1
    @SerializedName("numSpeed")
    val numSpeed: Int, // 128
    @SerializedName("offCost")
    val offCost: Int, // -1000
    @SerializedName("offLimit")
    val offLimit: Int, // 2
    @SerializedName("unitCost")
    val unitCost: Int, // 100000
    @SerializedName("unitLimit")
    val unitLimit: Int, // 3
    @SerializedName("unitSpeed")
    val unitSpeed: Int // 1
)
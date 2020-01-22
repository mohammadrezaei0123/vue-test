package com.example.alik.models

import com.google.gson.annotations.SerializedName

data class StatusBean (
   var statusId:Int,
   var status:String,
   var statusCode:String
)
data class ModemCell(
   val nameModemCell: String,
   val idModemCell: Int,
   val imgSrcModem:String,
   var isModemCheched:Boolean=false
)

data class UnitPeriod(
   @SerializedName("idUnitPeriod")
   val idUnitPeriod: Int, // 3
   @SerializedName("nameUnitPeriod")
   val nameUnitPeriod: String // سال
)


data class Users1(
   @SerializedName("userName")
   var  userName:String,
   @SerializedName("passwordUser")
   var passwordUser:String,
   @SerializedName("emailUser")
   var emailUser:String,
   @SerializedName("idUser")
   val idUser:Int,
   @SerializedName("phoneNumber")
   var phoneNumber:String,
   @SerializedName("constPhoneNumber")
   var constPhoneNumber:String,
   @SerializedName("addressUser")
   var addressUser:String
)
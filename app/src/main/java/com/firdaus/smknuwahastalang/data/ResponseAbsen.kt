package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponseAbsen (
    @SerializedName("pesan") val message : String,
    @SerializedName("status") val status : Boolean,
    @SerializedName("keterangan") val keterangan : String,
    @SerializedName("dataLogin") val data : DataLogin
)
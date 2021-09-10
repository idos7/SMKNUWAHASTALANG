package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponseUbahPassword (
    @SerializedName("pesan") val message : String,
    @SerializedName("status") val status : Boolean,
)
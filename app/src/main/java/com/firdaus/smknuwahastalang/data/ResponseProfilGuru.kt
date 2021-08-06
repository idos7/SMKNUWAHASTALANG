package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponseProfilGuru (
    @SerializedName("pesan") val message : String,
    @SerializedName("status") val status : Boolean,
    @SerializedName("data") val data : DataProfilGuru
)
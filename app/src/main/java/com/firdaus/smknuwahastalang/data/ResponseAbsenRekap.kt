package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponseAbsenRekap (
    @SerializedName("pesan") val message : String,
    @SerializedName("status") val status : Boolean,
    @SerializedName("data") val data : DataRekapAbsen

)
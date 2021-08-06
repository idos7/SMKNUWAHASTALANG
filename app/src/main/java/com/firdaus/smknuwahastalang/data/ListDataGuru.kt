package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ListDataGuru (
        @SerializedName("id") val id : Int,
        @SerializedName("nama") val nama : String,
        @SerializedName("jabatan") val jabatan : String,
        @SerializedName("pendidikan_terakhir") val pendidikan_terakhir : String

)
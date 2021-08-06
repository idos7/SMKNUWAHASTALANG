package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponseListJadwal (
        @SerializedName("hari") val hari : String,
        @SerializedName("kelas") val kelas : String,
        @SerializedName("pesan") val message : String,
        @SerializedName("status") val status : Boolean,
        @SerializedName("data") val data : List<ListJadwal>
        )

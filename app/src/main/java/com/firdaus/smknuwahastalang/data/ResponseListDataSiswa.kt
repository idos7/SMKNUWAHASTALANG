package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponseListDataSiswa (
    @SerializedName("id") val id : Int,
    @SerializedName("pesan") val message : String,
    @SerializedName("status") val status : Boolean,
    @SerializedName("tanggal") val tanggal : String,
    @SerializedName("kelas") val kelas : String,
    @SerializedName("data") val data : List<ListDataSiswa>
)
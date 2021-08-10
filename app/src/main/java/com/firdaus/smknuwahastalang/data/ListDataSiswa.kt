package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ListDataSiswa (
        @SerializedName("id") val id : Int,
        @SerializedName("nis") val nis : String,
        @SerializedName("nama") val nama : String,
        @SerializedName("kelas") val kelas : String,
        @SerializedName("nama_kelas") val jurusan : String

)
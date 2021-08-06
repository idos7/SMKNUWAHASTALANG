package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class DataProfil (
        @SerializedName("nama") val nama : String,
        @SerializedName("nis") val nis : String,
        @SerializedName("nisn") val nisn : String,
        @SerializedName("gender") val gender : String,
        @SerializedName("kelas") val kelas : String,
        @SerializedName("nama_kelas") val jurusan : String,
        @SerializedName("agama") val agama : String,
        @SerializedName("tempat_lahir") val tempat_lahir : String,
        @SerializedName("tanggal_lahir") val tanggal_lahir : String,
        @SerializedName("alamat") val alamat : String

)
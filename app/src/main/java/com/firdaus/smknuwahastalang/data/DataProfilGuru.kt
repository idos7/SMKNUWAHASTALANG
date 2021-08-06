package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class DataProfilGuru (
        @SerializedName("nama") val nama : String,
        @SerializedName("nip") val nip : String,
        @SerializedName("jabatan") val jabatan : String,
//        @SerializedName("gender") val gender : String,
        @SerializedName("pendidikan_terakhir") val pendidikan_terakhir : String,
//        @SerializedName("mapel_yang_diampu") val mapel_yang_diampu : String,
        @SerializedName("agama") val agama : String,
//        @SerializedName("tempat_lahir") val tempat_lahir : String,
//        @SerializedName("tanggal_lahir") val tanggal_lahir : String,
        @SerializedName("alamat") val alamat : String

)
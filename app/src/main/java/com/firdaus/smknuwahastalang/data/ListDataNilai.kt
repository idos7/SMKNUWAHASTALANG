package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ListDataNilai (
    @SerializedName("id_nilai") val id_nilai : Int,
    @SerializedName("nis") val nis : String,
    @SerializedName("nama") val nama : String,
    @SerializedName("kelas") val kelas : Int,
    @SerializedName("semester") val semester : Int,
    @SerializedName("nama_mapel") val nama_mapel : String,
    @SerializedName("tugas") val tugas : Int,
    @SerializedName("uts") val uts : Int,
    @SerializedName("uas") val uas : Int,
    @SerializedName("nilai_akhir") val nilai_akhir : Int
)
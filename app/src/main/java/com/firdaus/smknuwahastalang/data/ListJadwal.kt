package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ListJadwal (
    @SerializedName("waktu") val waktu : String,
    @SerializedName("nama_mapel") val nama_mapel : String,
    @SerializedName("nama_kelas") val nama_kelas : String,
    @SerializedName("kelas") val kelas : String,

    )
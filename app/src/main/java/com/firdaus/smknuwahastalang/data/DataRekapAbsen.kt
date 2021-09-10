package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class DataRekapAbsen (
        @SerializedName("hadir") val hadir : String,
        @SerializedName("izin") val izin : String,
        @SerializedName("alfa") val alfa : String,
        @SerializedName("persentase") val persentase : String


)
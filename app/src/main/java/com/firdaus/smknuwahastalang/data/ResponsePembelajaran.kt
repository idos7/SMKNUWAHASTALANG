package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponsePembelajaran (
        @SerializedName("status") val status : Boolean,
        @SerializedName("pesan") val message  : String

)
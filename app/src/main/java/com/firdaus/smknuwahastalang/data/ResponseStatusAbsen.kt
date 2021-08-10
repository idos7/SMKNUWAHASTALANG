package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponseStatusAbsen (
    @SerializedName("status") val status : Boolean,
    @SerializedName("data") val data : String
)
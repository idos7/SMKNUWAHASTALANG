package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class ResponseListDataNilai (
        @SerializedName("status") val status : Boolean,
        @SerializedName("data") val data : List<ListDataNilai>
)
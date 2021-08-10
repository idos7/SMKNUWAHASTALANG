package com.firdaus.smknuwahastalang.data

import com.google.gson.annotations.SerializedName

class DataLogin (
        @SerializedName("id") val id : Int,
        @SerializedName("name") val name : String,
        @SerializedName("email") val email : String,
        @SerializedName("nisnip") val nisnip : String,
        @SerializedName("rule") val rule : Int

)
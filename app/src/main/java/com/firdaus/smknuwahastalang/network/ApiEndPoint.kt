package com.firdaus.smknuwahastalang.network

import com.firdaus.smknuwahastalang.data.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiEndPoint {
    @FormUrlEncoded
    @POST("login")
    fun Login(
        @Field("email") email:String,
        @Field("password") password:String
    ): Call<ResponseLogin>
}
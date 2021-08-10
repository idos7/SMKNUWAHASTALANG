package com.firdaus.smknuwahastalang.network

import com.firdaus.smknuwahastalang.data.*
import retrofit2.Call
import retrofit2.http.*

interface ApiEndPoint {
    @FormUrlEncoded
    @POST("login")
    fun Login(
        @Field("username") email:String,
        @Field("password") password:String
    ): Call<ResponseLogin>

    @FormUrlEncoded
    @POST("password/email")
    fun forgot(
        @Field("email") email:String
    ): Call<ResponseForgot>

    @FormUrlEncoded
    @POST("password/reset")
    fun forgotPW(
            @Field("email") email:String,
            @Field("token") token:String,
            @Field("password") password:String,
            @Field("password_confirmation") password_confirmation:String
    ): Call<ResponseForgot>

    @GET("datasiswa")
    fun ListDataSiswa(
    ): Call<ResponseListDataSiswa>

    @GET("cek")
    fun ListDataGuru(
    ): Call<ResponseListDataGuru>

    @GET("profil/{id}")
    fun Profil(
        @Path("id")id:String
    ): Call<ResponseProfil>

    @GET("profilguru/{id}")
    fun ProfilGuru(
        @Path("id")id:String
    ): Call<ResponseProfilGuru>

    @GET("profilguru/{id}")
    fun DetailGuru(
        @Path("id")id:Int
    ): Call<ResponseProfilGuru>

    @GET("inputabsen/{keterangan}/{siswa}")
    fun InputAbsen(
            @Path("keterangan")keterangan:String,
            @Path("siswa")siswa:Int
    ): Call<ResponseAbsen>

    @GET("cekabsen/{siswa}/{tanggal}")
    fun cekAbsen(
            @Path("siswa")siswa:String,
            @Path("tanggal")tanggal:String
    ): Call<ResponseAbsen>

    @GET("jadwalhariini/{kelas}/{nama_kelas}")
    fun ListJadwal(
            @Path("kelas")kelas:String,
            @Path("nama_kelas")nama_kelas:String
    ): Call<ResponseListJadwal>

    @GET("jadwalhariini_guru/{nama}")
    fun ListJadwalGuru(
        @Path("nama")nama:String,
    ): Call<ResponseListJadwal>

    @GET("listabsen/{nama}")
    fun ListAbsen(
        @Path("nama")nama:String,
    ): Call<ResponseListDataSiswa>

    @GET("listabsen")
    fun getAbsen(
    ): Call<ResponseListDataSiswa>

    @GET("inputabsen")
    fun getStatusAbsen(
    ): Call<ResponseStatusAbsen>

}
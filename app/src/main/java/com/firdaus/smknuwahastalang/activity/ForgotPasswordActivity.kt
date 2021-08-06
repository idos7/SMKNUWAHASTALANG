package com.firdaus.smknuwahastalang.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseForgot
import com.firdaus.smknuwahastalang.data.ResponseLogin
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_forgot_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        btnSendEmail.setOnClickListener { kirimReset() }
    }

    private fun kirimReset() {
        ApiService.instance.forgot(edtPassword.text.toString()).enqueue(object : Callback<ResponseForgot> {
            override fun onFailure(call: Call<ResponseForgot>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
            override fun onResponse(
                call: Call<ResponseForgot>,
                response: Response<ResponseForgot>
            ) {
                val t = response.body()!!
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    SharedPrefManager.getInstance(applicationContext).saveDataTemp(edtPassword.text.toString())

                    val intent = Intent (applicationContext,VerifikasiPasswordActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            }

        })
    }
}
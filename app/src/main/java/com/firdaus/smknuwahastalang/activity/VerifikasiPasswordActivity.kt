package com.firdaus.smknuwahastalang.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseForgot
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.edtPassword
import kotlinx.android.synthetic.main.activity_verifikasi_password.*
import kotlinx.android.synthetic.main.activity_verifikasi_password.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifikasiPasswordActivity : AppCompatActivity() {
    lateinit var email :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasi_password)
        email = SharedPrefManager.getInstance(applicationContext).dataTemp.toString()
        btnResetPassword.setOnClickListener {
            if(txtToken.text.isEmpty()){
                txtToken.error = "isi Token"
                txtToken.requestFocus()
                return@setOnClickListener
            }
            if(txtPasswordbaru.text.isEmpty()){
                txtPasswordbaru.error = "isi Password Bru"
                txtPasswordbaru.requestFocus()
                return@setOnClickListener
            }
            if(txtUlangiPasswordbaru.text.isEmpty()){
                txtUlangiPasswordbaru.error = "isi Konfirmasi Passsword Baru"
                txtUlangiPasswordbaru.requestFocus()
                return@setOnClickListener
            }
            if(txtPasswordbaru.text.toString().length <= 7 ){
                txtPasswordbaru.error = "password harus 8 karakter atau lebih "
                txtPasswordbaru.requestFocus()
                return@setOnClickListener
            }
            if(txtUlangiPasswordbaru.text.toString().trim() != txtPasswordbaru.text.toString().trim()){
                txtUlangiPasswordbaru.error = "isi Konfirmasi Passsword Baru tidak sesuai"
                txtUlangiPasswordbaru.requestFocus()
                return@setOnClickListener
            }

            resetPassword()
        }

    }

    private fun resetPassword() {
        ApiService.instance.forgotPW(email,txtToken.text.toString(),txtPasswordbaru.text.toString(),txtUlangiPasswordbaru.text.toString()).enqueue(object : Callback<ResponseForgot> {
            override fun onFailure(call: Call<ResponseForgot>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
            override fun onResponse(
                    call: Call<ResponseForgot>,
                    response: Response<ResponseForgot>
            ) {
                val t = response.body()!!
                if (response.isSuccessful) {
//                    SharedPrefManager.getInstance(applicationContext).saveDataTemp(edtPassword.text.toString())
//
                    val intent = Intent (applicationContext,LoginActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            }

        })
    }
}
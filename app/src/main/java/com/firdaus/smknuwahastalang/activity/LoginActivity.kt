
package com.firdaus.smknuwahastalang.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseLogin
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtForgotPassword.setOnClickListener {
            val intent = Intent (applicationContext,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {

            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if(email.isEmpty()){
                edtEmail.error = "Email required"
                edtEmail.requestFocus()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                edtPassword.error = "Password required"
                edtPassword.requestFocus()
                return@setOnClickListener
            }

            ApiService.instance.Login(email, password).enqueue(object : Callback<ResponseLogin> {
                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                    if (response.body()?.status!!) {

                        if (response.body()?.data!!.rule == 3){
                            SharedPrefManager.getInstance(applicationContext)
                                    .saveUser(response.body()?.data!!)
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            Toast.makeText(
                                    applicationContext,
                                    response.body()?.message,
                                    Toast.LENGTH_LONG
                            ).show()
                        }
                        else if (response.body()?.data!!.rule == 2){
                            SharedPrefManager.getInstance(applicationContext)
                                    .saveUser(response.body()?.data!!)
                            val intent = Intent(applicationContext, com.firdaus.smknuwahastalang.activityguru.MainActivity::class.java)
                            intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            Toast.makeText(
                                    applicationContext,
                                    response.body()?.message,
                                    Toast.LENGTH_LONG
                            ).show()
                        }
                        else{
                            Toast.makeText(
                                    applicationContext,
                                    "Tidak Memiliki akses",
                                    Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            applicationContext,
                            response.body()?.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
            })

        }
    }
    override fun onStart() {
        super.onStart()
        if(SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
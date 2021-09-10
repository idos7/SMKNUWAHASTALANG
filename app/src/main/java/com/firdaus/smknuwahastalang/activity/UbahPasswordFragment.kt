package com.firdaus.smknuwahastalang.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseLogin
import com.firdaus.smknuwahastalang.data.ResponseUbahPassword
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UbahPasswordFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_ubah_password, container, false)
        val btnUbahPassword: CardView = view.findViewById(R.id.btnUbahPassword)
        val txtPwLama: EditText = view.findViewById(R.id.txtPwLama)
        val txtPasswordbaru: EditText = view.findViewById(R.id.txtPasswordbaru)
        val txtUlangiPasswordbaru: EditText = view.findViewById(R.id.txtUlangiPasswordbaru)

        btnUbahPassword.setOnClickListener {
            val lama = txtPwLama.text.toString().trim()
            val baru = txtPasswordbaru.text.toString().trim()
            val ulang = txtUlangiPasswordbaru.text.toString().trim()
            val id = SharedPrefManager.getInstance(requireContext()).data.id

            if(lama.isEmpty()){
                txtPwLama.error = "Isi Password Lama"
                txtPwLama.requestFocus()
                return@setOnClickListener
            }
            if(baru.isEmpty()){
                txtPasswordbaru.error = "Isi Password Baru"
                txtPasswordbaru.requestFocus()
                return@setOnClickListener
            }
            if(ulang.isEmpty()){
                txtUlangiPasswordbaru.error = "Ulamgi Password Lama"
                txtUlangiPasswordbaru.requestFocus()
                return@setOnClickListener
            }
            if(ulang != baru){
                txtUlangiPasswordbaru.error = "Ulangi Password Baru Tidak Sesuai"
                txtUlangiPasswordbaru.requestFocus()
                return@setOnClickListener
            }
            if(baru.length <=  5){
                txtPasswordbaru.error = "Minimal 6 Karakter"
                txtPasswordbaru.requestFocus()
                return@setOnClickListener
            }

            ApiService.instance.UbahPassword(id, baru, lama).enqueue(object: Callback<ResponseUbahPassword> {
                override fun onFailure(call: Call<ResponseUbahPassword>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<ResponseUbahPassword>, response: Response<ResponseUbahPassword>) {
                    txtPasswordbaru.text.clear()
                    txtPwLama.text.clear()
                    txtUlangiPasswordbaru.text.clear()
                    if(response.body()?.status!!){
                        Toast.makeText(activity, response.body()?.message, Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(activity, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                }
            })

        }

        return view
    }
}
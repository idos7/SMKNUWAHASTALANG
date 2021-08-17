package com.firdaus.smknuwahastalang.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseProfil
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentDetailSiswa : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_siswa, container, false)
        val daataNis : String = SharedPrefManager.getInstance(requireContext()).dataTemp.toString()
        val nama : TextView = view.findViewById(R.id.txtNama)
        val kelas : TextView = view.findViewById(R.id.txtKelas)
        val ttl : TextView = view.findViewById(R.id.txtTTL)
        val jk : TextView = view.findViewById(R.id.txtJk)
        val alamat : TextView = view.findViewById(R.id.txtAlamat)
        val agama : TextView = view.findViewById(R.id.txtAgama)

        ApiService.instance.Profil(daataNis).enqueue(object : Callback<ResponseProfil> {
            override fun onFailure(call: Call<ResponseProfil>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("guru", t.toString())
            }

            override fun onResponse(
                    call: Call<ResponseProfil>,
                    response: Response<ResponseProfil>
            ) {
                if (response.isSuccessful) {
                    val listdata = response.body()!!.data
                    Log.e("guru", listdata.nama)
                    nama.text = ":${ listdata.nama }"
                    kelas.text = ":${listdata.kelas} ${listdata.jurusan}"
                    ttl.text = ":${ listdata.tempat_lahir } ,${ listdata.tanggal_lahir }"
                    jk.text = ":${ listdata.gender }"
                    alamat.text = ":${ listdata.alamat }"
                    agama.text = ":${ listdata.agama }"
                }

            }
        })
        return view
    }


}
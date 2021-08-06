package com.firdaus.smknuwahastalang.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseListDataNilai
import com.firdaus.smknuwahastalang.data.ResponseListJadwal
import com.firdaus.smknuwahastalang.data.ResponseProfil
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.fragment_jadwal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NilaiFragment : Fragment() {
//    private lateinit var adapterNilai: AdapterNilai
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nilai, container, false)
//        var listDataNilai = view.findViewById<RecyclerView>(R.id.listDataNilai)
//        val txthari = view.findViewById<TextView>(R.id.txtHari)
//        val txtkelas = view.findViewById<TextView>(R.id.txtKelas)
//        adapterNilai = AdapterNilai(arrayListOf())
//        listDataNilai.adapter = adapterNilai

        return view
    }
//    override fun onStart(){
//        super.onStart()
//        getNilai()
//    }
//
//    private fun getNilai(){
//        val daataNis : String = SharedPrefManager.getInstance(requireContext()).data.email
//        ApiService.instance.Profil(daataNis.toInt()).enqueue(object : Callback<ResponseProfil> {
//            override fun onFailure(call: Call<ResponseProfil>, t: Throwable) {
//                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
//                Log.e("guru", t.toString())
//            }
//
//            override fun onResponse(
//                    call: Call<ResponseProfil>,
//                    response: Response<ResponseProfil>
//            ) {
//                if (response.isSuccessful) {
//                    val listdata = response.body()!!.data
//                    Log.e("guru", listdata.toString())
//
//                    val kelas = listdata.kelas
//                    val nama_kelas = listdata.jurusan
//                    ApiService.instance.ListDataNilai(kelas, nama_kelas).enqueue(object : Callback<ResponseListDataNilai> {
//                        override fun onFailure(call: Call<ResponseListDataNilai>, t: Throwable) {
//                            Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
//                            Log.e("jadwal", t.toString())
//                        }
//
//                        override fun onResponse(call: Call<ResponseListDataNilai>, response: Response<ResponseListDataNilai>) {
//                            if (response.isSuccessful) {
//                                val listdata = response.body()!!.data
//                                txtHari.text = response.body()!!.hari
//
//                                txtKelas.text = response.body()!!.kelas
//                                adapterNilai.setData(listdata)
//                            }
//                        }
//                    })
//                }
//
//            }
//        })
//
//    }
}
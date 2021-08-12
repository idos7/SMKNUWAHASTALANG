package com.firdaus.smknuwahastalang.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseListDataGuru
import com.firdaus.smknuwahastalang.data.ResponseListDataSiswa
import com.firdaus.smknuwahastalang.data.ResponseListJadwal
import com.firdaus.smknuwahastalang.data.ResponseProfil
import com.firdaus.smknuwahastalang.fragmenguru.RiwayatJadwalGuruFragment
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.fragment_jadwal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JadwalSeluruhFragment : Fragment() {
    private lateinit var adapteJadwal: AdapterJadwal
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_jadwal_seluruh, container, false)
        var listJadwal = view.findViewById<RecyclerView>(R.id.listJadwal)
        val txthari = view.findViewById<TextView>(R.id.txtHari)
        val txtkelas = view.findViewById<TextView>(R.id.txtKelas)
        val cvJadwalSeluruh = view.findViewById<CardView>(R.id.cvJadwalSeluruh)
        adapteJadwal = AdapterJadwal(arrayListOf())
        listJadwal.adapter =adapteJadwal


        return view
    }
    override fun onStart(){
        super.onStart()
        getJadwal()
    }

    private fun getJadwal(){
        val daataNis : String = SharedPrefManager.getInstance(requireContext()).data.nisnip
        val hari :Int = SharedPrefManager.getInstance(requireContext()).datapilihjadwal.hari
        val nama_hari :String = SharedPrefManager.getInstance(requireContext()).datapilihjadwal.name_hari
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
                    Log.e("guru", listdata.toString())

                    val kelas = listdata.kelas
                    val nama_kelas = listdata.jurusan
//                    Log.e("jadwal", "$kelas $nama_kelas $hari $nama_hari")
                     ApiService.instance.jadwalSiswa(kelas ,nama_kelas, hari, nama_hari).enqueue(object : Callback<ResponseListJadwal> {
                        override fun onFailure(call: Call<ResponseListJadwal>, t: Throwable) {
                            Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                            Log.e("jadwal", t.toString())
                        }

                        override fun onResponse(call: Call<ResponseListJadwal>, response: Response<ResponseListJadwal>) {
                            if (response.isSuccessful) {
                                val listdata = response.body()!!.data
                                Log.e("jadwal", "$listdata")
                                txtHari.text = response.body()!!.hari
                                txtKelas.text = response.body()!!.kelas
                                adapteJadwal.setData(listdata)
                            }
//                            Toast.makeText(getActivity(), response.body()!!.message, Toast.LENGTH_LONG).show()

                        }
                    })
                }

            }
        })

    }

}

package com.firdaus.smknuwahastalang.fragmenguru

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseListJadwal
import com.firdaus.smknuwahastalang.data.ResponseProfil
import com.firdaus.smknuwahastalang.fragment.AdapterJadwal
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.fragment_jadwal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentJadwalMengajar : Fragment() {
    private lateinit var adapterJadwalMengajar: AdapterJadwalMengajar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_jadwal_mengajar, container, false)
        var listJadwal = view.findViewById<RecyclerView>(R.id.listJadwal)
        val txthari = view.findViewById<TextView>(R.id.txtHari)
        val txtkelas = view.findViewById<TextView>(R.id.txtKelas)
        val cvJadwalSeluruh: CardView = view.findViewById(R.id.cvJadwalSeluruh)
        adapterJadwalMengajar = AdapterJadwalMengajar(arrayListOf())
        listJadwal.adapter = adapterJadwalMengajar

        cvJadwalSeluruh.setOnClickListener { buka_JadwalSeluruh() }

        return view
    }

    private fun buka_JadwalSeluruh() {
        val fragment: Fragment = RiwayatJadwalGuruFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onStart() {
        super.onStart()
        getJadwalMenagajar()
    }

    private fun getJadwalMenagajar() {
        val datanip: String = SharedPrefManager.getInstance(requireContext()).data.name
    ApiService.instance.ListJadwalGuru(datanip)
        .enqueue(object : Callback<ResponseListJadwal> {
            override fun onFailure(call: Call<ResponseListJadwal>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("jadwal", t.toString())
            }

            override fun onResponse(
                call: Call<ResponseListJadwal>,
                response: Response<ResponseListJadwal>
            ) {
                if (response.isSuccessful) {
                    val listdata = response.body()!!.data
                    txtHari.text = response.body()!!.hari

                    adapterJadwalMengajar.setData(listdata)
                }
            }
        })
    }
}
package com.firdaus.smknuwahastalang.fragmenguru

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseListDataSiswa
import com.firdaus.smknuwahastalang.fragment.AdapterSiswa
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentInputAbsen : Fragment() {
    private lateinit var adapterInputAbsen: AdapterInputAbsen
    private lateinit var txtTanggal : TextView
    private lateinit var txtNamaKelas : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input_absen, container, false)
        var listsiswa = view.findViewById<RecyclerView>(R.id.ListDataSiswa)
        txtTanggal = view.findViewById(R.id.txtTanggal)
        txtNamaKelas = view.findViewById(R.id.txtNamaKelas)

        adapterInputAbsen = AdapterInputAbsen(arrayListOf())
        listsiswa.adapter =adapterInputAbsen
        return view
    }
    override fun onStart(){
        super.onStart()
        getDaftarSiswa()
    }
    private fun getDaftarSiswa(){
        ApiService.instance.ListAbsen(SharedPrefManager.getInstance(requireContext()).data.name).enqueue(object : Callback<ResponseListDataSiswa> {
            override fun onFailure(call: Call<ResponseListDataSiswa>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("siswa", t.toString())
            }
            override fun onResponse(call: Call<ResponseListDataSiswa>, response: Response<ResponseListDataSiswa>) {
                if (response.isSuccessful) {
                    val listdata = response.body()!!.data
                    txtTanggal.text = response.body()!!.tanggal
                    txtNamaKelas.text = response.body()!!.kelas
//                    Log.e("siswa", response.body()!!.kelas)
                    adapterInputAbsen.setData(listdata)
                }
            }
        })
    }
}
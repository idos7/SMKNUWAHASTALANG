package com.firdaus.smknuwahastalang.fragmenguru

import android.content.Intent
import android.os.Bundle
import android.os.health.SystemHealthManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseListDataSiswa
import com.firdaus.smknuwahastalang.data.ResponsePembelajaran
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.*


class InputMateriFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_input_materi, container, false)
        val btnKirim = view.findViewById<CardView>(R.id.btnkirim)
        val txtJudul = view.findViewById<EditText>(R.id.txtJudul)
        val txtKelas = view.findViewById<EditText>(R.id.txtKelas)
        val txtSMT = view.findViewById<EditText>(R.id.txtSMT)
        val txtFile = view.findViewById<EditText>(R.id.txtFile)
        btnKirim.setOnClickListener {
            var nama  =SharedPrefManager.getInstance(requireActivity()).data.name
            var judul = txtJudul.text.toString()
            var kelas = txtKelas.text.toString().trim()
            var semester  = txtSMT.text.toString()
            var file = txtFile.text.toString()
            simpan(nama,kelas.toInt(),semester,file,judul) }

        return view
    }

    private fun simpan(nama:String, kelas:Int,semester:String,file:String,judul:String) {
        ApiService.instance.inputMateri(nama,kelas,semester,file,judul).enqueue(object :
            Callback<ResponsePembelajaran> {
            override fun onFailure(call: Call<ResponsePembelajaran>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("siswa", t.toString())
            }
            override fun onResponse(call: Call<ResponsePembelajaran>, response: Response<ResponsePembelajaran>) {
                if (response.isSuccessful) {

                }
            }
        })
    }


}
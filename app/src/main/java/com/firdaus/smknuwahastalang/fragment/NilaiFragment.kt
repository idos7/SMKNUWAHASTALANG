package com.firdaus.smknuwahastalang.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.*
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.fragment_jadwal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NilaiFragment : Fragment() {

    lateinit var pilihSemester : AutoCompleteTextView
    lateinit var pilihKelas : AutoCompleteTextView
    private lateinit var adapterNilai: AdapterNilai

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_nilai, container, false)
        pilihSemester = view.findViewById(R.id.PilihSmt)
        pilihKelas = view.findViewById(R.id.PilihKelas)
        val cvTampil = view.findViewById<CardView>(R.id.cvTampil)
        var listDataNilai = view.findViewById<RecyclerView>(R.id.ListDataNilai)

        cvTampil.setOnClickListener { getNilai ()}
        adapterNilai = AdapterNilai(arrayListOf())
        listDataNilai.adapter =adapterNilai
        return view
    }

    private fun getNilai() {
        val pilihSmt :String = pilihSemester.text.toString()
        val pilihKelas :String = pilihKelas.text.toString()
        val daataNis : String = SharedPrefManager.getInstance(requireContext()).data.nisnip
        ApiService.instance.dataNilai(daataNis, pilihKelas, pilihSmt).enqueue(object : Callback<ResponseListDataNilai> {
            override fun onFailure(call: Call<ResponseListDataNilai>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("siswa", t.toString())
            }

            override fun onResponse(call: Call<ResponseListDataNilai>, response: Response<ResponseListDataNilai>) {
                if (response.isSuccessful) {
                    Log.e("siswa", "$pilihKelas, $pilihSmt $daataNis")
                    val listdata = response.body()!!.data
                    adapterNilai.setData(listdata)
                }
            }
        })

    }

    override fun onStart() {
        super.onStart()
        var dropdownSmt = mutableListOf("Semester 1","Semester 2")
        var dropdownKelas = mutableListOf("Kelas 10","Kelas 11", "Kelas 12")

        val adapterSmt =ArrayAdapter<String>(requireContext(), R.layout.dropdown_pilih_semester, dropdownSmt)
        val adapterKelas =ArrayAdapter<String>(requireContext(), R.layout.dropdown_pilih_kelas, dropdownKelas)

        pilihSemester.setAdapter(adapterSmt)
        pilihKelas.setAdapter(adapterKelas)

    }
}
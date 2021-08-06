package com.firdaus.smknuwahastalang.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.activity.MainActivity
import com.firdaus.smknuwahastalang.data.ResponseListDataGuru
import com.firdaus.smknuwahastalang.data.ResponseListDataSiswa
import com.firdaus.smknuwahastalang.network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuruFragment : Fragment() {
    private lateinit var adapterGuru: AdapterGuru
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_guru, container, false)
        var listguru = view.findViewById<RecyclerView>(R.id.ListDataGuru)
        adapterGuru = AdapterGuru(arrayListOf())
        listguru.adapter =adapterGuru
        return view
    }
    override fun onStart(){
        super.onStart()
        getGuru()

    }

    private fun getGuru(){
        ApiService.instance.ListDataGuru().enqueue(object : Callback<ResponseListDataGuru> {
            override fun onFailure(call: Call<ResponseListDataGuru>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("guru", t.toString())
            }

            override fun onResponse(call: Call<ResponseListDataGuru>, response: Response<ResponseListDataGuru>) {
                if (response.isSuccessful) {
                    val listdata = response.body()!!.data
                    adapterGuru.setData(listdata)
                }
            }
        })
    }
}
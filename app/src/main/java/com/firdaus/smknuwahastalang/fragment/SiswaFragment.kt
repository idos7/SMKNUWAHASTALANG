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
import com.firdaus.smknuwahastalang.data.ListDataSiswa
import com.firdaus.smknuwahastalang.data.ResponseListDataSiswa
import com.firdaus.smknuwahastalang.network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SiswaFragment : Fragment() {
    private lateinit var adapterSiswa: AdapterSiswa
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        var  mainActivity = activity as MainActivity
//        mainActivity.bn_main.setSelectedItemId(R.id.siswa_menu);
        val view = inflater.inflate(R.layout.fragment_siswa, container, false)
        var listsiswa = view.findViewById<RecyclerView>(R.id.ListDataSiswa)
        adapterSiswa = AdapterSiswa(arrayListOf())
        listsiswa.adapter =adapterSiswa
        return view
    }
    override fun onStart(){
        super.onStart()
        getSiswa()
    }

    private fun getSiswa(){
        ApiService.instance.ListDataSiswa().enqueue(object : Callback<ResponseListDataSiswa> {
            override fun onFailure(call: Call<ResponseListDataSiswa>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("siswa", t.toString())
            }

            override fun onResponse(call: Call<ResponseListDataSiswa>, response: Response<ResponseListDataSiswa>) {
                if (response.isSuccessful) {
                    val listdata = response.body()!!.data
                    adapterSiswa.setData(listdata)
                }
            }
        })
    }
}

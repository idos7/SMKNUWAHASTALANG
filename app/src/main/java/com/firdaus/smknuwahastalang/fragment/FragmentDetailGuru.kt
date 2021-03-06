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
import com.firdaus.smknuwahastalang.data.ResponseProfilGuru
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentDetailGuru : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_guru, container, false)
        val dataNip : String = SharedPrefManager.getInstance(requireContext()).dataTemp.toString()
        val namaguru : TextView = view.findViewById(R.id.txtNamaGuru)
        val nip : TextView = view.findViewById(R.id.txtNIP)
        val jabatan : TextView = view.findViewById(R.id.txtJabatan)
        val pendidikan : TextView = view.findViewById(R.id.txtPendidikan)
        val alamat : TextView = view.findViewById(R.id.txtAlamat)
        val agama : TextView = view.findViewById(R.id.txtAgama)

        ApiService.instance.DetailGuru(dataNip).enqueue(object :
            Callback<ResponseProfilGuru> {
            override fun onFailure(call: Call<ResponseProfilGuru>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("guru", t.toString())
            }

            override fun onResponse(
                call: Call<ResponseProfilGuru>,
                response: Response<ResponseProfilGuru>
            ) {
                if (response.isSuccessful) {
                    val listdata = response.body()!!.data
                    Log.e("guru", listdata.toString())
                    namaguru.text = ":${ listdata.nama }"
                    nip.text = ":${ listdata.nip }"
                    jabatan.text = ":${ listdata.jabatan }"
                    pendidikan.text = ":${listdata.pendidikan_terakhir}"
                    alamat.text = ":${ listdata.alamat }"
                    agama.text = ":${ listdata.agama }"
                }

            }
        })
        return view
    }
}
package com.firdaus.smknuwahastalang.fragmenguru

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ListDataSiswa
import com.firdaus.smknuwahastalang.data.ResponseAbsen
import com.firdaus.smknuwahastalang.data.ResponseListDataSiswa
import com.firdaus.smknuwahastalang.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdapterInputAbsen(
        val siswas: ArrayList<ListDataSiswa>
        ): RecyclerView.Adapter<AdapterInputAbsen.ViewHolder>() {
    lateinit var hadir: CardView
    lateinit var alfa: CardView
    lateinit var ijin: CardView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_input_absen, parent, false)

    )
    override fun getItemCount() = siswas.size

    override fun onBindViewHolder(holder: AdapterInputAbsen.ViewHolder, position: Int) {
        val data = siswas[position]
        val nis = data.nis
        ijin=  holder.cvIjin
        alfa= holder.cvAlfa
        hadir = holder.cvHadir
//        cek(nis)
        holder.cvHadir.setOnClickListener {
            hadir(holder.cvHadir, nis)
        }
        holder.cvIjin.setOnClickListener {
            ijin(holder.cvIjin, nis)
        }
        holder.cvAlfa.setOnClickListener {
            alfa(holder.cvAlfa, nis)
        }
        holder.textNama.text =  data.nama
    }

    private fun alfa(view: View, siswa:Int ) {
        val activity = view.context as AppCompatActivity
        ApiService.instance.InputAbsen("ALFA", siswa).enqueue(object : Callback<ResponseAbsen> {
            override fun onFailure(call: Call<ResponseAbsen>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                Log.e("siswa", t.toString())
            }
            override fun onResponse(call: Call<ResponseAbsen>, response: Response<ResponseAbsen>) {
                if (response.isSuccessful) {
                   Toast.makeText(activity,response.body()!!.message , Toast.LENGTH_LONG).show()
                    refresh(view)
                }
            }
        })
    }

    private fun ijin(view: View, siswa:Int ) {
        val activity = view.context as AppCompatActivity
        ApiService.instance.InputAbsen("IZIN", siswa).enqueue(object : Callback<ResponseAbsen> {
            override fun onFailure(call: Call<ResponseAbsen>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                Log.e("siswa", t.toString())
            }
            override fun onResponse(call: Call<ResponseAbsen>, response: Response<ResponseAbsen>) {
                if (response.isSuccessful) {
                    Toast.makeText(activity,response.body()!!.message , Toast.LENGTH_LONG).show()
                    refresh(view)
                }
            }
        })
    }

    private fun hadir(view: View, siswa:Int ) {
        val activity = view.context as AppCompatActivity
        ApiService.instance.InputAbsen("HADIR", siswa).enqueue(object : Callback<ResponseAbsen> {
            override fun onFailure(call: Call<ResponseAbsen>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                Log.e("siswa", t.toString())
            }
            override fun onResponse(call: Call<ResponseAbsen>, response: Response<ResponseAbsen>) {
                if (response.isSuccessful) {
                    Toast.makeText(activity,response.body()!!.message , Toast.LENGTH_LONG).show()
                    refresh(view)
                }
            }
        })
    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val imageSiswa = view.findViewById<ImageView>(R.id.ivfoto)
        val textNama = view.findViewById<TextView>(R.id.txtNama)
        val cvHadir = view.findViewById<CardView>(R.id.cvHadir)
        val cvIjin = view.findViewById<CardView>(R.id.cvIjin)
        val cvAlfa = view.findViewById<CardView>(R.id.cvAlfa)


    }
    private fun refresh(view: View) {
        val activity = view.context as AppCompatActivity
        val fragment: Fragment = FragmentInputAbsen()
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.disallowAddToBackStack()
        fragmentTransaction.commit()
    }

//    private fun cek( siswa:Int ) {
//        ApiService.instance.cekAbsen(siswa).enqueue(object : Callback<ResponseAbsen> {
//            override fun onFailure(call: Call<ResponseAbsen>, t: Throwable) {
////                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
//                Log.e("siswa", t.toString())
//            }
//            override fun onResponse(call: Call<ResponseAbsen>, response: Response<ResponseAbsen>) {
//                if (response.isSuccessful) {
//                    if (response.body()!!.keterangan =="HADIR"){
//                        hadir.setCardBackgroundColor(Color.TRANSPARENT)
//                        ijin.setVisibility(View.GONE)
//                        alfa.setVisibility(View.GONE)
//                        Log.e("siswa", response.body()!!.message.toString())
//                    }
//                }
//            }
//        })
//    }
    public fun setData(data: List<ListDataSiswa>){
        siswas.clear()
        siswas.addAll(data)
        notifyDataSetChanged()
    }

}
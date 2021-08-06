package com.firdaus.smknuwahastalang.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ListJadwal

class AdapterJadwal (
    val jadwals: ArrayList<ListJadwal>
    ): RecyclerView.Adapter<AdapterJadwal.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.adapter_jadwal, parent, false)

        )
        override fun getItemCount() = jadwals.size

        override fun onBindViewHolder(holder: AdapterJadwal.ViewHolder, position: Int) {
            val data = jadwals[position]
            holder.textWaktu.text = data.waktu
            holder.textMapel.text = data.nama_mapel

        }

        class ViewHolder(view : View): RecyclerView.ViewHolder(view){
            val textWaktu = view.findViewById<TextView>(R.id.txtWaktu)
            val textMapel = view.findViewById<TextView>(R.id.txtMapel)

        }
        public fun setData(data: List<ListJadwal>){
            jadwals.clear()
            jadwals.addAll(data)
            notifyDataSetChanged()
        }
}
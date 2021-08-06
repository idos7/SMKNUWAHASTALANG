package com.firdaus.smknuwahastalang.fragmenguru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ListJadwal

class AdapterJadwalMengajar (
    val jadwals: ArrayList<ListJadwal>
    ): RecyclerView.Adapter<AdapterJadwalMengajar.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.adapter_jadwal_mengajar, parent, false)

        )
        override fun getItemCount() = jadwals.size

        override fun onBindViewHolder(holder: AdapterJadwalMengajar.ViewHolder, position: Int) {
            val data = jadwals[position]
            holder.textWaktu.text = data.waktu
            holder.textNamaKelas.text = "${data.kelas} ${data.nama_kelas}"

        }

        class ViewHolder(view : View): RecyclerView.ViewHolder(view){
            val textWaktu = view.findViewById<TextView>(R.id.txtWaktu)
            val textNamaKelas = view.findViewById<TextView>(R.id.txtNamaKelas)

        }
        public fun setData(data: List<ListJadwal>){
            jadwals.clear()
            jadwals.addAll(data)
            notifyDataSetChanged()
        }
}
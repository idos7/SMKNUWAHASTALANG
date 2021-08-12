package com.firdaus.smknuwahastalang.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ListDataNilai
import com.firdaus.smknuwahastalang.data.ListDataSiswa

class AdapterNilai(
    val nilais: ArrayList<ListDataNilai>
): RecyclerView.Adapter<AdapterNilai.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_nilai, parent, false)

    )
    override fun getItemCount() = nilais.size

    override fun onBindViewHolder(holder: AdapterNilai.ViewHolder, position: Int) {
        val data = nilais[position]
        holder.txtMapel.text = data.nama_mapel
        holder.txtTugas.text = data.tugas.toString()
        holder.txtUts.text = data.uts.toString()
        holder.txtUas.text = data.uas.toString()
        holder.txtNilai.text = data.nilai_akhir.toString()

    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val txtMapel = view.findViewById<TextView>(R.id.txtMapel)
        val txtTugas = view.findViewById<TextView>(R.id.txtTugas)
        val txtUts = view.findViewById<TextView>(R.id.txtUTS)
        val txtUas = view.findViewById<TextView>(R.id.txtUAS)
        val txtNilai = view.findViewById<TextView>(R.id.txtNilai)

    }
    public fun setData(data: List<ListDataNilai>){
        nilais.clear()
        nilais.addAll(data)
        notifyDataSetChanged()
    }

}
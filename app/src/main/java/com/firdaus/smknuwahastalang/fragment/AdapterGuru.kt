package com.firdaus.smknuwahastalang.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ListDataGuru

class AdapterGuru (
    val gurus: ArrayList<ListDataGuru>
): RecyclerView.Adapter<AdapterGuru.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_guru, parent, false)

    )
    override fun getItemCount() = gurus.size

    override fun onBindViewHolder(holder: AdapterGuru.ViewHolder, position: Int) {
        val data = gurus[position]
        holder.textNama.text =  data.nama
        holder.textJabatan.text = "Jabatan                   : ${data.jabatan}"
        holder.textPendidikan.text ="Pendidikan terakhir     : ${data.pendidikan_terakhir}"

    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val imageSiswa = view.findViewById<ImageView>(R.id.ivfoto)
        val textNama = view.findViewById<TextView>(R.id.txtNama)
        val textJabatan = view.findViewById<TextView>(R.id.txtJabatan)
        val textPendidikan = view.findViewById<TextView>(R.id.txtPendidikan)

    }
    public fun setData(data: List<ListDataGuru>){
        gurus.clear()
        gurus.addAll(data)
        notifyDataSetChanged()
    }
}
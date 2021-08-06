package com.firdaus.smknuwahastalang.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ListDataSiswa

class AdapterSiswa(
        val siswas: ArrayList<ListDataSiswa>
        ): RecyclerView.Adapter<AdapterSiswa.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_siswa, parent, false)

    )
    override fun getItemCount() = siswas.size

    override fun onBindViewHolder(holder: AdapterSiswa.ViewHolder, position: Int) {
        val data = siswas[position]
        holder.textNama.text =  data.nama
        holder.textKelas.text = "Kelas          :${data.kelas}"
        holder.textJurusan.text ="Jurusan       :${data.jurusan}"

    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val imageSiswa = view.findViewById<ImageView>(R.id.ivfoto)
        val textNama = view.findViewById<TextView>(R.id.txtNama)
        val textKelas = view.findViewById<TextView>(R.id.txtKelas)
        val textJurusan = view.findViewById<TextView>(R.id.txtJurusan)

    }
    public fun setData(data: List<ListDataSiswa>){
        siswas.clear()
        siswas.addAll(data)
        notifyDataSetChanged()
    }

}
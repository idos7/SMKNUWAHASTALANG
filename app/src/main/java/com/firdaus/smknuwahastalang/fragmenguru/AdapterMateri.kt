package com.firdaus.smknuwahastalang.fragmenguru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ListDataSiswa
import com.firdaus.smknuwahastalang.storage.SharedPrefManager

class AdapterMateri
//    (
//        val siswas: ArrayList<ListDataSiswa>
//        ): RecyclerView.Adapter<AdapterMateri.ViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
//        LayoutInflater.from(parent.context)
//                .inflate(R.layout.adapter_siswa, parent, false)
//
//    )
//    override fun getItemCount() = siswas.size
//
//    override fun onBindViewHolder(holder: AdapterMateri.ViewHolder, position: Int) {
//        val data = siswas[position]
//        val nis =data.nis
//        holder.textNama.text =  data.nama
//        holder.textKelas.text = "Kelas          :${data.kelas}"
//        holder.textJurusan.text ="Jurusan       :${data.jurusan}"
//        holder.cv_DataSiswa.setOnClickListener{detailSiswa(holder.cv_DataSiswa, nis)}
//
//
//    }
//
//    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
//        val imageSiswa = view.findViewById<ImageView>(R.id.ivfoto)
//        val textNama = view.findViewById<TextView>(R.id.txtNama)
//        val textKelas = view.findViewById<TextView>(R.id.txtKelas)
//        val textJurusan = view.findViewById<TextView>(R.id.txtJurusan)
//        val cv_DataSiswa =  view.findViewById<CardView>(R.id.cv_DataSiswa)
//
//    }
//    fun detailSiswa(view: View, nis: String) {
//
//        val activity = view.context as AppCompatActivity
//        SharedPrefManager.getInstance(activity).saveDataTemp(nis)
//        val myFragment: Fragment = FragmentDetailSiswa()
//        activity.supportFragmentManager.beginTransaction().replace(R.id.fl_containerGuru, myFragment).addToBackStack(null).commit()
//    }
//
//        public fun setData(data: List<ListDataSiswa>){
//        siswas.clear()
//        siswas.addAll(data)
//        notifyDataSetChanged()
//    }
//
//}
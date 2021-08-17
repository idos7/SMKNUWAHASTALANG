package com.firdaus.smknuwahastalang.fragment

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
import com.firdaus.smknuwahastalang.data.ListDataGuru
import com.firdaus.smknuwahastalang.storage.SharedPrefManager

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
        val nip = data.nip
        holder.textNama.text =  data.nama
        holder.textJabatan.text = "Jabatan                   : ${data.jabatan}"
        holder.textPendidikan.text ="Pendidikan terakhir     : ${data.pendidikan_terakhir}"
        holder.cv_DataGuru.setOnClickListener{detailGuru(holder.cv_DataGuru, nip)}


    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val imageSiswa = view.findViewById<ImageView>(R.id.ivfoto)
        val textNama = view.findViewById<TextView>(R.id.txtNama)
        val textJabatan = view.findViewById<TextView>(R.id.txtJabatan)
        val textPendidikan = view.findViewById<TextView>(R.id.txtPendidikan)
        val cv_DataGuru =  view.findViewById<CardView>(R.id.cv_DataGuru)
    }

    fun detailGuru(view: View, nip: String) {

        val activity = view.context as AppCompatActivity
        SharedPrefManager.getInstance(activity).saveDataTemp(nip)
        val myFragment: Fragment = FragmentDetailGuru()
        activity.supportFragmentManager.beginTransaction().replace(R.id.fl_container, myFragment).addToBackStack(null).commit()
    }
    public fun setData(data: List<ListDataGuru>){
        gurus.clear()
        gurus.addAll(data)
        notifyDataSetChanged()
    }
}
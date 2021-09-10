package com.firdaus.smknuwahastalang.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseAbsen
import com.firdaus.smknuwahastalang.data.ResponseAbsenRekap
import com.firdaus.smknuwahastalang.data.ResponseProfil
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class AbsensiFragment : Fragment() {

    lateinit var pilihBulan : AutoCompleteTextView
    lateinit var Hadir : TextView
    lateinit var Izin : TextView
    lateinit var Alfa : TextView
    lateinit var Persentase : TextView


    lateinit var data : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data="cek"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_absensi, container, false)
        val calendarView = view.findViewById<CalendarView>(R.id.calendarView)
        Hadir = view.findViewById(R.id.valHadir)
        Izin = view.findViewById(R.id.valIzin)
        Alfa = view.findViewById(R.id.valAlfa)
        Persentase = view.findViewById(R.id.valPersentase)

        pilihBulan = view.findViewById(R.id.SemuaBulan)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val msg = " " + year + "-" + (month + 1) + "-" + dayOfMonth
//            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show()
            cekAbsen(calendarView, msg)
        }
        rekap("Semua Bulan")
        val btnTampil = view.findViewById<Button>(R.id.btnTampil)
        btnTampil.setOnClickListener { rekap(pilihBulan.text.toString()) }
        return view

    }
    private fun cekAbsen(view: View, tanggal: String) {
        val activity = view.context as AppCompatActivity
        val alertDialogBuilder = AlertDialog.Builder(activity)
        ApiService.instance.cekAbsen(SharedPrefManager.getInstance(requireContext()).data.nisnip, tanggal).enqueue(object : Callback<ResponseAbsen> {
            override fun onFailure(call: Call<ResponseAbsen>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("guru", t.toString())
            }

            override fun onResponse(
                call: Call<ResponseAbsen>,
                response: Response<ResponseAbsen>
            ) {
                if (response.isSuccessful) {
                    data = response.body()!!.data2
                    Log.e("guru", data)
                    show(view, tanggal)
                }

            }
        })
    }

    private fun rekap(bulan: String) {

        ApiService.instance.rekapabsen(SharedPrefManager.getInstance(requireContext()).data.nisnip, bulan )
                .enqueue(object : Callback<ResponseAbsenRekap> {
            override fun onFailure(call: Call<ResponseAbsenRekap>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("guru", t.toString())
            }

            override fun onResponse(
                    call: Call<ResponseAbsenRekap>,
                    response: Response<ResponseAbsenRekap>
            ) {
                if (response.isSuccessful) {
                    Log.e("rekap", "masuk")
                    Hadir.text = response.body()!!.data.hadir
                    Izin.text =response.body()!!.data.izin
                    Alfa.text = response.body()!!.data.alfa
                    Persentase.text = response.body()!!.data.persentase
                }
                else
                    Log.e("rekap", response.message())
            }
        })
    }

    private fun show(view: View, tanggal: String) {
        val activity = view.context as AppCompatActivity
        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setTitle("Absensi pada tanggal $tanggal")
        alertDialogBuilder.setMessage(" $data")
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
        alertDialogBuilder.setNegativeButton("Tutup") { dialog, which ->
            dialog.dismiss()
        }

        alertDialogBuilder.show()
    }
    override fun onStart() {
        super.onStart()
        var dropdownRekapAbsen = mutableListOf("Semua Bulan",
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember")

        val adapterRekapAbsen = ArrayAdapter<String>(requireContext(), R.layout.dropdown_pilih_rekapanabsen, dropdownRekapAbsen)

        pilihBulan.setAdapter(adapterRekapAbsen)


    }

}

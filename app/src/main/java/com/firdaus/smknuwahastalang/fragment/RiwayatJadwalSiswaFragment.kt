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
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.data.ResponseListJadwal
import com.firdaus.smknuwahastalang.data.ResponseProfil
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.fragment_jadwal.*
import kotlinx.android.synthetic.main.fragment_riwayat_jadwal_siswa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RiwayatJadwalSiswaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_riwayat_jadwal_siswa, container, false)
        val cvSenen = view.findViewById<CardView>(R.id.cvSenen)
        val cvSelasa = view.findViewById<CardView>(R.id.cvSelasa)
        val cvRabu = view.findViewById<CardView>(R.id.cvRabu)
        val cvKamis = view.findViewById<CardView>(R.id.cvKamis)
        val cvJumat = view.findViewById<CardView>(R.id.cvJumat)
        val cvSabtu= view.findViewById<CardView>(R.id.cvSabtu)

        cvSenen.setOnClickListener { Senin() }
        cvSelasa.setOnClickListener { Selasa() }
        cvRabu.setOnClickListener { Rabu() }
        cvKamis.setOnClickListener { Kamis() }
        cvJumat.setOnClickListener { Jumat() }
        cvSabtu.setOnClickListener { Sabtu() }


        return view
    }

    private fun Senin() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(1,"Senin")
        val fragment: Fragment = JadwalSeluruhFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Selasa() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(2,"Selasa")
        val fragment: Fragment = JadwalSeluruhFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Rabu() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(3,"Rabu")
        val fragment: Fragment = JadwalSeluruhFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun Kamis() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(4,"Kamis")
        val fragment: Fragment = JadwalSeluruhFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun Jumat() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(5,"Jumat")
        val fragment: Fragment = JadwalSeluruhFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun Sabtu() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(6,"Sabtu")
        val fragment: Fragment = JadwalSeluruhFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}




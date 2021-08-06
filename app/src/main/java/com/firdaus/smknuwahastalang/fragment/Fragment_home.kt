package com.firdaus.smknuwahastalang.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.activity.MainActivity
import com.firdaus.smknuwahastalang.data.DataLogin
import com.firdaus.smknuwahastalang.storage.SharedPrefManager


class Fragment_home : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val im_Profil: ImageView = view.findViewById(R.id.im_Profil)
        val cvJadwal: CardView = view.findViewById(R.id.cvJadwal)
        val cvAbsensi: CardView = view.findViewById(R.id.cvAbsensi)
        val cvNilai: CardView = view.findViewById(R.id.cvNilai)
        val cv_DataSiswa: CardView = view.findViewById(R.id.cv_DataSiswa)
        val cv_DataGuru: CardView = view.findViewById(R.id.cv_DataGuru)
        val txtNama: TextView = view.findViewById(R.id.txtNama)
        val dataNama : String = SharedPrefManager.getInstance(requireContext()).data.name

        txtNama.text = dataNama
        cvJadwal.setOnClickListener { buka_jadwal() }
        cvAbsensi.setOnClickListener { buka_absensi() }
        cvNilai.setOnClickListener { buka_nilai() }
        im_Profil.setOnClickListener { buka_profil() }
        cv_DataSiswa.setOnClickListener { buka_DataSiswa() }
        cv_DataGuru.setOnClickListener { buka_DataGuru() }

        var  mainActivity = activity as MainActivity
//        mainActivity.setBottomNavigationselected(R.id.home_menu)
        mainActivity.setBottomNavigationVisibility(View.VISIBLE)
        return view
    }

    private fun buka_profil() {
        val fragment: Fragment = FragmentProfil()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun buka_jadwal() {
        val fragment: Fragment = JadwalFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun buka_absensi() {
        val fragment: Fragment = AbsensiFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun buka_nilai() {
        val fragment: Fragment = NilaiFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun buka_DataSiswa() {
        val fragment: Fragment = SiswaFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun buka_DataGuru() {
        val fragment: Fragment = GuruFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
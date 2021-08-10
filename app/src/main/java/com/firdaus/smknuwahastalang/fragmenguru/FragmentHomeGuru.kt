package com.firdaus.smknuwahastalang.fragmenguru

import android.os.Bundle
import android.util.Log
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
import com.firdaus.smknuwahastalang.fragment.AbsensiFragment
import com.firdaus.smknuwahastalang.fragment.FragmentProfil
import com.firdaus.smknuwahastalang.fragment.JadwalFragment
import com.firdaus.smknuwahastalang.storage.SharedPrefManager


class FragmentHomeGuru : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_guru, container, false)
        val im_ProfilGuru: ImageView = view.findViewById(R.id.im_ProfilGuru)
        val cvInputAbsen: CardView = view.findViewById(R.id.cvInputAbsen)
        val cvJadwalMengajar: CardView = view.findViewById(R.id.cv_JadwalMengajar)
        val txtNama: TextView = view.findViewById(R.id.txtNamaGuru)
        val dataNamaGuru : String = SharedPrefManager.getInstance(requireContext()).data.name

        txtNama.text = dataNamaGuru
        im_ProfilGuru.setOnClickListener { buka_ProfilGuru() }
        cvInputAbsen.setOnClickListener { buka_InputAbsen() }
        cvJadwalMengajar.setOnClickListener { buka_JadwalMengajar() }
        return view
    }

    private fun buka_ProfilGuru() {
        val fragment: Fragment = FragmentProfilGuru()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun buka_InputAbsen() {
        val fragment: Fragment = FragmentInputAbsen()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun buka_JadwalMengajar() {
        val fragment: Fragment = FragmentJadwalMengajar()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
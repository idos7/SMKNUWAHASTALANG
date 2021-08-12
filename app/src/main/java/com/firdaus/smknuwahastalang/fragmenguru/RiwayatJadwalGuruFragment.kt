package com.firdaus.smknuwahastalang.fragmenguru

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.fragment.JadwalSeluruhFragment
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import kotlinx.android.synthetic.main.fragment_riwayat_jadwal_siswa.*

class RiwayatJadwalGuruFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_jadwal_mengajar_seluruh, container, false)
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
        val fragment: Fragment = FragmentJadwalMengajarSeluruh()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Selasa() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(2,"Selasa")
        val fragment: Fragment = FragmentJadwalMengajarSeluruh()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Rabu() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(3,"Rabu")
        val fragment: Fragment = FragmentJadwalMengajarSeluruh()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun Kamis() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(4,"Kamis")
        val fragment: Fragment = FragmentJadwalMengajarSeluruh()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun Jumat() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(5,"Jumat")
        val fragment: Fragment = FragmentJadwalMengajarSeluruh()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun Sabtu() {
        SharedPrefManager.getInstance(requireContext()).saveDatapilihjadwal(6,"Sabtu")
        val fragment: Fragment = FragmentJadwalMengajarSeluruh()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}

package com.firdaus.smknuwahastalang.fragmenguru

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.firdaus.smknuwahastalang.R
import kotlinx.android.synthetic.main.fragment_pembelajaran.*

class PembelajaranFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pembelajaran, container, false)
        val cvMateri = view.findViewById<CardView>(R.id.cvMateri)
        val cvUlangan = view.findViewById<CardView>(R.id.cvUlangan)
        val cvTugas = view.findViewById<CardView>(R.id.cvTugas)
        val tambahMateri = view.findViewById<ImageButton>(R.id.TambahMateri)
        val tambahUlangan = view.findViewById<ImageButton>(R.id.TambahUlangan)
        val tambahTugas = view.findViewById<ImageButton>(R.id.TambahTugas)

        tambahMateri.setOnClickListener { Tambahmateri() }
        tambahUlangan.setOnClickListener { Tambahulangan() }
        tambahTugas.setOnClickListener { Tambahtugas() }
        cvMateri.setOnClickListener { Materi() }
        cvUlangan.setOnClickListener { Ulangan() }
        cvTugas.setOnClickListener { Tugas() }


        return view
    }

    private fun Tambahtugas() {
        val fragment: Fragment = InputTugasFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Tambahulangan() {
        val fragment: Fragment = InputUlanganFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Tambahmateri() {
        val fragment: Fragment = InputMateriFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Tugas() {
        val fragment: Fragment = TugasFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Ulangan() {
        val fragment: Fragment = UlanganFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun Materi() {
        val fragment: Fragment = MateriFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_containerGuru, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}



package com.firdaus.smknuwahastalang.fragment

import android.content.Intent
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
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.activity.LoginActivity
import com.firdaus.smknuwahastalang.activity.MainActivity
import com.firdaus.smknuwahastalang.activity.UbahPasswordFragment
import com.firdaus.smknuwahastalang.data.ResponseListDataGuru
import com.firdaus.smknuwahastalang.data.ResponseProfil
import com.firdaus.smknuwahastalang.network.ApiService
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentProfil : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var  mainActivity = activity as MainActivity
        mainActivity.setBottomNavigationVisibility(View.GONE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profil, container, false)
        val cv_Logout : CardView = view.findViewById(R.id.cv_Logout)
        val cv_UbahPassword : CardView = view.findViewById(R.id.cv_UbahPassword)
        cv_Logout.setOnClickListener { logout() }
        cv_UbahPassword.setOnClickListener { UbahPassword() }

        val daataNis : String = SharedPrefManager.getInstance(requireContext()).data.nisnip
        val nama :TextView = view.findViewById(R.id.txtNama)
        val nis :TextView = view.findViewById(R.id.txtNIS)
        val nisn :TextView = view.findViewById(R.id.txtNISN)
        val kelas :TextView = view.findViewById(R.id.txtKelas)
        val ttl :TextView = view.findViewById(R.id.txtTTL)
        val jk :TextView = view.findViewById(R.id.txtJk)
        val alamat :TextView = view.findViewById(R.id.txtAlamat)
        val agama :TextView = view.findViewById(R.id.txtAgama)

        ApiService.instance.Profil(daataNis).enqueue(object : Callback<ResponseProfil> {
            override fun onFailure(call: Call<ResponseProfil>, t: Throwable) {
                Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()
                Log.e("guru", t.toString())
            }

            override fun onResponse(
                call: Call<ResponseProfil>,
                response: Response<ResponseProfil>
            ) {
                if (response.isSuccessful) {
                    val listdata = response.body()!!.data
                    Log.e("guru", listdata.nama)
                        nama.text = ":${ listdata.nama }"
                        nis.text = ":${ listdata.nis }"
                        nisn.text = ":${ listdata.nisn }"
                        kelas.text = ":${listdata.kelas} ${listdata.jurusan}"
                        ttl.text = ":${ listdata.tempat_lahir } ,${ listdata.tanggal_lahir }"
                        jk.text = ":${ listdata.gender }"
                        alamat.text = ":${ listdata.alamat }"
                        agama.text = ":${ listdata.agama }"
                }

            }
        })

        return view
    }
    fun logout() {
        SharedPrefManager.getInstance(requireActivity()).clear()
        val intent = Intent(getActivity(), LoginActivity::class.java)
        getActivity()?.startActivity(intent)
        getActivity()?.finish()

    }
    fun UbahPassword() {
        val fragment: Fragment = UbahPasswordFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }

}
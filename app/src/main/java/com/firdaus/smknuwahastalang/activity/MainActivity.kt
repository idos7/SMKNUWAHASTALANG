package com.firdaus.smknuwahastalang.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.fragment.*
import com.firdaus.smknuwahastalang.storage.SharedPrefManager
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!SharedPrefManager.getInstance(this).isLoggedIn) {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        // set default nya Home Fragment
        loadFragment(JadwalFragment())
        // inisialisasi BottomNavigaionView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bn_main)
        // listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    // method untuk load fragment yang sesuai
    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit()
            return true
        }
        return false
    }

    // method listener untuk logika pemilihan
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.jadwal_menu -> fragment = JadwalFragment()
            R.id.absensi_menu -> fragment = AbsensiFragment()
            R.id.nilai_menu -> fragment = NilaiFragment()
            R.id.siswa_menu -> fragment = SiswaFragment()
            R.id.guru_menu -> fragment = GuruFragment()
        }
        return loadFragment(fragment)
    }

    override fun onPointerCaptureChanged(hasCapture: Boolean) {}
    private fun logout() {
        val sgSharedPref = applicationContext.getSharedPreferences("sg_shared_pref", MODE_PRIVATE)
        sgSharedPref.edit().clear().commit()
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
    }
}
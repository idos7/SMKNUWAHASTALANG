package com.firdaus.smknuwahastalang.activityguru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.firdaus.smknuwahastalang.R
import com.firdaus.smknuwahastalang.activity.LoginActivity
import com.firdaus.smknuwahastalang.fragmenguru.FragmentHomeGuru
import com.firdaus.smknuwahastalang.fragmenguru.FragmentInputAbsen
import com.firdaus.smknuwahastalang.fragmenguru.FragmentJadwalMengajar
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        loadFragment(FragmentHomeGuru())
        // inisialisasi BottomNavigaionView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bn_mainguru)
        // listener pada saat item/menu bo ttomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_containerGuru, fragment).disallowAddToBackStack()
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.Home_Guru -> fragment = FragmentHomeGuru()
            R.id.Input_Absen -> fragment = FragmentInputAbsen()
            R.id.Jadwal_Mengajar -> fragment = FragmentJadwalMengajar()
        }
        return loadFragment(fragment)
    }

    override fun onPointerCaptureChanged(hasCapture: Boolean) {}
    private fun logout() {
        val sgSharedPref = applicationContext.getSharedPreferences("sg_shared_pref", MODE_PRIVATE)
        sgSharedPref.edit().clear().commit()
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
    }
    fun setBottomNavigationVisibility(visibility: Int) {
        // get the reference of the bottomNavigationView and set the visibility.
        bn_main.visibility = visibility
    }
}
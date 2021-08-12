package com.firdaus.smknuwahastalang.storage

import android.content.Context
import com.firdaus.smknuwahastalang.data.DataLogin
import com.firdaus.smknuwahastalang.data.DataPilihhari
import java.nio.channels.Pipe

class SharedPrefManager private constructor(private val mCtx: Context){
    val isLoggedIn: Boolean
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getInt("id", -1) != -1
        }

    val data: DataLogin
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return DataLogin(
                    sharedPreferences.getInt("id", -1),
                    sharedPreferences.getString("name", null)!!,
                    sharedPreferences.getString("email", null)!!,
                    sharedPreferences.getString("nisnip", null)!!,
                    sharedPreferences.getInt("rule", -1)!!

            )
        }

    fun saveUser(data : DataLogin) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("id", data.id)
        editor.putString("name", data.name)
        editor.putString("email", data.email)
        editor.putInt("rule", data.rule)
        editor.putString("nisnip", data.nisnip)
        editor.apply()
    }
    fun saveDataTemp(data : String) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("data", data)
        editor.apply()

    }
    fun saveDatapilihjadwal(hari :Int, nama_hari: String) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("nama_hari", nama_hari)
        editor.putInt("hari", hari)
        editor.apply()

    }

    val dataTemp: String?
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getString("data",null)
        }
    val datapilihjadwal: DataPilihhari
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return DataPilihhari(
                sharedPreferences.getInt("hari", -1),
                sharedPreferences.getString("nama_hari", null)!!

            )
        }
    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private val SHARED_PREF_NAME = "my_shared_preff"
        private var mInstance: SharedPrefManager? = null
        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }
}
package com.example.alik

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.TextView
import com.example.alik.appCoustomSitting.USER_KEY
import com.example.alik.appCoustomSitting.cToast
import com.example.alik.models.MyRecycleAdapter1
import com.example.alik.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_manger.*

class MangerActivity : AppCompatActivity() {
    var serviceCompany: ArrayList<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manger)
        var le=intent.getStringExtra(USER_KEY)
        castingJson(le)
        if(serviceCompany==null){
            finish()
        }
//        serviceRecycle = findViewById<RecyclerView>(R.id.serviceRecycle)
        mangerRecycle.layoutManager = LinearLayoutManager(this)
        val recAdapter=MyRecycleAdapter1(
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
            serviceCompany!!,
            mangerRecycle,this
        )
        mangerRecycle.adapter = recAdapter
    }
    fun castingJson(json: String) {
        serviceCompany = try {
            Gson().fromJson<ArrayList<User>>(json, object : TypeToken<ArrayList<User>>() {}.type)
        } catch (ex: java.lang.Exception) {
            null
        }
//        serviceCompany1 = try {
//            Gson().fromJson<List<Package>>(json, object : TypeToken<List<Package>>() {}.type)
//        } catch (ex: java.lang.Exception) {
//            null
//        }
//        if (serviceCompany != null) {
//
//        } else {
//            cToast(this, "خروج به دلیل " + "دریافت اطلاعات نامعتبر")
//            finish()
//        }
    }
}

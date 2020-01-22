package com.example.alik

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anychart.enums.HoverMode
import com.anychart.enums.TooltipPositionMode
import android.R.attr.animation
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.anychart.AnyChart.column
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.enums.Anchor
import com.anychart.enums.Position
import com.example.alik.appCoustomSitting.*
import com.example.alik.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_user_panel.*
import org.json.JSONObject


class UserPanelActivity : AppCompatActivity() {

    var users1: User?=null

    var serviceCompany: Package? = null

    fun finishActivitys(){
        finish()
    }

    override fun onBackPressed() {
        val intent= Intent(this,MainPanelActivity::class.java)
        intent.putExtra(USER_KEY,Gson().toJson(users1))
        startActivity(intent)
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_panel)
        castingJson(intent.getStringExtra(PROFILE_KEY))
        if (serviceCompany==null) {
            finish()
        }
        val response=intent.getStringExtra(SERVICE_KEY)
        val exes=try {
            Gson().fromJson<List<Sale>>(response.toString(), object : TypeToken<List<Sale>>() {}.type)
        } catch (ex: java.lang.Exception) {
            null
        }
//        else {
//            computerUnit = serviceCompany!!.computerunit
//
//        }

        val st=intent.getStringExtra(USER_KEY)
        users1=try{
            Gson().fromJson<User>(st, User::class.java)}catch (ex: java.lang.Exception){null}
//        if(users1==null)
//            cToast(this,"user not found")

        viewPage.adapter=PanelAdapter(supportFragmentManager,this)
        viewPage.currentItem=1

//        isEditCheck.setOnClickListener {
//            if(isEditCheck.isChecked){
//                linearEditing.visibility=View.VISIBLE
//            }else{
//                linearEditing.visibility=View.GONE
//            }
//        }
//        accepteUserPanelButton.setOnClickListener {
//            if(isEditCheck.isChecked){
//                createMapPost()
//            }else{
//                onBackPressed()
//            }
//        }
////        startdateTexts.text=
//        createChart()
    }





    fun castingJson(json: String) {
        serviceCompany = try {
            Gson().fromJson<List<Package>>(json, object : TypeToken<List<Package>>() {}.type)[0]
        } catch (ex: java.lang.Exception) {
            null
        }
        if (serviceCompany != null) {
//            cToast(this, serviceCompany!!.idCompany.toString())
        } else {
            finish()
        }
    }
}

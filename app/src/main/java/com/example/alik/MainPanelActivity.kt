package com.example.alik

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.example.alik.appCoustomSitting.*
import com.example.alik.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main_panel.*
import org.json.JSONObject
import java.lang.Exception

class MainPanelActivity : AppCompatActivity() {

var users1: User?=null
    override protected fun onStop() {
        super.onStop()
        MySingleton.getInstance(this).requestQueue.cancelAll(CANCELTAG)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_panel)
        val st=intent.getStringExtra(USER_KEY)
        users1=try{Gson().fromJson<User>(st,User::class.java)}catch (ex:Exception){null}
        if(users1==null){
            progressLinner.visibility=View.GONE
            cToast(this,"خطا در برنامه")
        }
        serviceLinear.setOnClickListener {
            progressLinner.visibility= View.VISIBLE
//            createRequest("service",TypeCast.SERVICE_COMPANY,Request.Method.GET,null)

            createRequest("modem",TypeCast.MODEM_COMPANY,Request.Method.GET,null)
        }
        sizeLinear.setOnClickListener {
            if (users1 != null) {
                checkExistsforSize()
            }else{
                finish()
            }
        }
        panelLinear.setOnClickListener {
            if (users1 != null) {
                checkExistsforPanel()
            }else{
                finish()
            }

        }
        exitPanel.setOnClickListener {
            finish()
            System.exit(0)
        }
        userexitLinear.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            writtingToFile("")
            finish()
        }
        supportLinear.setOnClickListener {
            progressLinner.visibility= View.VISIBLE
            val intent=Intent(this,UserSittingActivity::class.java)
            intent.putExtra(USER_KEY,Gson().toJson(users1))
            startActivity(intent)
            finish()
        }

    }
    private fun checkExistsforPanel(){

        if (users1 != null) {
            progressLinner.visibility= View.VISIBLE
//            createPanelRequest1("""users?id=${users1!!.id}""", TypeCast.USER,Request.Method.GET,null)
            createPanelRequest2(TypeCast.USER,"""sale?iduser=${users1!!.id}""", TypeCast.USER,Request.Method.GET,null)
        }
    }
    private fun checkExistsforSize(){

        if (users1 != null) {
            progressLinner.visibility= View.VISIBLE
//            createSizeRequest1("""ex/${users1!!.id}""", TypeCast.USER,Request.Method.GET,null)

            createPanelRequest2(TypeCast.SIZE_COMPANY,"""sale?iduser=${users1!!.id}""", TypeCast.USER,Request.Method.GET,null)
        }
    }

    private  fun createSizeRequest1(queryUrl:String,typeCast:TypeCast,method:Int,values:HashMap<String,String>?=null,valueIntent:String=""){
        val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}
        if(method==Request.Method.POST){
            val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}
            val request=JsonObjectRequest(method,(baseAppUrl+queryUrl),jsonVal,
                Response.Listener { response ->
                    val exes=Gson().fromJson<CheckServiceExists>(response.toString(),CheckServiceExists::class.java)
                    if(exes.existsservice){
                        if (users1 != null) {
                            progressLinner.visibility= View.VISIBLE
                            createRequest("""size/${users1!!.id}""", TypeCast.SIZE_COMPANY,Request.Method.GET,null)
                        }
                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"لطفاً ابتدا سرویس مورد نظر خود را انتخاب نمایید.")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)
        }else{
            val request=JsonObjectRequest(method,(baseAppUrl+queryUrl),null,
                Response.Listener { response ->
                    val exes=Gson().fromJson<CheckServiceExists>(response.toString(),CheckServiceExists::class.java)

                    if(exes.existsservice){
                        if (users1 != null) {
                            progressLinner.visibility= View.VISIBLE
                            createRequest("""size/${users1!!.id}""", TypeCast.SIZE_COMPANY,Request.Method.GET,null)
                        }
                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"لطفاً ابتدا سرویس مورد نظر خود را انتخاب نمایید.")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)
        }
    }

    private  fun createPanelRequest1(queryUrl:String,typeCast:TypeCast,method:Int,values:HashMap<String,String>?=null,valueIntent:String=""){
        val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}
        if(method==Request.Method.POST){
            val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}
            val request=JsonObjectRequest(method,(baseAppUrl+queryUrl),jsonVal,
                Response.Listener { response ->
                    val exes=Gson().fromJson<CheckServiceExists>(response.toString(),CheckServiceExists::class.java)
                    if(exes.existsservice){
                        if (users1 != null) {
                            progressLinner.visibility= View.VISIBLE
                            createRequest("""profile/${users1!!.id}""", TypeCast.USER,Request.Method.GET,null)
                        }
                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"لطفاً ابتدا سرویس مورد نظر خود را انتخاب نمایید.")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)
        }else{
            val request=JsonObjectRequest(method,(baseAppUrl+queryUrl),null,
                Response.Listener { response ->
                    val exes=Gson().fromJson<CheckServiceExists>(response.toString(),CheckServiceExists::class.java)

                    if(exes.existsservice){
                        if (users1 != null) {
                            progressLinner.visibility= View.VISIBLE
                            createRequest("""profile/${users1!!.id}""", TypeCast.USER,Request.Method.GET,null)
                        }
                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"لطفاً ابتدا سرویس مورد نظر خود را انتخاب نمایید.")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)
        }
    }

    private  fun createPanelRequest2(type:TypeCast,queryUrl:String,typeCast:TypeCast,method:Int,values:HashMap<String,String>?=null,valueIntent:String=""){
//        val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}

            val request=JsonArrayRequest(method,(baseAppUrl+queryUrl),null,
                Response.Listener { response ->
                    val exes=try {
                        Gson().fromJson<List<Sale>>(response.toString(), object : TypeToken<List<Sale>>() {}.type)
                    } catch (ex: java.lang.Exception) {
                        null
                    }

                    if(exes!=null){
                        if(exes.size>0){
                            if (users1 != null) {
                                progressLinner.visibility= View.VISIBLE
                                if(type==TypeCast.SIZE_COMPANY){
                                    val intent=Intent(this,MySizeActivity::class.java)
                                    intent.putExtra(SIZE_KEY,response.toString())

                                    intent.putExtra(USER_KEY,Gson().toJson(users1))
                                    startActivity(intent)
                                    finish()
                                }else{
                                    createRequest("""package?id=${exes[exes.size-1].idpackage}""", type,Request.Method.GET,null,Gson().toJson(exes))
                                }
                            }
                        }else{
                            progressLinner.visibility=View.GONE
                            cToast(this,"لطفاً ابتدا سرویس مورد نظر خود را انتخاب نمایید.")
                        }

                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"لطفاً ابتدا سرویس مورد نظر خود را انتخاب نمایید.")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)

    }


    private  fun createRequest(queryUrl:String,typeCast:TypeCast,method:Int,values:HashMap<String,String>?=null,valueIntent:String=""){
        val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}
        if(method==Request.Method.POST){
            val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}
            val request=JsonObjectRequest(method,(baseAppUrl+queryUrl),jsonVal,
                Response.Listener { response ->
                    if (response.toString().length>=10){
                        when(typeCast){
                            TypeCast.MODEM_COMPANY->{

                                createRequest("package",TypeCast.SERVICE_COMPANY,Request.Method.GET,null)
                            }
                            TypeCast.SERVICE_COMPANY->{
                                val intent=Intent(this,MyServiceActivity::class.java)
                                intent.putExtra(SERVICE_KEY,response.toString())
                                startActivity(intent)
                                finish()
                            }
                            TypeCast.SIZE_COMPANY->{
                                val intent=Intent(this,MySizeActivity::class.java)
                                intent.putExtra(SIZE_KEY,response.toString())
                                startActivity(intent)
                                finish()
                            }
                            TypeCast.USER->{
                                val intent=Intent(this,UserPanelActivity::class.java)
                                intent.putExtra(PROFILE_KEY,response.toString())
//                                cToast(this,response.toString())
                                startActivity(intent)
                                finish()
                            }
                            else -> {
                                progressLinner.visibility=View.GONE
                                cToast(this,"خطا در برنامه")
                            }
                        }
                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"خطا در برقراری ارتباط")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)
        }else{
            val request=JsonArrayRequest(method,(baseAppUrl+queryUrl),null,
                Response.Listener { response ->
                    if (response.toString().length>=10){
                        when(typeCast){
                            TypeCast.MODEM_COMPANY->{

                                createRequest("package",TypeCast.SERVICE_COMPANY,Request.Method.GET,null,response.toString())
                            }
                            TypeCast.SERVICE_COMPANY->{
                                val intent=Intent(this,MyServiceActivity::class.java)
                                intent.putExtra(MODEM_KEY,valueIntent)
                                intent.putExtra(SERVICE_KEY,response.toString())
                                intent.putExtra(USER_KEY,Gson().toJson(users1))
                                Log.d("service",response.toString())

                                Log.d("modem",valueIntent)
                                startActivity(intent)
                                finish()
                            }
                            TypeCast.SIZE_COMPANY->{
                                val intent=Intent(this,MySizeActivity::class.java)
                                intent.putExtra(SIZE_KEY,response.toString())
                                intent.putExtra(USER_KEY,Gson().toJson(users1))

                                startActivity(intent)
                                finish()
                            }
                            TypeCast.USER->{
                                val intent=Intent(this,UserPanelActivity::class.java)
                                intent.putExtra(PROFILE_KEY,response.toString())
                                intent.putExtra(USER_KEY,Gson().toJson(users1))
                                intent.putExtra(SERVICE_KEY,valueIntent)
                                Log.d("query",response.toString())
                                Log.e("query",response.toString())
                                startActivity(intent)
                                finish()
                            }
                            else -> {
                                progressLinner.visibility=View.GONE
                                cToast(this,"خطا در برقراری ارتباط")
                            }
                        }
                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"خطا در برقراری ارتباط")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)
        }
    }





    private  fun createRequest1(queryUrl:String,typeCast:TypeCast,method:Int,values:HashMap<String,String>?=null,valueIntent:String=""){
        val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}
        if(method==Request.Method.POST){
            val jsonVal=try{JSONObject(values.toString())}catch (ex:Exception){null}
            val request=JsonObjectRequest(method,(baseAppUrl+queryUrl),jsonVal,
                Response.Listener { response ->
                    if (response.toString().length>=10){
                        when(typeCast){
                            TypeCast.MODEM_COMPANY->{

                                createRequest("package",TypeCast.SERVICE_COMPANY,Request.Method.GET,null)
                            }
                            TypeCast.SERVICE_COMPANY->{
                                val intent=Intent(this,MyServiceActivity::class.java)
                                intent.putExtra(SERVICE_KEY,response.toString())
                                startActivity(intent)
                                finish()
                            }
                            TypeCast.SIZE_COMPANY->{
                                val intent=Intent(this,MySizeActivity::class.java)
                                intent.putExtra(SIZE_KEY,response.toString())
                                startActivity(intent)
                                finish()
                            }
                            TypeCast.USER->{
                                val intent=Intent(this,UserPanelActivity::class.java)
                                intent.putExtra(PROFILE_KEY,response.toString())
//                                cToast(this,response.toString())
                                startActivity(intent)
                                finish()
                            }
                            else -> {
                                progressLinner.visibility=View.GONE
                                cToast(this,"خطا در برنامه")
                            }
                        }
                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"خطا در برقراری ارتباط")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)
        }else{
            val request=JsonArrayRequest(method,(baseAppUrl+queryUrl),null,
                Response.Listener { response ->
                    if (response.toString().length>=10){
                        when(typeCast){
                            TypeCast.MODEM_COMPANY->{

                                createRequest("package",TypeCast.SERVICE_COMPANY,Request.Method.GET,null,response.toString())
                            }
                            TypeCast.SERVICE_COMPANY->{
                                val intent=Intent(this,MyServiceActivity::class.java)
                                intent.putExtra(MODEM_KEY,valueIntent)
                                intent.putExtra(SERVICE_KEY,response.toString())
                                intent.putExtra(USER_KEY,Gson().toJson(users1))
                                Log.d("service",response.toString())

                                Log.d("modem",valueIntent)
                                startActivity(intent)
                                finish()
                            }
                            TypeCast.SIZE_COMPANY->{
                                val intent=Intent(this,MySizeActivity::class.java)
                                intent.putExtra(SIZE_KEY,response.toString())
                                intent.putExtra(USER_KEY,Gson().toJson(users1))
                                startActivity(intent)
                                finish()
                            }
                            TypeCast.USER->{
                                val intent=Intent(this,UserPanelActivity::class.java)
                                intent.putExtra(PROFILE_KEY,response.toString())
                                intent.putExtra(USER_KEY,Gson().toJson(users1))
                                Log.d("query",response.toString())
                                Log.e("query",response.toString())
                                startActivity(intent)
                                finish()
                            }
                            else -> {
                                progressLinner.visibility=View.GONE
                                cToast(this,"خطا در برقراری ارتباط")
                            }
                        }
                    }else{
                        progressLinner.visibility=View.GONE
                        cToast(this,"خطا در برقراری ارتباط")
                    }

                },
                Response.ErrorListener { error ->
                    progressLinner.visibility=View.GONE
                    cToast(this,"خطا در برقراری ارتباط")
                }

            )
            MySingleton.getInstance(this).requestQueue.add(request)
        }
    }
    fun writtingToFile(jsonObject: String){
//        cToast(this,jsonObject)
        val sharred: SharedPreferences =applicationContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor=sharred.edit()
        editor.putString(USER_KEY,jsonObject)
//        editor.putString("password",password.text.toString())
//        editor.putString("userName",user.text.toString())
//        editor.putString("phoneNum",phoneNumber.text.toString())
        editor.apply()

    }









    fun castingJson(json:String,typeCast:TypeCast){
        when(typeCast){
            TypeCast.SERVICE_COMPANY->{

            }
            TypeCast.SIZE_COMPANY->{}
            else -> {

            }
        }
    }
}


package com.example.alik

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.alik.appCoustomSitting.*
import com.example.alik.models.CostX
import com.example.alik.models.SizeCompany2
import com.example.alik.models.User
import com.example.alik.models.Users1
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_my_size.*
import org.json.JSONObject

class MySizeActivity : AppCompatActivity() {
    private var sizeCompany:CostX?=null
    private var users1: User?=null
    override fun onBackPressed() {
        val intent=Intent(this,MainPanelActivity::class.java)
        intent.putExtra(USER_KEY,Gson().toJson(users1))
        startActivity(intent)
        finish()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_size)

        val st2=intent.getStringExtra(USER_KEY)
        users1=try{Gson().fromJson<User>(st2,User::class.java)}catch (ex: java.lang.Exception){null}
        if(users1==null){
            cToast(this, "خروج به دلیل "+"دریافت اطلاعات نامعتبر")
            finish()
        }
//        val st=intent.getStringExtra(SIZE_KEY)
//        if(st==null){
//            cToast(this, "خروج به دلیل "+"دریافت اطلاعات نامعتبر")
//            finish()
//        }
        castingJson()

//        if (sizeCompany==null){
//            cToast(this, "خروج به دلیل "+"دریافت اطلاعات نامعتبر")
//            finish()
//        }
        sizeCostText.text="هر "+sizeCompany!!.numLimit.toString()+" گیگابایت "+(sizeCompany!!.numCost*sizeCompany!!.unitCost).toString()+" ریال"
        sizeSendButton.setOnClickListener {
            progressLinnersize.visibility= View.VISIBLE
            val map=HashMap<String,String>();
            map.put("idUser",users1!!.id.toString())
            map.put("limit",numCostText.text.toString())
//            https://m1202.herokuapp.com/trafic
            createPostRequest("trafic",this,map)
        }
    }
    fun castingJson(){
        sizeCompany=CostX(3, 199000,4, 241
       ,  10
       , 2
        ,"ماه"
        ,2
        ,1
        ,1
        ,128
        ,-1000
        ,2
        ,100000
        ,3
        ,1)
//        if(sizeCompany!=null){
////            cToast(this,sizeCompany!!.nameUnitPeriod)
//        }else{
//            cToast(this, "خروج به دلیل "+"دریافت اطلاعات نامعتبر")
//            finish()
//        }
    }
    fun createPostRequest(queryUrl: String, context: Context, values: HashMap<String, String>) {

        val jsonVal = try {
            JSONObject(values.toString())
        } catch (ex: java.lang.Exception) {
            null
        }
        val request = JsonObjectRequest(
            Request.Method.POST, (baseAppUrl + queryUrl), jsonVal,
            Response.Listener { response ->
                //                castingJson(response.toString(),typeCast)
                val intent = Intent(this, MainPanelActivity::class.java)
                intent.putExtra("RESULT", response.toString())
                intent.putExtra(USER_KEY,Gson().toJson(users1))
                startActivity(intent)
                finish()
            },
            Response.ErrorListener { error ->
                cToast(this,"خطا در برقراری ارتباط")
                progressLinnersize.visibility=View.GONE
            }

        )
        MySingleton.getInstance(context).requestQueue.add(request)
    }
}

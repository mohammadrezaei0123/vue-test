package com.example.alik

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.alik.appCoustomSitting.MySingleton
import com.example.alik.appCoustomSitting.USER_KEY
import com.example.alik.appCoustomSitting.baseAppUrl
import com.example.alik.appCoustomSitting.cToast
import com.example.alik.models.ModemAdapter1
import com.example.alik.models.User
import com.example.alik.models.Users1
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_pruch_basket.*
import org.json.JSONObject

class PruchBasketActivity : AppCompatActivity() {

    var users1:User?=null
    var serviceId: String = ""
    override fun onBackPressed() {
        val intent=Intent(this,MainPanelActivity::class.java)
        intent.putExtra(USER_KEY,Gson().toJson(users1))
        startActivity(intent)
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pruch_basket)
        val moneyText=intent.getStringExtra("title" +
                "")
        if (moneyText!=null){
            costBasket.text=moneyText
        }
        serviceId=intent.getStringExtra("idService")
        val st=intent.getStringExtra(USER_KEY)
        serviceTextChoose.text=intent.getStringExtra("stringServ")
        users1=try{Gson().fromJson<User>(st, User::class.java)}catch (ex: java.lang.Exception){null}
        if(users1==null){
            cToast(this, "خروج به دلیل "+"دریافت اطلاعات نامعتبر")
            finish()
        }
//        val arr=intent.getStringArrayListExtra("listUrls")
//        if(arr==null){cToast(this, "خروج به دلیل "+"دریافت اطلاعات نامعتبر")
//            finish()
//        }

        var gheimat=intent.getStringExtra("moneyCost")
        var arr = ArrayList<String>()
//        arr.add()
        gridGoods.adapter=ModemAdapter1(arr,this)
        varizeButton.setOnClickListener {
            progressLinnerservice.visibility=View.VISIBLE
            val map=HashMap<String,String>();
            map.put("iduser",users1!!.id.toString())
            map.put("idpackage",serviceId)
            map.put("gheimat",gheimat)
            createPostRequest("sale",this,map)
        }
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
                intent.putExtra(USER_KEY, Gson().toJson(users1))
                startActivity(intent)
                finish()
            },
            Response.ErrorListener { error ->
                cToast(this,"خطا در برقراری ارتباط")
                progressLinnerservice.visibility= View.GONE
            }

        )
        MySingleton.getInstance(context).requestQueue.add(request)
    }
}

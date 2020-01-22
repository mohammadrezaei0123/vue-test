package com.example.alik

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.alik.appCoustomSitting.MySingleton
import com.example.alik.appCoustomSitting.baseAppUrl
import com.example.alik.appCoustomSitting.cToast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_forget_password.*
import org.json.JSONObject
import kotlin.random.Random

class ForgetPasswordActivity : AppCompatActivity() {
    fun createCode(count: Int): String {
        val r = Random(14)
        val low = 0

        //        System.out.println(Result);
        val c = charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '0', '7', '5', '3', '9')
        //        char [] c={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'
        //                ,'q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7'
        //                ,'8','9','0'};
        val high = c.size - 1
        var h = ""
        for (i in 0 until count) {
            val result = r.nextInt(high - low) + low
            h += c[result]
        }
        return h
        //        System.out.println(h+"  "+h.length());
    }

    override fun onBackPressed() {
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
        enterForgetButton.setOnClickListener {
//            passworduserForgetTextView.validator=object :AutoCompleteTextView.Validator{
//                override fun fixText(invalidText: CharSequence?): CharSequence {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun isValid(text: CharSequence?): Boolean {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//            }
//            if(passworduserForgetTextView.isPerformingCompletion){
            val map=HashMap<String,String>()
            val pass=createCode(9)
            map.put("subject","رمز جدید")
            map.put("body","رمز کاربری شما به "+pass+" تغییر گردیده است.")
            map.put("email",passworduserForgetTextView.text.toString())
            map.put("pass",pass)
            createPostRequest("email/forget",this,map)
//            }else{
//                cToast(this,"ورود اطلاعات نا معتبر")
//            }
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
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("RESULT", response.toString())
                startActivity(intent)
                finish()
            },
            Response.ErrorListener { error ->
            }

        )
        MySingleton.getInstance(context).requestQueue.add(request)
    }
}

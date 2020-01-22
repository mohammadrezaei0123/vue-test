package com.example.alik

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AutoCompleteTextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.alik.appCoustomSitting.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignUpActivity : AppCompatActivity() {

    override fun onBackPressed() {
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val autoTexts= listOf<AutoCompleteTextView>(passworduserSignUp,repassworduserSignUp,usernameSignUp,emailSignUp,phoneNumberSignUp,constPhoneNumberSignUp)

        signUpButton.setOnClickListener {
            var notEmptys=true
            autoTexts.forEach {
                notEmptys=notEmptys&&checkEmpty(it)
            }
            val pass=passworduserSignUp.text.toString()
            if(notEmptys&&!pass.equals(repassworduserSignUp.text.toString())){
                repassworduserSignUp.error="رمز عبور اشباه تکرار گردیده"
            }
            if(notEmptys&&pass.equals(repassworduserSignUp.text.toString())){
                var mapReq=HashMap<String,String>();
                mapReq["user"]=usernameSignUp.text.toString()
                mapReq["password"]=pass
                mapReq["phone"]=phoneNumberSignUp.text.toString()
                mapReq["name"]=emailSignUp.text.toString()
                mapReq["fname"]=constPhoneNumberSignUp.text.toString()
                progressLinnerSingUp.visibility= View.VISIBLE
                createPostRequest(JSONObject(mapReq))
            }


        }
    }
    fun checkEmpty(auto:AutoCompleteTextView):Boolean{
        if(auto.text.trim().toString().length==0){
            auto.error="""
                مقدار ${auto.hint.toString()} وارد نگردیده
            """.trimIndent()
            return false
        }else
        return true
    }
    fun createPostRequest(jsonObject: JSONObject){
        print(jsonObject.toString())
        val req=JsonObjectRequest(Request.Method.POST,(baseAppUrl+"users"),jsonObject
            , Response.Listener { response ->
                writtingToFile(response)
                val inten =Intent(this,MainPanelActivity::class.java)
                inten.putExtra(USER_KEY,response.toString())
                startActivity(inten)
                finish()
            },
            Response.ErrorListener { error ->
                cToast(this,"خطا در برقراری ارتباط")
                print(error.toString())
                progressLinnerSingUp.visibility=View.GONE
            }
            )
        MySingleton.getInstance(this).requestQueue.add(req)
    }

    fun writtingToFile(jsonObject: JSONObject){
        val sharred:SharedPreferences=applicationContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor=sharred.edit()
        editor.putString(USER_KEY,jsonObject.toString())
        editor.apply()

    }

}

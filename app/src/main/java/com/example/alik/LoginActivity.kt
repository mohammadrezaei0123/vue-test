package com.example.alik

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.example.alik.appCoustomSitting.*
import com.example.alik.models.Manager
import com.example.alik.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    var entetrPanel=false

    override fun onStart() {
        super.onStart()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        System.exit(0);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val shared: SharedPreferences = applicationContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        val user = shared.getString(USER_KEY, "")
//        cToast(this,shared.getString(USER_KEY, ""))

        if(user.length>0){
            val users1=try{
                Gson().fromJson<User>(user,User::class.java)
            }catch (ex:Exception){null}
            if(users1!=null){
                val intent=Intent(this,MainPanelActivity::class.java)
                intent.putExtra(USER_KEY,Gson().toJson(users1))
                startActivity(intent)
                finish()
            }else{
                cToast(this,"تغییر در برنامه ساختار برنامه. لطفاً دوباره وارد شوید")
            }
        }
        switch1.setOnClickListener {
            if(!entetrPanel){
                switch1.text="مدیر"
            }else{
                switch1.text="کاربر"
            }
            entetrPanel=!entetrPanel
        }
        enterMainPanel.setOnClickListener {
            progressLinnerLogin.visibility=View.VISIBLE
//            if(entetrPanel){
//                cToast(this,"enter")
//            }https://m1202.herokuapp.com/users?user=ali12&password=1234

            if(switch1.text.equals("مدیر") ){

//                cToast(this,"مدیر")
                createRequest("""manager?user=${username.text}&pass=${passworduser.text}""","manger")
            }else{
//                cToast(this,"کاربر")
                createRequest("""users?user=${username.text}&password=${passworduser.text}""")
            }
        }
        forgetPage.setOnClickListener {
            startActivity(Intent(this,ForgetPasswordActivity::class.java))
            finish()
        }
        signupPage.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
            finish()
        }

    }
    fun createRequest(queryUrl:String,type:String="user"){

        val request= JsonArrayRequest(
            Request.Method.GET,(baseAppUrl +queryUrl),null,
            Response.Listener { response ->
               if(type.equals("manger")){
                   val manager=try{Gson().fromJson<List<Manager>>(response.toString(), object : TypeToken<List<Manager>>() {}.type)}catch (ex:Exception){null}
                   if(manager!=null) {
                       if (manager.size > 0) {
                           createRequest("""users""","all")
                       } else {
                           cToast(this, "اطلاعات نامعتبر")
                           progressLinnerLogin.visibility=View.GONE
                       }
                   }
               }else if(type.equals("all")){
                   val user1=try{Gson().fromJson<List<User>>(response.toString(), object : TypeToken<List<User>>() {}.type)}catch (ex:Exception){null}
                   if(user1!=null){
                       if(user1.size>0){
//                    entetrPanel=tru
// e
//                    cToast(this,"2."+user1[0].userName)
//                           writtingToFile(Gson().toJson(user1[0]))
                           val intent=Intent(this,MangerActivity::class.java)
                           intent.putExtra(USER_KEY,Gson().toJson(user1))
                           startActivity(intent)
                           finish()
                       }else{
                           cToast(this,"اطلاعات نامعتبر")
                       }
                   }else{
                       cToast(this,"اطلاعات نامعتبر")
                   }
                   progressLinnerLogin.visibility=View.GONE
               }else{
                   val user1=try{Gson().fromJson<List<User>>(response.toString(), object : TypeToken<List<User>>() {}.type)}catch (ex:Exception){null}
                   if(user1!=null){
                       if(user1.size>0){
//                    entetrPanel=tru
// e
//                    cToast(this,"2."+user1[0].userName)
                           writtingToFile(Gson().toJson(user1[0]))
                           val intent=Intent(this,MainPanelActivity::class.java)
                           intent.putExtra(USER_KEY,Gson().toJson(user1[0]))
                           startActivity(intent)
                           finish()
                       }else{
                           cToast(this,"اطلاعات نامعتبر")
                       }
                   }else{
                       cToast(this,"اطلاعات نامعتبر")
                   }
                   progressLinnerLogin.visibility=View.GONE
               }
            },
            Response.ErrorListener { error ->
                cToast(this,"خطا در برقراری ارتباط")
                progressLinnerLogin.visibility=View.GONE
            }

        )
        MySingleton.getInstance(this).requestQueue.add(request)
    }
    fun writtingToFile(jsonObject: String){
//        cToast(this,jsonObject)
        val sharred:SharedPreferences=applicationContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor=sharred.edit()
        editor.putString(USER_KEY,jsonObject)
//        editor.putString("password",password.text.toString())
//        editor.putString("userName",user.text.toString())
//        editor.putString("phoneNum",phoneNumber.text.toString())
        editor.apply()

    }
}

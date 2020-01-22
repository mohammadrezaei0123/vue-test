package com.example.alik

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alik.appCoustomSitting.USER_KEY
import com.example.alik.appCoustomSitting.cToast
import com.example.alik.models.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_user_sitting.*

class UserSittingActivity : AppCompatActivity() {
    var users1: User?=null
    override fun onBackPressed() {
        val intent= Intent(this,MainPanelActivity::class.java)
        intent.putExtra(USER_KEY, Gson().toJson(users1))
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_sitting)
        val st=intent.getStringExtra(USER_KEY)
        users1=try{Gson().fromJson<User>(st,User::class.java)}catch (ex: java.lang.Exception){null}
//        if(users1==null)
//            cToast(this,"user not found")
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}

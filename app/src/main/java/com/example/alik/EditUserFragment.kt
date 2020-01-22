package com.example.alik

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.alik.appCoustomSitting.FILE_NAME
import com.example.alik.appCoustomSitting.MySingleton
import com.example.alik.appCoustomSitting.USER_KEY
import com.example.alik.appCoustomSitting.baseAppUrl
import com.example.alik.models.User
import com.google.gson.Gson
import org.json.JSONObject


class EditUserFragment : Fragment() {

lateinit var users1:User
lateinit var usernameUserPanel:AutoCompleteTextView
    lateinit var passworduserUserPanel:AutoCompleteTextView
    lateinit var phoneNumberUserPanel:AutoCompleteTextView
    lateinit var constPhoneNumberUserPanel:AutoCompleteTextView
    lateinit var numberIdentificationUserPanel:AutoCompleteTextView
//    lateinit var emailUserPanel:AutoCompleteTextView
    lateinit var contex: Context
    lateinit var mainActivity: UserPanelActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_edit_user, container, false)
        contex =v.context
        mainActivity=activity as UserPanelActivity
        users1=mainActivity.users1!!
        usernameUserPanel=v.findViewById<AutoCompleteTextView>(R.id.usernameUserPanel)
        usernameUserPanel.setText(users1.user)
        passworduserUserPanel=v.findViewById<AutoCompleteTextView>(R.id.passworduserUserPanel)
        passworduserUserPanel.setText(users1.password)
        phoneNumberUserPanel=v.findViewById<AutoCompleteTextView>(R.id.phoneNumberUserPanel)
        phoneNumberUserPanel.setText(users1.phone)
        constPhoneNumberUserPanel=v.findViewById<AutoCompleteTextView>(R.id.constPhoneNumberUserPanel)
        constPhoneNumberUserPanel.setText(users1.name)
        numberIdentificationUserPanel=v.findViewById<AutoCompleteTextView>(R.id.numberIdentificationUserPanel)
        numberIdentificationUserPanel.setText(users1.fname)
//        emailUserPanel=v.findViewById<AutoCompleteTextView>(R.id.emailUserPanel)
//        emailUserPanel.setText(users1.name)
        v.findViewById<Button>(R.id.accepteUserPanelButton).setOnClickListener {

                createMapPost()

        }
        return v
    }

    private fun createMapPost(){
//        "update/user"
//        "{idUser,userName, passwordUser, emailUser, phoneNumber, constPhoneNumber, addressUser}"
        val map =HashMap<String,String>()
//        map.put("idUser",users1!!.id.toString())
//        mapReq["user"]=usernameSignUp.text.toString()
//        mapReq["password"]=pass
//        mapReq["phone"]=phoneNumberSignUp.text.toString()
//        mapReq["name"]=emailSignUp.text.toString()
//        mapReq["fname"]=constPhoneNumberSignUp.text.toString()
        map.put("user",usernameUserPanel.text.toString())
        map.put("password",passworduserUserPanel.text.toString())
        map.put("phone",phoneNumberUserPanel.text.toString())
        map.put("name",constPhoneNumberUserPanel.text.toString())
        map.put("fname",numberIdentificationUserPanel.text.toString())
//        map.put("emailUser",emailUserPanel.text.toString())
        createPostRequest("users/"+users1.id,contex,map)
    }
    fun createPostRequest(queryUrl: String, context: Context, values: HashMap<String, String>) {

        val jsonVal = try {
            JSONObject(values.toString())
        } catch (ex: java.lang.Exception) {
            null
        }
        val request = JsonObjectRequest(
            Request.Method.PUT, (baseAppUrl + queryUrl), jsonVal,
            Response.Listener { response ->
                //                castingJson(response.toString(),typeCast)
                val intent = Intent(contex, MainPanelActivity::class.java)
                intent.putExtra("RESULT", response.toString())
                users1.user=(usernameUserPanel.text.toString())
                users1.password=(passworduserUserPanel.text.toString())
                users1.phone=(phoneNumberUserPanel.text.toString())
                users1.name=(constPhoneNumberUserPanel.text.toString())
                users1.fname=(numberIdentificationUserPanel.text.toString())
//                users1.emailUser=(emailUserPanel.text.toString())
                writtingToFile(Gson().toJson(users1))
                intent.putExtra(USER_KEY, Gson().toJson(users1))
                startActivity(intent)
                mainActivity.finishActivitys()
            },
            Response.ErrorListener { error ->
            }

        )
        MySingleton.getInstance(context).requestQueue.add(request)
    }

    fun writtingToFile(jsonObject: String){
//        cToast(this,jsonObject)
        val sharred: SharedPreferences =contex.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor=sharred.edit()
        editor.putString(USER_KEY,jsonObject)
//        editor.putString("password",password.text.toString())
//        editor.putString("userName",user.text.toString())
//        editor.putString("phoneNum",phoneNumber.text.toString())
        editor.apply()

    }
}
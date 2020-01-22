
package com.example.alik.appCoustomSitting

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject


val CANCELTAG="canel"
val baseAppUrl="https://m1202.herokuapp.com/"
val FILE_NAME="ALI_K_APP"
val USER_KEY="USER"
val SERVICE_KEY="SERVICE_KEY"
val SIZE_KEY="SIZE_KEY"
val PROFILE_KEY="PROFILE_KEY"
val MODEM_KEY="MODEM_KEY"

fun cToast(context: Context,message:String,type:Int=1){
//    val t=if(type==1){Toast.LENGTH_LONG}else{Toast.LENGTH_SHORT}
    Toast.makeText(context,message,if(type==1){Toast.LENGTH_LONG}else{Toast.LENGTH_SHORT}).show()
}
fun perisanNumber(text:String):String {
    val persianNumbers = listOf<String>("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")
    if (text.length == 0) {
        return "";
    }
    var out = "";
    val length = text.length;
    for (i in 0..length-1) {
        val c = text[i];
        if ('0' <= c && c <= '9') {
            val number = Integer.parseInt("""${c}""");
            out += persianNumbers[number];
        } else if (c == '٫') {
            out += '،';
        } else {
            out += c;
        }
    }
    return out;
}



package com.example.alik.appCoustomSitting

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class UpdateReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
    val connectivityManager=context!!.getSystemService(Context.CONNECTIVITY_SERVICE)as ConnectivityManager;
     var activeNetInfo =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
    var isConnected = activeNetInfo != null && activeNetInfo.isConnectedOrConnecting();
        if (isConnected) {
            Log.i("NET", "Connected" + isConnected);
            Toast.makeText(context, "Network Connected",Toast.LENGTH_LONG).show();
        }else {
            Log.i("NET", "Not Connected" + isConnected);
            Toast.makeText(context, "Not Connected",Toast.LENGTH_LONG).show();
        }
    }
}
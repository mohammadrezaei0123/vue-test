package com.example.alik.appCoustomSitting

import android.app.Application

class FontSttings1: Application() {
    override fun onCreate() {
        super.onCreate()
        TypefaceUtil.overrideFont(getApplicationContext(),"SERIF","Fonts/Helal.ttf");
    }
}
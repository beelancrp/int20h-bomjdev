package com.bomjdev.myfood

import android.app.Application
import com.google.firebase.FirebaseApp

open class MyFoodApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}
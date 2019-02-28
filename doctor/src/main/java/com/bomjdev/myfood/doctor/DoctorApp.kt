package com.bomjdev.myfood.doctor

import android.app.Application
import com.google.firebase.FirebaseApp

/**
 * Created by azazellj on 2/23/19.
 */
class DoctorApp : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}
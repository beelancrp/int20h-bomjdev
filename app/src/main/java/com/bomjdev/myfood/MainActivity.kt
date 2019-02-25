package com.bomjdev.myfood

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bomjdev.myfood.base.BaseActivity
import com.bomjdev.myfood.base.View
import com.bomjdev.myfood.presentation.activities.LoginActivity
import com.bomjdev.myfood.presentation.mvp_view.LoginView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
    }
}

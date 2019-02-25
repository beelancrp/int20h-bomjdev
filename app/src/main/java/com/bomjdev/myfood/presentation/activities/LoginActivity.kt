package com.bomjdev.myfood.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bomjdev.myfood.R
import com.bomjdev.myfood.base.BaseActivity
import com.bomjdev.myfood.data.exceptions.UiError
import com.bomjdev.myfood.presentation.mvp_view.LoginView

class LoginActivity : AppCompatActivity(), LoginView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun showError(error: UiError) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}
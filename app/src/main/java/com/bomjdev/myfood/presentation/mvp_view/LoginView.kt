package com.bomjdev.myfood.presentation.mvp_view

import com.bomjdev.myfood.base.View
import com.bomjdev.myfood.data.exceptions.UiError

interface LoginView : View {
    fun showError(error: UiError)
    fun showLoading()
    fun hideLoading()
}
package com.bomjdev.myfood.di.app

import android.content.Context
import com.bomjdev.myfood.MyFoodApplication
import com.bomjdev.myfood.base.View
import com.bomjdev.myfood.data.exceptions.UiError
import com.bomjdev.myfood.presentation.mvp_view.LoginView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule() {

    @Provides
    @Singleton
    fun provideContext(app: MyFoodApplication): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideTest() : View {
        return object : LoginView {
            override fun showError(error: UiError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun showLoading() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun hideLoading() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }
}

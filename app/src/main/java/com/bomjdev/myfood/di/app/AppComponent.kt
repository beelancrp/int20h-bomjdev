package com.bomjdev.myfood.di.app

import android.app.Application
import com.bomjdev.myfood.MyFoodApplication
import com.bomjdev.myfood.di.app.login.LoginBindModule
import com.bomjdev.myfood.di.app.main.MainBindModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        LoginBindModule::class,
        MainBindModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyFoodApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: Application)
}
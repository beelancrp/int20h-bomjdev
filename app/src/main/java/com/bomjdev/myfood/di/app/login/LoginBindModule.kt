package com.bomjdev.myfood.di.app.login

import android.app.Activity
import com.bomjdev.myfood.presentation.activities.LoginActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [LoginSubComponent::class])
abstract class LoginBindModule {

    @Binds
    @IntoMap
    @ActivityKey(LoginActivity::class)
    abstract fun bindMainActivityInjectorFactory(builder: LoginSubComponent.Builder): AndroidInjector.Factory<out Activity>
}
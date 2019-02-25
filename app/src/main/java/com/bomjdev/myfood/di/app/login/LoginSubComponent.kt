package com.bomjdev.myfood.di.app.login

import com.bomjdev.myfood.presentation.activities.LoginActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [LoginModule::class])
interface LoginSubComponent : AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<LoginActivity>()
}
package com.bomjdev.myfood.di.app.main

import com.bomjdev.myfood.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainModule::class])
interface MainSubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
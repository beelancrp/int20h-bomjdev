package com.bomjdev.myfood.base

/**
 * Created by artemkutukov on 23.03.17.
 */

interface Presenter<V : View> {

    fun attachView(mvpView: V)

    fun detachView()
}

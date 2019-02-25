package com.bomjdev.myfood.base


import com.bomjdev.myfood.utils.Preconditions
import java.lang.ref.WeakReference

/**
 * Created by artemkutukov on 23.03.17.
 */

class BasePresenter<V : View, R : BaseRouter> : Presenter<V> {

    private var mMvpView: WeakReference<V>? = null
    private var mRouterRef: WeakReference<R>? = null

    protected val isViewAttached: Boolean
        get() = mMvpView != null && mMvpView!!.get() != null

    protected val isRouterAttached: Boolean
        get() = mRouterRef != null && mRouterRef!!.get() != null

    protected val mvpView: V?
        get() = if (mMvpView == null) null else mMvpView!!.get()

    protected var router: R?
        get() = if (mRouterRef == null) null else mRouterRef!!.get()
        set(router) {
            Preconditions.checkNotNull(router)
            mRouterRef = WeakReference<R>(router)
        }

    override fun attachView(mvpView: V) {
        Preconditions.checkNotNull(mvpView)
        mMvpView = WeakReference(mvpView)
    }

    override fun detachView() {
        if (mRouterRef != null)
            mRouterRef!!.clear()
        if (mMvpView != null)
            mMvpView!!.clear()
    }

    fun checkViewAttached() {
        if (!isViewAttached)
            throw MvpViewNotAttachedException()
    }

    private class MvpViewNotAttachedException internal constructor() :
        RuntimeException("Please call Presenter.attachView(View) before" + " requesting data to the Presenter")
}


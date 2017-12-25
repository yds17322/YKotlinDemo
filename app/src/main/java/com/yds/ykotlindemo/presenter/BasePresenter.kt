package com.yds.ykotlindemo.presenter


/**
 * Created by deshui on 17-12-25.
 * Presenter的基类，需要填写<T>，是View的实现接口
 */
abstract class BasePresenter<V> {
     var mView: V? = null

    /**
     * 载入Presenter-View的接口
     *
     * @param view
     */
    fun attach(view: V) {
        this.mView = view
    }

    /**
     * 取消载入状态
     */
    fun dettach() {
        mView = null
        System.gc()
    }
}
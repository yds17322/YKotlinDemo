package com.yds.ykotlindemo.presenter

import com.yds.ykotlindemo.model.BaseHttpModel


/**
 * Created by deshui on 17-12-25.
 * Presenter的基类，需要填写<T>，是View的实现接口
 */
abstract class BasePresenter<V> {
    private val mModelSet = HashSet<BaseHttpModel>()
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
     * 加入model
     */
    fun addModel(model: BaseHttpModel) {
        mModelSet.add(model)
    }

    /**
     * 取消载入状态
     * 取消model
     */
    fun dettach() {
        mView = null
        for (model in mModelSet) {
            model.unSubscription()
        }
        System.gc()
    }
}
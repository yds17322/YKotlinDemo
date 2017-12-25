package com.yds.ykitlindemo.http

import rx.Subscriber

/**
 * Created by deshui on 17-11-16.
 */
class HttpSubscriber<T> constructor() : Subscriber<T>() {
    lateinit var mCallBack: IHttpCallBack<T>

    constructor(callBack: IHttpCallBack<T>) : this() {
        this.mCallBack = callBack
    }

    override fun onNext(t: T) {
        mCallBack.onSuccess(t)
    }

    override fun onError(e: Throwable?) {
        if (e != null) {
            mCallBack.onError(e.message!!)
        }
    }

    override fun onCompleted() {
        mCallBack.onCompleted()
    }
}
package com.yds.ykitlindemo.http

import rx.Observable
import rx.Subscription

/**
 * Created by deshui on 17-11-16.
 */
class HttpObservable<T> constructor() {
    lateinit var mObservable: Observable<T>
    lateinit var mCallBack: IHttpCallBack<T>

    constructor(observable: Observable<T>, callBack: IHttpCallBack<T>) : this() {
        this.mObservable = observable
        this.mCallBack = callBack
    }

    fun attach(): Subscription {
        return mObservable
                .compose(SchedulersUtils.httpSchedulers(mCallBack))
                .subscribe(HttpSubscriber(mCallBack))
    }
}
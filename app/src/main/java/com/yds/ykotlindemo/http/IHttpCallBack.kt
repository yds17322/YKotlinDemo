package com.yds.ykitlindemo.http

/**
 * Created by deshui on 17-11-16.
 */
abstract class IHttpCallBack<T> {
    open fun onStart() {}
    open fun onSuccess(t: T) {}
    open fun onError(error: String) {}
    open fun onCompleted() {}
}
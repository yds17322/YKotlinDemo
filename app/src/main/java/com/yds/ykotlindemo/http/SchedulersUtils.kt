package com.yds.ykitlindemo.http

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by deshui on 17-11-16.
 */
class SchedulersUtils {

    companion object {
        fun <T> defaultSchedulers(): Observable.Transformer<T, T> {
            return Observable.Transformer {
                it.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }

        fun <T> httpSchedulers(callBack: IHttpCallBack<T>): Observable.Transformer<T, T> {
            return Observable.Transformer {
                it.subscribeOn(Schedulers.io())
                        .doOnSubscribe {
                            callBack.onStart()
                        }
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }
}
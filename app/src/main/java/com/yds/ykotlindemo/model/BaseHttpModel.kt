package com.yds.ykotlindemo.model

import com.yds.ykitlindemo.http.API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by deshui on 17-12-25.
 */
abstract class BaseHttpModel constructor() {
    lateinit var mApi: API
    var mCompositeSubscription: CompositeSubscription? = null

    constructor(host: String) : this() {
        initHttp(host)
    }

    fun initHttp(host: String) {
        val mInterceptor = HttpLoggingInterceptor()
        mInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val mOkHttp: OkHttpClient = OkHttpClient.Builder().addInterceptor(mInterceptor).build()
        val mRetrofit: Retrofit = Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttp)
                .build()
        mApi = mRetrofit.create(API::class.java)
    }

    fun addSubscription(s: Subscription) {
        if (null == mCompositeSubscription) {
            mCompositeSubscription = CompositeSubscription()
        }
        mCompositeSubscription!!.add(s)
    }

    fun unSubscription() {
        if (null != mCompositeSubscription) {
            mCompositeSubscription!!.unsubscribe()
        }
    }
}
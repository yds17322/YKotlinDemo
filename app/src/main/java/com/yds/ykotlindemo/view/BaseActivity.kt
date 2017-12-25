package com.yds.ykotlindemo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yds.ykotlindemo.presenter.BasePresenter


/**
 * Created by deshui on 17-12-25.
 * Activity的基类
 * 泛型 V -> View的实现接口；； T -> 继承了BasePresenter的Presenter
 */
abstract class BaseActivity<V, T : BasePresenter<V>> : AppCompatActivity() {
    // Activity所需要的Presenter
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 初始化Presenter
        mPresenter = initPresenter()
    }

    override fun onResume() {
        super.onResume()
        // 绑定View
        mPresenter.attach(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 解绑
        mPresenter.dettach()
    }

    abstract fun initPresenter(): T
}
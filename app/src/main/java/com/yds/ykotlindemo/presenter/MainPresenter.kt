package com.yds.ykotlindemo.presenter

import com.yds.ykotlindemo.view.inter.IMainInter

/**
 * Created by deshui on 17-12-25.
 */
class MainPresenter : BasePresenter<IMainInter>() {

    fun getName() {
        mView!!.getName("yds")
    }

}
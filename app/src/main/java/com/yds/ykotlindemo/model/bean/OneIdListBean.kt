package com.yds.ykotlindemo.model.bean

/**
 * Created by deshui on 17-12-26.
 */
class OneIdListBean {
    private var res: Int = 0
    private var data: List<String>? = null

    fun getRes(): Int {
        return res
    }

    fun setRes(res: Int) {
        this.res = res
    }

    fun getData(): List<String>? {
        return data
    }

    fun setData(data: List<String>) {
        this.data = data
    }
}
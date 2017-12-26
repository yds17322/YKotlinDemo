package com.yds.ykitlindemo.http

import com.yds.ykotlindemo.model.bean.OneIdListBean
import retrofit2.http.GET
import rx.Observable

/**
 * Created by deshui on 17-11-16.
 */
interface API {

    companion object {
        val ONE_IDLIST: String = "http://v3.wufazhuce.com:8000/api/onelist/" // one
    }

    @GET("http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    fun getOneIdList(): Observable<OneIdListBean>

    @GET("{id}/0?cchannel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    fun getOneDateList()

}
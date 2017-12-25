package com.yds.ykitlindemo.http

/**
 * Created by deshui on 17-11-16.
 */
interface API {

    companion object {
        val NEWS_HOT: String = "http://api.avatardata.cn/" // 头条新闻
    }

//    @FormUrlEncoded
//    @POST("GuoNeiNews/Query")
//    fun getHotNews(@Field("key") key: String, @Field("page") page: Int, @Field("rows") rows: Int): Observable<HotNewsBean>

}
package com.yds.ykotlindemo.model

import com.yds.ykitlindemo.http.API
import com.yds.ykitlindemo.http.HttpObservable
import com.yds.ykitlindemo.http.IHttpCallBack
import com.yds.ykotlindemo.model.bean.OneIdListBean

/**
 * Created by deshui on 17-12-26.
 */
class OneListModel : BaseHttpModel(API.ONE_IDLIST) {

    fun getOneIdList(callBack: IHttpCallBack<OneIdListBean>) {
        addSubscription(HttpObservable(mApi.getOneIdList(), callBack).attach())
    }
}
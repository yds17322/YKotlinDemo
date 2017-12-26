package com.yds.ykotlindemo.presenter

import android.app.Fragment
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.yds.ykotlindemo.view.fragment.OneFragment
import com.yds.ykotlindemo.view.inter.IMainInter

/**
 * Created by deshui on 17-12-25.
 */
class MainPresenter : BasePresenter<IMainInter>() {
    companion object {
        val ONE_FRAGMENT = 0
    }

    private val mFragmentMap = HashMap<Int, Fragment>()

    fun initFragment(): HashMap<Int, Fragment> {
        mFragmentMap.put(ONE_FRAGMENT, OneFragment())
        return mFragmentMap
    }

    fun changeFragment(activity: AppCompatActivity, id: Int, type: Int) {
        val transaction: FragmentTransaction = activity.fragmentManager.beginTransaction()
        transaction.replace(id, mFragmentMap[type])
        transaction.commit()
    }
}
package com.yds.ykotlindemo.view.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yds.ykotlindemo.R

/**
 * Created by deshui on 17-12-26.
 */
class OneFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mRootView = inflater!!.inflate(R.layout.fragment_one, container, false)
        return mRootView
    }
}
package com.yds.ykotlindemo.view

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.Toast
import com.yds.ykotlindemo.R
import com.yds.ykotlindemo.presenter.MainPresenter
import com.yds.ykotlindemo.view.inter.IMainInter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * Created by deshui on 17-12-25.
 */
class MainActivity : BaseActivity<IMainInter, MainPresenter>(), IMainInter, NavigationView.OnNavigationItemSelectedListener {
    override fun initPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mToolbar)

        val toggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        mNavigationView.setNavigationItemSelectedListener(this)

        mBtn.setOnClickListener { mPresenter.getName() }
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun getName(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
                mPresenter.getName()
            }
            else -> {
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
package com.navi.assignment.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.navi.assignment.app.di.Injector
import com.navi.assignment.app.ui.BaseFragment

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, BaseFragment())
            .commit()
    }
}
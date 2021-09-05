package com.navi.assignment.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.navi.assignment.app.R

class GithubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, BaseFragment())
            .commit()
    }
}
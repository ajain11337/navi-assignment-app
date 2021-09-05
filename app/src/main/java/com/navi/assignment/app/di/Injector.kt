package com.navi.assignment.app.di

import com.navi.assignment.app.BaseActivity
import com.navi.assignment.app.ui.BaseFragment

object Injector {
    private val component: GithubComponent = DaggerGithubComponent.builder().build()

    fun inject(baseFragment: BaseFragment) {
        component.inject(baseFragment)
    }

    fun inject(baseActivity: BaseActivity) {
        component.inject(baseActivity)
    }
}
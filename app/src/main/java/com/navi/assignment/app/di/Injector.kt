package com.navi.assignment.app.di

import com.navi.assignment.app.ui.GithubActivity
import com.navi.assignment.app.ui.BaseFragment

object Injector {
    private val component: GithubComponent = DaggerGithubComponent.builder().build()

    fun inject(baseFragment: BaseFragment) {
        component.inject(baseFragment)
    }

    fun inject(githubActivity: GithubActivity) {
        component.inject(githubActivity)
    }
}
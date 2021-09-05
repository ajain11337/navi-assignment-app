package com.navi.assignment.app.di

import com.navi.assignment.app.ui.GithubActivity
import com.navi.assignment.app.ui.GithubFragment

object Injector {
    private val component: GithubComponent = DaggerGithubComponent.builder().build()

    fun inject(githubFragment: GithubFragment) {
        component.inject(githubFragment)
    }

    fun inject(githubActivity: GithubActivity) {
        component.inject(githubActivity)
    }
}
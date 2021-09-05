package com.navi.assignment.app.di

import com.navi.assignment.app.ui.GithubActivity
import com.navi.assignment.app.common.ViewModelFactoryModule
import com.navi.assignment.app.ui.GithubFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ViewModelFactoryModule::class,
        GithubViewModelsModule::class,
        GithubNetworkModule::class
    ]
)
@Singleton
interface GithubComponent {
    fun inject(githubFragment: GithubFragment)
    fun inject(githubActivity: GithubActivity)
}
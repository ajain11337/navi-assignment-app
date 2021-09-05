package com.navi.assignment.app.di

import com.navi.assignment.app.ui.GithubActivity
import com.navi.assignment.app.di.modules.BaseViewModelsModule
import com.navi.assignment.app.di.modules.NetworkModule
import com.navi.assignment.app.di.modules.ViewModelFactoryModule
import com.navi.assignment.app.ui.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        ViewModelFactoryModule::class,
        BaseViewModelsModule::class
    ]
)
@Singleton
interface GithubComponent {
    fun inject(baseFragment: BaseFragment)
    fun inject(githubActivity: GithubActivity)
}
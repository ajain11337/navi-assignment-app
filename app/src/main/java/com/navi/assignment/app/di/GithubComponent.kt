package com.navi.assignment.app.di

import com.navi.assignment.app.BaseActivity
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
    fun inject(baseActivity: BaseActivity)
}
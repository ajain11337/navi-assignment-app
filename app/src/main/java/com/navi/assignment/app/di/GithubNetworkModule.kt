package com.navi.assignment.app.di

import com.navi.assignment.app.common.CommonNetworkModule
import com.navi.assignment.app.data.GetGithubUseCaseImpl
import com.navi.assignment.app.data.GetGithubUseCase
import com.navi.assignment.app.domain.GithubRepository
import com.navi.assignment.app.domain.GithubRepositoryImpl
import com.navi.assignment.app.domain.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [CommonNetworkModule::class])
class GithubNetworkModule {
    @Provides
    fun providesGithubService(retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)

    @Provides
    fun providesGetPRUseCase(getGithubUseCaseImpl: GetGithubUseCaseImpl): GetGithubUseCase =
        getGithubUseCaseImpl

    @Provides
    fun providesRepository(githubRepositoryImpl: GithubRepositoryImpl): GithubRepository =
        githubRepositoryImpl
}
package com.navi.assignment.app.domain

import com.navi.assignment.app.common.Constants
import com.navi.assignment.app.common.PRStatus
import com.navi.assignment.app.domain.model.GithubDomainModel
import retrofit2.Response
import javax.inject.Inject

interface Repository {
    suspend fun getAllPullRequests(
        status: String,
        page: Int,
        per_page: Int
    ): Response<List<GithubDomainModel>>
}

class RepositoryImpl @Inject constructor(private val githubService: GithubService) : Repository {
    override suspend fun getAllPullRequests(
        status: String,
        page: Int,
        per_page: Int
    ): Response<List<GithubDomainModel>> {
        return githubService.getAllPullRequests(
            Constants.REQUEST_URL,
            PRStatus.CLOSED,
            1,
            30
        )
    }
}
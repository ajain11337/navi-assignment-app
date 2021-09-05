package com.navi.assignment.app.domain

import com.navi.assignment.app.common.Constants
import com.navi.assignment.app.common.PRStatus
import com.navi.assignment.app.domain.model.GithubDomainModel
import retrofit2.Response
import javax.inject.Inject

interface GithubRepository {
    suspend fun getAllPullRequests(status: String, page: Int, per_page: Int): Response<List<GithubDomainModel>>
}

class GithubRepositoryImpl @Inject constructor(private val githubService: GithubService) : GithubRepository {
    override suspend fun getAllPullRequests(status: String, page: Int, per_page: Int): Response<List<GithubDomainModel>> {
        return githubService.getAllPullRequests(
            url = Constants.REQUEST_URL,
            state = PRStatus.CLOSED,
            page = Constants.PAGE_NUMBER,
            per_page = Constants.PER_PAGE_COUNT
        )
    }
}
package com.navi.assignment.app.domain

import com.navi.assignment.app.common.Constants
import com.navi.assignment.app.common.PullRequestState
import com.navi.assignment.app.domain.model.GithubDomainModel
import retrofit2.Response
import javax.inject.Inject

interface GithubRepository {
    suspend fun getAllPullRequests(state: String, page: Int, per_page: Int): Response<List<GithubDomainModel>>
}

class GithubRepositoryImpl @Inject constructor(private val githubService: GithubService) : GithubRepository {
    override suspend fun getAllPullRequests(state: String, page: Int, per_page: Int): Response<List<GithubDomainModel>> {
        return githubService.getAllPullRequests(
            url = Constants.REQUEST_URL,
            state = state,
            page = page,
            per_page = per_page
        )
    }
}
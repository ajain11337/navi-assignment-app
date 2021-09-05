package com.navi.assignment.app.data

import com.navi.assignment.app.common.PullRequestState
import com.navi.assignment.app.domain.GithubRepository
import com.navi.assignment.app.domain.model.GithubDomainModel
import retrofit2.Response
import javax.inject.Inject

interface GetGithubUseCase {
    suspend fun execute(status: String, page: Int, per_page: Int): Response<List<GithubDomainModel>>
}

class GetGithubUseCaseImpl @Inject constructor(
    private val repository: GithubRepository
) : GetGithubUseCase {
    override suspend fun execute(
        status: String,
        page: Int,
        per_page: Int
    ): Response<List<GithubDomainModel>> {
        return repository.getAllPullRequests(
            PullRequestState.CLOSED,
            1,
            30
        )
    }
}
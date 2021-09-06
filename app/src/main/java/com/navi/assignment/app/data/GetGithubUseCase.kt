package com.navi.assignment.app.data

import com.navi.assignment.app.domain.GithubRepository
import com.navi.assignment.app.domain.model.GithubDomainModel
import retrofit2.Response
import javax.inject.Inject

interface GetGithubUseCase {
    suspend fun execute(state: String, page: Int, per_page: Int): Response<List<GithubDomainModel>>
}

class GetGithubUseCaseImpl @Inject constructor(
    private val repository: GithubRepository
) : GetGithubUseCase {
    override suspend fun execute(
        state: String,
        page: Int,
        per_page: Int
    ): Response<List<GithubDomainModel>> {
        return repository.getAllPullRequests(
            state= state,
            page = page,
            per_page = per_page
        )
    }
}
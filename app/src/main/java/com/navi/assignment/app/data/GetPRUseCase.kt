package com.navi.assignment.app.data

import com.navi.assignment.app.common.Constants
import com.navi.assignment.app.common.PRStatus
import com.navi.assignment.app.domain.GithubService
import com.navi.assignment.app.domain.model.GithubDomainModel
import retrofit2.Response
import javax.inject.Inject

interface GetPRUseCase {
    suspend fun execute(status: String, page: Int, per_page: Int): Response<List<GithubDomainModel>>
}

class GetClosedPRUseCaseImpl @Inject constructor(
    private val githubService: GithubService
) : GetPRUseCase {
    override suspend fun execute(status: String, page: Int, per_page: Int): Response<List<GithubDomainModel>> {
        return githubService.getAllMovies(
            Constants.REQUEST_URL,
            PRStatus.CLOSED,
            1,
            30
        )
    }
}
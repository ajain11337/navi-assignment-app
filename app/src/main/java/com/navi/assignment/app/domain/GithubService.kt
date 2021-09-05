package com.navi.assignment.app.domain

import com.navi.assignment.app.domain.model.GithubDomainModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface GithubService {

    @GET
    suspend fun getAllPullRequests(
        @Url url: String,
        @Query("state") state: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ) : Response<List<GithubDomainModel>>
}
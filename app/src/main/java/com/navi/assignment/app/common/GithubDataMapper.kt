package com.navi.assignment.app.common

import com.navi.assignment.app.data.model.GithubDataModel
import com.navi.assignment.app.domain.model.GithubDomainModel
import javax.inject.Inject

class GithubDataMapper @Inject constructor(){
    fun mapTo(data: List<GithubDomainModel>): List<GithubDataModel> {
        val list = mutableListOf<GithubDataModel>()
        data.forEach {
            list.add(
                GithubDataModel(
                    title = it.title,
                    createdDate = it.created_at,
                    closedDate = it.closed_at,
                    userName = it.user.login,
                    userImageUrl = it.user.avatar_url
                )
            )
        }
        return list
    }
}
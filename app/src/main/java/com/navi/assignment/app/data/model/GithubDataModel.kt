package com.navi.assignment.app.data.model

import com.navi.assignment.app.common.DateFormatter

data class GithubDataModel(
    val title: String,
    val createdDate: String,
    val closedDate: String,
    val userName: String,
    val userImageUrl: String
){
    fun getAuthorString() : String = "@${userName}"
    fun getCreatedDateString(): String = "Created : ${DateFormatter.getISOFormattedDateString(createdDate)}"
    fun getClosedDateString(): String = "Closed : ${DateFormatter.getISOFormattedDateString(closedDate)}"
}
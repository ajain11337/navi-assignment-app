package com.navi.assignment.app.domain.model

import com.google.gson.annotations.SerializedName

data class _links (
	@SerializedName("self") val self : Self,
	@SerializedName("html") val html : Html,
	@SerializedName("issue") val issue : Issue,
	@SerializedName("comments") val comments : Comments,
	@SerializedName("review_comments") val review_comments : Review_comments,
	@SerializedName("review_comment") val review_comment : Review_comment,
	@SerializedName("commits") val commits : Commits,
	@SerializedName("statuses") val statuses : Statuses
)
package com.navi.assignment.app.domain.model

import com.google.gson.annotations.SerializedName

data class Commits (
	@SerializedName("href") val href : String
)
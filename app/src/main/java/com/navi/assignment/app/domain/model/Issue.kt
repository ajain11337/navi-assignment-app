package com.navi.assignment.app.domain.model

import com.google.gson.annotations.SerializedName

data class Issue (
	@SerializedName("href") val href : String
)
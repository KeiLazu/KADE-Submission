package com.github.footballclubsubmission.data.models

import com.google.gson.annotations.SerializedName

data class TeamResponse(

	@field:SerializedName("teams")
	var teams: MutableList<TeamsItem>
)
package com.github.footballclubsubmission.data.models

import com.google.gson.annotations.SerializedName

data class EventLeagueResponse(

	@field:SerializedName("events")
	var events: MutableList<EventsItem>
)
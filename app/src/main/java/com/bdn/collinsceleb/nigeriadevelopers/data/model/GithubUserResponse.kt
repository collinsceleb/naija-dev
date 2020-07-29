package com.bdn.collinsceleb.nigeriadevelopers.data.model

import com.squareup.moshi.Json

data class GithubUserResponse(
    @Json(name = "total_count")
    val totalCount: Int = 0,

    @Json(name = "items")
    val items: List<GithubUser> = emptyList()

)
package com.bdn.collinsceleb.nigeriadevelopers.data.model

import com.squareup.moshi.Json

data class GithubUser(
    @Json(name = "login")
    val login: String,

    @Json(name = "avatar_url")
    val imageUrl: String,

    @Json(name = "html_url")
    val userProfile: String,

    @Json(name = "repos_url")
    val repository: String
)
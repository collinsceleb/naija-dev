package com.bdn.collinsceleb.nigeriadevelopers.data.network

import com.bdn.collinsceleb.nigeriadevelopers.data.model.GithubUserResponse
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubApiEndPoints.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(
        BASE_URL
    ).build()

object GithubUserApi {
    val retrofitService: GithubApiService by lazy {
        retrofit.create(GithubApiService::class.java)
    }
}

interface GithubApiService {

    @GET("search/users?sort=repositories&order=desc")
    fun searchUsersAsync(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Deferred<GithubUserResponse>
}
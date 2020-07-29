package com.bdn.collinsceleb.nigeriadevelopers.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bdn.collinsceleb.nigeriadevelopers.data.model.GithubUserResponse
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubApiEndPoints.PAGE
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubApiEndPoints.PER_PAGE
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubApiEndPoints.QUALIFIER
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubUserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel : ViewModel() {


    private val _responseBody = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _responseBody

    init {
        getGithubUsers()
    }

    private  fun getGithubUsers() {
        GithubUserApi.retrofitService.searchUsers(QUALIFIER, PAGE, PER_PAGE).enqueue(
            object : Callback<GithubUserResponse> {
                override fun onFailure(call: Call<GithubUserResponse>, t: Throwable) {
                    _responseBody.value = "Failure: " + t.message
                }

                override fun onResponse(call: Call<GithubUserResponse>, response: Response<GithubUserResponse>) {
                    _responseBody.value = "Success: ${response.body()} items retrieved"
                }
            }
        )

    }
}
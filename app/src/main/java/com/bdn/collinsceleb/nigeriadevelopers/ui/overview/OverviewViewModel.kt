package com.bdn.collinsceleb.nigeriadevelopers.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubApiEndPoints.PAGE
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubApiEndPoints.PER_PAGE
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubApiEndPoints.QUALIFIER
import com.bdn.collinsceleb.nigeriadevelopers.data.network.GithubUserApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _responseBody = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _responseBody

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getGithubUsers()
    }

    private  fun getGithubUsers() {
        coroutineScope.launch {
            var getGithubUsersDeferred = GithubUserApi.retrofitService.searchUsersAsync(QUALIFIER, PAGE, PER_PAGE)
            try {
                var usersListResult = getGithubUsersDeferred.await()
                _responseBody.value = "Success: ${usersListResult.items.size} users retrieved"
            }
            catch (exception: Exception) {
                _responseBody.value = "Failure: ${exception.message}"
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
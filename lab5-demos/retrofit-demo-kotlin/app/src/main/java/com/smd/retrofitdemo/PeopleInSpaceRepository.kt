package com.smd.retrofitdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smd.retrofitdemo.network.PeopleInSpace
import com.smd.retrofitdemo.network.PeopleInSpaceProvider.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Provides data describing the current people in space. It obtains it using the PeopleInSpaceService.
 */
internal class PeopleInSpaceRepository {
    private val responseLiveData = MutableLiveData<PeopleInSpace?>()
    private val peopleInSpaceService = apiService
    val peopleInSpace: Unit
        get() {
            peopleInSpaceService.peopleInSpace().enqueue(object : Callback<PeopleInSpace?> {
                override fun onResponse(
                    call: Call<PeopleInSpace?>,
                    response: Response<PeopleInSpace?>
                ) {
                    if (response.body() != null) {
                        Timber.d("people in space response received ${response.body()}")
                        responseLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<PeopleInSpace?>, throwable: Throwable) {
                    responseLiveData.postValue(null)
                }
            })
        }

    val peopleInSpaceResponseLiveData: LiveData<PeopleInSpace?>
        get() = responseLiveData
}
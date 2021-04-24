package com.smd.retrofitdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.smd.retrofitdemo.network.PeopleInSpace

/**
 * ViewModel for obtaining data about the current astronauts in space.
 * It retrieves the data from the PeopleInSpaceRepository.
 */
class PeopleInSpaceViewModel(application: Application) : AndroidViewModel(
    application
) {
    var peopleInSpaceLiveData: LiveData<PeopleInSpace?>? = null
        private set
    private val peopleInSpaceRepository: PeopleInSpaceRepository = PeopleInSpaceRepository()
    fun init() {
        peopleInSpaceLiveData = peopleInSpaceRepository.peopleInSpaceResponseLiveData
    }

    val peopleInSpace: Unit
        get() {
            peopleInSpaceRepository.peopleInSpace
        }
}
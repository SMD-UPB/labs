package com.smd.retrofitdemo;

import android.app.Application;
import com.smd.retrofitdemo.network.PeopleInSpace;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * ViewModel for obtaining data about the current astronauts in space.
 * It retrieves the data from the PeopleInSpaceRepository.
 */
public class PeopleInSpaceViewModel extends AndroidViewModel {

    private LiveData<PeopleInSpace> peopleInSpaceLiveData;
    private final PeopleInSpaceRepository peopleInSpaceRepository;

    public PeopleInSpaceViewModel(Application application) {
        super(application);
        peopleInSpaceRepository = new PeopleInSpaceRepository();
    }

    public void init() {
        peopleInSpaceLiveData = peopleInSpaceRepository.getPeopleInSpaceResponseLiveData();
    }

    public LiveData<PeopleInSpace> getPeopleInSpaceLiveData() {
        return peopleInSpaceLiveData;
    }

    public void getPeopleInSpace() {
        peopleInSpaceRepository.getPeopleInSpace();
    }
}

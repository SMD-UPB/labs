package com.smd.retrofitdemo;

import android.util.Log;
import com.smd.retrofitdemo.network.PeopleInSpace;
import com.smd.retrofitdemo.network.PeopleInSpaceProvider;
import com.smd.retrofitdemo.network.PeopleInSpaceService;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Provides data describing the current people in space. It obtains it using the PeopleInSpaceService.
 */
class PeopleInSpaceRepository {

    private static final String TAG = PeopleInSpaceRepository.class.getName();
    private final MutableLiveData<PeopleInSpace> responseLiveData = new MutableLiveData<>();
    private final PeopleInSpaceService peopleInSpaceService = PeopleInSpaceProvider.getApiService();

    public void getPeopleInSpace() {
        peopleInSpaceService.getPeopleInSpace().enqueue(new Callback<PeopleInSpace>() {
            @Override
            public void onResponse(Call<PeopleInSpace> call, Response<PeopleInSpace> response) {
                if (response.body() != null) {
                    Log.d(TAG, "people in space response received " + response.body());
                    responseLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PeopleInSpace> call, Throwable throwable) {
                responseLiveData.postValue(null);
            }
        });
    }

    public LiveData<PeopleInSpace> getPeopleInSpaceResponseLiveData() {
        return responseLiveData;
    }
}

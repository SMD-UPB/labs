package com.smd.retrofitdemo.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeopleInSpaceService {
    @GET("/astros.json")
    Call<PeopleInSpace> getPeopleInSpace();
}

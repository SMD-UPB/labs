package com.smd.retrofitdemo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provides the retrofit service for calling the ISS API
 */
public class PeopleInSpaceProvider {
    private static final String BASE_URL = "http://api.open-notify.org";

    private static Retrofit retrofit = null;

    private PeopleInSpaceProvider() {
    }

    public static PeopleInSpaceService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(PeopleInSpaceService.class);
    }
}

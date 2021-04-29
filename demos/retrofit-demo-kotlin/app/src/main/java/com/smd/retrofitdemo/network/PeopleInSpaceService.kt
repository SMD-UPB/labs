package com.smd.retrofitdemo.network

import retrofit2.Call
import retrofit2.http.GET

interface PeopleInSpaceService {
    @GET("/astros.json")
    fun peopleInSpace(): Call<PeopleInSpace>
}
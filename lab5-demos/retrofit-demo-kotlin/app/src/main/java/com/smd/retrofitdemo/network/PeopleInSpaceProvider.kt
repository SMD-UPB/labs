package com.smd.retrofitdemo.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Provides the retrofit service for calling the ISS API
 */
object PeopleInSpaceProvider {
    private const val BASE_URL = "http://api.open-notify.org"

    private val moshi = Moshi.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiService: PeopleInSpaceService by lazy {
        retrofit.create(PeopleInSpaceService::class.java)
    }
}
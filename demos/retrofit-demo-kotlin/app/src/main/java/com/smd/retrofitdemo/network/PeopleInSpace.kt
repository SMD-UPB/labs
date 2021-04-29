package com.smd.retrofitdemo.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * The response for the call to http://api.open-notify.org/astros.json
 */
@JsonClass(generateAdapter = true)
data class PeopleInSpace(
    @Json(name = "message")
    var message: String,

    @Json(name = "number")
    var number: Int = 0,

    @Json(name = "people")
    var people: List<Person>? = null
)
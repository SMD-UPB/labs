package com.smd.retrofitdemo.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * A person in space, as defined by the API response
 */
@JsonClass(generateAdapter = true)
data class Person(
    @Json(name = "craft")
    var craft: String,

    @Json(name = "name")
    var name: String
)
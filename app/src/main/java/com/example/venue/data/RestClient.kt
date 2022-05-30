package com.example.venue.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    const val BASEURL = "https://api.foursquare.com/v2/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

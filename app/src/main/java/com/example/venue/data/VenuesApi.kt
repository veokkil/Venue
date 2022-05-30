package com.example.venue.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface VenuesApi {
    @GET("venues/search")
    suspend fun getVenues(@QueryMap params: HashMap<String, String>) : Response<VenuesList>

}
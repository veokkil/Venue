package com.example.venue.data
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.venue.R
import com.example.venue.VenueApplication
import kotlinx.coroutines.*

class FourSquareVenueDao() {

    var venueList: MutableList<Venues> = mutableListOf()

    // LiveData can be observed for changes
    private val venues = MutableLiveData<List<Venues>>()
    // Coroutine scope
    private val daoJob = Job()
    val daoScope = CoroutineScope(Dispatchers.Main + daoJob)

    init {
        venues.value = venueList
    }

    fun getVenues() = venues as LiveData<List<Venues>>

    fun fetchVenues(searchTerm: String, location: Location) {
        val venuesApi = RestClient.getInstance().create(VenuesApi::class.java)
        val params = HashMap<String, String>()
        params["client_id"] = VenueApplication.applicationContext().getString(R.string.CLIENT_ID)
        params["client_secret"] = VenueApplication.applicationContext().getString(R.string.CLIENT_SECRET)
        params["query"] = searchTerm
        params["ll"] = location.latitude.toString() + "," + location.longitude.toString()
        params["v"] = "20220101"

        daoScope.launch {
            val result = venuesApi.getVenues(params)
            if (result.body() != null && result.body()!!.response != null)
                venues.postValue(result.body()!!.response!!.venues)
        }
    }
}
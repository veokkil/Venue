package com.example.venue.data

class VenueRepository private constructor(private val venueDao: FourSquareVenueDao, private val locationDao: LocationDao) {

    fun getVenues() = venueDao.getVenues()
    fun fetchVenues(term: String) = venueDao.fetchVenues(term, locationDao.getCurrentLocation().value!! )

    companion object {
        // Singleton instantiation
        @Volatile private var instance: VenueRepository? = null

        fun getInstance(venueDao: FourSquareVenueDao, locationDao: LocationDao) =
            instance ?: synchronized(this) {
                instance ?: VenueRepository(venueDao, locationDao ).also { instance = it }
            }
    }
}
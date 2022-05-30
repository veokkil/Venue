package com.example.venue.data

import android.annotation.SuppressLint
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.venue.VenueApplication
import com.google.android.gms.location.*
import java.lang.Exception
import java.util.concurrent.TimeUnit

@SuppressLint("MissingPermission")
class LocationDao {

    // FusedLocationProviderClient - Main class for receiving location updates.
    private  var fusedLocationProviderClient: FusedLocationProviderClient

    private  var locationRequest: LocationRequest
    private  var locationCallback: LocationCallback

    private val location = MutableLiveData<Location>()

    init {
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(VenueApplication.applicationContext())
        // get initial value for location
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { currLoc: Location? ->
                Log.d("FetchLocation", currLoc.toString())
                location.postValue(currLoc)
            }
            .addOnFailureListener { it: Exception ->
                Log.d("FetchLocation", it.toString())
            }

        locationRequest = LocationRequest.create().apply {
            interval = TimeUnit.SECONDS.toMillis(60)
            fastestInterval = TimeUnit.SECONDS.toMillis(30)
            maxWaitTime = TimeUnit.MINUTES.toMillis(2)
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        // fetch updates with some frequence
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                Log.d("LocationUpdate", locationResult.lastLocation.toString())
                location.postValue(locationResult.lastLocation)
            }
        }

        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }


    fun getCurrentLocation() = location



}
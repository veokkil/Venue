package com.example.venue.utils

import android.content.Context
import com.example.venue.data.FourSquareVenueDao
import com.example.venue.data.LocationDao
import com.example.venue.data.VenueRepository
import com.example.venue.ui.VenueViewModelFactory

object Injector {

    fun provideVenueViewModelFactory(): VenueViewModelFactory {
        // Injecting dependencies here in one place
        val quoteRepository = VenueRepository.getInstance(FourSquareVenueDao(),LocationDao())
        return VenueViewModelFactory(quoteRepository)
    }

}
package com.example.venue.ui

import androidx.lifecycle.ViewModel
import com.example.venue.data.VenueRepository

class VenueViewModel( private val venueRepository: VenueRepository)
    : ViewModel()
{
    fun getVenues() = venueRepository.getVenues()
    fun fetchVenues(term: String) = venueRepository.fetchVenues(term)

}
package com.example.venue.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.venue.data.VenueRepository

class VenueViewModelFactory(private val venueRepository: VenueRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VenueViewModel(venueRepository) as T
    }
}
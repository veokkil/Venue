package com.example.venue

import android.app.Application
import android.content.Context

class VenueApplication: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: VenueApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}
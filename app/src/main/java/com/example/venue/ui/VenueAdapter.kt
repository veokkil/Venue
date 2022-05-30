package com.example.venue.ui

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.venue.R
import com.example.venue.data.Venues

class VenueAdapter (private val context: Activity, private val venues: Array<Venues>)
    : ArrayAdapter<Venues>(context, R.layout.venue_item, venues) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.venue_item, null, true)

        val venue = rowView.findViewById(R.id.Venue) as TextView
        val address = rowView.findViewById(R.id.Address) as TextView
        val distance = rowView.findViewById(R.id.Distance) as TextView

        venue.text = venues[position].name
        address.text = venues[position].location?.formattedAddress.toString()
        distance.text = venues[position].location?.distance.toString() + "m"

        return rowView
    }
}
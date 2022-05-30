package com.example.venue.data
import com.google.gson.annotations.SerializedName

data class Location (

    @SerializedName("address"          ) var address          : String?                   = null,
    @SerializedName("crossStreet"      ) var crossStreet      : String?                   = null,
    @SerializedName("lat"              ) var lat              : Double?                   = null,
    @SerializedName("lng"              ) var lng              : Double?                   = null,
    @SerializedName("distance"         ) var distance         : Int?                      = null,
    @SerializedName("postalCode"       ) var postalCode       : String?                   = null,
    @SerializedName("cc"               ) var cc               : String?                   = null,
    @SerializedName("city"             ) var city             : String?                   = null,
    @SerializedName("state"            ) var state            : String?                   = null,
    @SerializedName("country"          ) var country          : String?                   = null,
    @SerializedName("formattedAddress" ) var formattedAddress : ArrayList<String>         = arrayListOf()
)


data class Venues (

    @SerializedName("id"         ) var id         : String?               = null,
    @SerializedName("name"       ) var name       : String?               = null,
    @SerializedName("location"   ) var location   : Location?             = Location()
)

data class Meta (

    @SerializedName("code"      ) var code      : Int?    = null,
    @SerializedName("requestId" ) var requestId : String? = null
)

data class Response (

    @SerializedName("venues" ) var venues : ArrayList<Venues> = arrayListOf()

)
data class VenuesList (

    @SerializedName("meta"     ) var meta     : Meta?     = Meta(),
    @SerializedName("response" ) var response : Response? = Response()

)
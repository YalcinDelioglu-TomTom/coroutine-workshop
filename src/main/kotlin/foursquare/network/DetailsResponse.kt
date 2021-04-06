package foursquare.network

import com.google.gson.annotations.SerializedName
import foursquare.model.VenueDetails

data class DetailsResponse(@SerializedName("venue") val venueDetails: VenueDetails?)
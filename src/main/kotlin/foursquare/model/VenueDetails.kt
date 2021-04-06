package foursquare.model

data class VenueDetails(
    val id: String,
    val name: String?,
    val rating: Float?,
    val location: Location?,
    val bestPhoto: BestPhoto?
)
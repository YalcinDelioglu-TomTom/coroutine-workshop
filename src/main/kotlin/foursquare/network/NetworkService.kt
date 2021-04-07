package foursquare.network

import foursquare.model.Venue
import foursquare.model.VenueDetails
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

open class NetworkService private constructor() {
    object Service : NetworkService()

    companion object {
        private const val CLIENT_ID =  "Paste Your Client Id here"
        private const val CLIENT_SECRET =  "Paste Your Secret here"
        private const val NEAR =  "NEW YORK"
        private const val LIMIT =  "5"
        private const val LAT_LON_ACC =  "1000"
        private const val VERSION =  "20201121"
    }

    private val retrofit = Retrofit.Builder().apply {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
//        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val okHttpClient = OkHttpClient.Builder().build()
        baseUrl("https://api.foursquare.com/v2/venues/")
        client(okHttpClient)
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    private val venueService = retrofit.create(VenueService::class.java)

    suspend fun getVenues(searchString: String): List<Venue>? {
        return venueService.getVenues(searchString).response?.venues
    }

    suspend fun getVenueDetails(venueId: String): VenueDetails? {
        return venueService.getVenueDetails(venueId).response?.venueDetails
    }

    interface VenueService {
        @GET("search?client_id=$CLIENT_ID&client_secret=$CLIENT_SECRET&near=$NEAR&limit=$LIMIT&llAcc=$LAT_LON_ACC&v=$VERSION")
        suspend fun getVenues(@Query("query") searchString: String) : SearchResults

        @GET("{id}?client_id=$CLIENT_ID&client_secret=$CLIENT_SECRET&v=$VERSION")
        suspend fun getVenueDetails(@Path("id") venueId: String) : DetailsResult
    }
}
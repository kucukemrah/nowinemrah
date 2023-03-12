package ee.emrahkucuk.bns

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton


private const val BaseUrl = "https://api.nytimes.com"

@Singleton
class RetrofitNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory
) {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            @OptIn(ExperimentalSerializationApi::class)
            networkJson.asConverterFactory("application/json".toMediaType())
        ).build()
        .create(RetrofitNetworkApi::class.java)

    suspend fun getMostViewedArticles() = networkApi.getMostViewedArticles(BuildConfig.NYT_KEY)
}

private interface RetrofitNetworkApi {

    @GET("svc/mostpopular/v2/viewed/1.json")
    suspend fun getMostViewedArticles(
        @Query("api-key") apiKey: String
    ): MostViewedArticlesNetworkResponse

}

@kotlinx.serialization.Serializable
data class MostViewedArticlesNetworkResponse(
    val results: List<NetworkViewedArticle>
)

@kotlinx.serialization.Serializable
data class NetworkViewedArticle(
    val title: String
)

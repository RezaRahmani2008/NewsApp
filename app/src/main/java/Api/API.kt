package Api

import Model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface API {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("Sources") source: String,
        @Query("apiKey") apiKey: String
    ): Response<ResponseModel>
}
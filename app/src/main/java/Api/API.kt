package Api


interface API {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("Sources") source: String,
        @Query("apiKey") apiKey: String
    ): Response<ResponseModel>
}
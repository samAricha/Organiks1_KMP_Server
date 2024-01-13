package com.joelkanyi.focusbloom.core.data.remote


object RetrofitProvider {
    private const val TEST_URL = "https://a3fb-105-57-17-70.ngrok-free.app"
//    private const val TEST_URL = "https://c5bf-2c0f-fe38-2407-af33-288b-ff34-18af-45d1.ngrok-free.app"
    private const val BASE_URL = "http://191.101.0.246:8081"

    //here we provide the HTTP client

//    private fun provide(): Retrofit {
//        val json = Json { ignoreUnknownKeys = true }//to ignore unkown keys
//
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(provideOkhttpClient())
//            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
//            .build()
//    }

//    private fun provideOkhttpClient(): OkHttpClient =
//        OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().also {
//                it.level = HttpLoggingInterceptor.Level.BODY
//            })
//            .addInterceptor(HeaderInterceptor)
//            .build()


    fun createEggCollectionService(): EggCollectionService {
        TODO()
//        return provide().create(EggCollectionService::class.java)
    }


}
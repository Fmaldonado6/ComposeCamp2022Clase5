package com.fmaldonado.internetconnection.network

import com.fmaldonado.internetconnection.models.ApiModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<ApiModel>
}

object NetworkApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}



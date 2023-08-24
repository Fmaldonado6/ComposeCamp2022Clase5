package com.fmaldonado.internetconnection.network

import com.fmaldonado.internetconnection.BuildConfig
import com.fmaldonado.internetconnection.models.ApiModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<ApiModel>
}

private val retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()

object NetworkApi {
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

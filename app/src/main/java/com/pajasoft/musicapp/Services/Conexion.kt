package com.pajasoft.musicapp.Services

import com.pajasoft.musicapp.Models.Album
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface MusicService {

    @GET ("api/albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("api/albums/{id}")
    suspend fun getAlbumById(@Path("id") id: String) : Response<Album>
}

object RetrofitClient {
    private const val BASE_URL = "https://musicapi.pjasoft.com/"

    val apiService: MusicService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicService::class.java)
    }
}
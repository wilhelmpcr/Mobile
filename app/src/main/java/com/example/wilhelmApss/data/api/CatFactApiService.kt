package com.example.wilhelmApss.data.api

import com.example.wilhelmApss.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}

package com.example.data.api

import com.example.data.storage.models.CurrencyModel
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {

    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getCurrency(): Response<List<CurrencyModel>>
}
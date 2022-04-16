package com.example.data.api

import com.example.data.storage.models.CurrencyModel
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface CurrencyApi {

	@GET("p24api/pubinfo?json&exchange&coursid=5")
	fun getCurrency(): Flowable<List<CurrencyModel>>
}
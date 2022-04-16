package com.example.data.repoImpl

import com.example.data.api.CurrencyApi
import com.example.data.storage.converters.CurrencyModelToCurrencyDtoConverter
import com.example.domain.models.CurrencyModelDto
import com.example.domain.repository.CurrencyRepository
import io.reactivex.rxjava3.core.Flowable

class CurrencyRepositoryImpl(
	private val currencyApi: CurrencyApi,
	private val currencyDtoConverter: CurrencyModelToCurrencyDtoConverter
) : CurrencyRepository {

	override fun getCurrency(): Flowable<List<CurrencyModelDto>> =
		currencyApi.getCurrency().map {
			val response = mutableListOf<CurrencyModelDto>()
			it.forEach { response.add(currencyDtoConverter.invoke(it)) }
			response
		}
}
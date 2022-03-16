package com.example.data.repoImpl

import com.example.data.api.CurrencyApi
import com.example.data.storage.converters.CurrencyModelToCurrencyDtoConverter
import com.example.domain.models.CurrencyModelDto
import com.example.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(
    private val currencyApi: CurrencyApi,
    private val currencyDtoConverter: CurrencyModelToCurrencyDtoConverter
) : CurrencyRepository {

    override suspend fun getCurrency(): List<CurrencyModelDto> {
        val response = currencyApi.getCurrency()
        return if (response.isSuccessful) {
            response.body()!!.map { currencyDtoConverter.invoke(it) }
        } else {
            emptyList()
        }
    }
}
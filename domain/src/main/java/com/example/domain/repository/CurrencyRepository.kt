package com.example.domain.repository

import com.example.domain.models.CurrencyModelDto

interface CurrencyRepository {

    suspend fun getCurrency(): List<CurrencyModelDto>
}
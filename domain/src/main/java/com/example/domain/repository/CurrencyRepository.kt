package com.example.domain.repository

import com.example.domain.models.CurrencyModelDto
import io.reactivex.rxjava3.core.Flowable

interface CurrencyRepository {

	fun getCurrency(): Flowable<List<CurrencyModelDto>>
}
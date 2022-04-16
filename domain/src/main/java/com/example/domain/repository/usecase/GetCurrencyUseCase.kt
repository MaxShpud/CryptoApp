package com.example.domain.repository.usecase

import com.example.domain.base.UseCase
import com.example.domain.models.CurrencyModelDto
import com.example.domain.repository.CurrencyRepository
import io.reactivex.rxjava3.core.Flowable

class GetCurrencyUseCase(private val currencyRepository: CurrencyRepository) : UseCase<Unit, Flowable<List<CurrencyModelDto>>> {

	override fun execute(param: Unit?): Flowable<List<CurrencyModelDto>> {
		return currencyRepository.getCurrency()
	}
}
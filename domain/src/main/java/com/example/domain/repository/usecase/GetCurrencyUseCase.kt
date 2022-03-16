package com.example.domain.repository.usecase

import com.example.domain.base.UseCase
import com.example.domain.models.CurrencyModelDto
import com.example.domain.repository.CurrencyRepository

class GetCurrencyUseCase(private val currencyRepository: CurrencyRepository) : UseCase<Unit, List<CurrencyModelDto>> {

    override suspend fun execute(param: Unit?): List<CurrencyModelDto> {
        return currencyRepository.getCurrency()
    }
}
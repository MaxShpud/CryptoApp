package com.example.data.storage.converters

import com.example.data.storage.models.CurrencyModel
import com.example.domain.Converter
import com.example.domain.models.CurrencyModelDto

class CurrencyModelToCurrencyDtoConverter : Converter<CurrencyModel, CurrencyModelDto> {

    override fun invoke(params: CurrencyModel): CurrencyModelDto {
        return CurrencyModelDto(
            params.ccy ?: "",
            params.baseCcy ?: "",
            params.buy ?: "",
            params.sale ?: ""
        )
    }
}
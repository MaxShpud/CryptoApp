package com.example.data.storage.models

import com.google.gson.annotations.SerializedName

data class CurrencyModel(
    @SerializedName("ccy") var ccy: String? = null,
    @SerializedName("base_ccy") var baseCcy: String? = null,
    @SerializedName("buy") var buy: String? = null,
    @SerializedName("sale") var sale: String? = null
)
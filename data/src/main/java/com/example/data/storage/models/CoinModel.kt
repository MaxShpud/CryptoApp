package com.example.data.storage.models

import com.google.gson.annotations.SerializedName

data class CoinModel(
    @SerializedName("icon")var icon: String?=null,//
    @SerializedName("name")var name: String?=null,//
    @SerializedName("price")var price: String?=null,//
    @SerializedName("priceChange1d")var priceChange1d: String?=null,//
    @SerializedName("priceChange1h")var priceChange1h: String?=null,//
    @SerializedName("priceChange1w")var priceChange1w: String?=null,//
    @SerializedName("symbol")var symbol: String?=null//
)
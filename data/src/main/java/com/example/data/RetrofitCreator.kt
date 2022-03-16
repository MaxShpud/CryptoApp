package com.example.data

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitCreator {

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(SESSION_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(SESSION_TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }

    fun <ServiceClass> createService(
        gson: Gson,
        serviceClass: Class<ServiceClass>
    ): ServiceClass {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.privatbank.ua/")
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))//преобразование json в объекты
            .build()
        return retrofit.create(serviceClass)
    }

    companion object {
        private const val SESSION_TIMEOUT = 30000L
    }
}
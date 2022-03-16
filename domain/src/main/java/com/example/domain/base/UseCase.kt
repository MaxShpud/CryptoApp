package com.example.domain.base

interface UseCase<in INPUT, out OUTPUT> {

    suspend fun execute(param: INPUT? = null): OUTPUT
}
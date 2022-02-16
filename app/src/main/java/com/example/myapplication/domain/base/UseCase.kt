package com.example.myapplication.domain.base

interface UseCase<in INPUT, out OUTPUT> {

    fun execute(param: INPUT? = null): OUTPUT
}
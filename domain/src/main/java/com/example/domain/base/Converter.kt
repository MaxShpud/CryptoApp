package com.example.domain

interface Converter<INPUT, OUTPUT> {

    fun invoke(params: INPUT): OUTPUT
}
package com.example.myapplication.domain

interface Converter<INPUT, OUTPUT> {

    fun invoke(params: INPUT): OUTPUT
}
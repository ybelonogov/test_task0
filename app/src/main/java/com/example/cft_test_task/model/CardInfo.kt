package com.example.cft_test_task.model

data class CardInfo(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)

data class Number(

    val length: Int,
    val luhn: Boolean,

    )
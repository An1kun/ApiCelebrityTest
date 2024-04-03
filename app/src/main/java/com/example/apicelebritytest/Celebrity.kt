package com.example.apicelebritytest

data class Celebrity(
    val name: String,
    val age: Int,
    val networth: Long,
    val nationality: String,
    val occupation: List<String>,
    val height: Double,
    val birthday: String
) {
}
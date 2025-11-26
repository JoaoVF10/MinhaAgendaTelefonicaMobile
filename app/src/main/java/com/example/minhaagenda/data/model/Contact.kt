package com.example.minhaagenda.data.model

data class Contact(
    val id: Long = System.currentTimeMillis(),
    val name: String,
    val phone: String
)
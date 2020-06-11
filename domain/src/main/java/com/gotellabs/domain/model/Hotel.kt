package com.gotellabs.domain.model

import java.io.Serializable

data class Hotel(
    val _id: String,
    val name: String,
    val description: String,
    val phone: String = "12345678",
    val rate: String = "4.5",
    val address: Address = Address(),
    val photos: List<HotelPhoto> = listOf()
) : Serializable
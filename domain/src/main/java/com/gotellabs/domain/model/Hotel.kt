package com.gotellabs.domain.model

import java.io.Serializable

data class Hotel(
    val _id: String,
    val name: String,
    val description: String,
    val phone: String? = "97012921",
    val rate: String? = "5.0",
    val address: Address? = null,
    val photos: ArrayList<HotelPhoto> = ArrayList<HotelPhoto>()
) : Serializable
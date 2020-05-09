package com.gotellabs.domain.model

import java.io.Serializable

data class HotelModel(
    val _id: Int,
    val name: String,
    val description: String,
    val image: String? = "hi",
    val phone: String? = "97012921",
    val rate: String? = "5.0"
) : Serializable
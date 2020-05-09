package com.gotellabs.domain.model

import java.io.Serializable

data class HotelModel(
    val _id: String,
    val name: String,
    val description: String,
    val image: String? = "https://www.ahstatic.com/photos/9399_ho_00_p_1024x768.jpg",
    val phone: String? = "97012921",
    val rate: String? = "5.0"
) : Serializable
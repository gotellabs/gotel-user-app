package com.gotellabs.domain.model

import java.io.Serializable

data class HotelModel(
    val _id: String,
    val name: String,
    val description: String,
    val phone: String? = "97012921",
    val rate: String? = "5.0",
    val photos: ArrayList<PhotoModel> = ArrayList<PhotoModel>()
) : Serializable
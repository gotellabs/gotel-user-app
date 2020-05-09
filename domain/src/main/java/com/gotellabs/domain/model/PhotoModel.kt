package com.gotellabs.domain.model

import java.io.Serializable

data class PhotoModel(
    val hotelId: String,
    val imageUrl: String,
    val description: String
) : Serializable
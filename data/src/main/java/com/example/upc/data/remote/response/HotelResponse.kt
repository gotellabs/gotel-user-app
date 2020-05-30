package com.example.upc.data.remote.response

import com.google.gson.annotations.SerializedName
import com.gotellabs.domain.model.Hotel


/**
 * Created by Enzo Lizama Paredes on 5/8/20.
 * Contact: lizama.enzo@gmail.com
 */

data class HotelResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data: List<Hotel>
)
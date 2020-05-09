package com.example.upc.data.remote.response

import com.gotellabs.domain.model.HotelModel


/**
 * Created by Enzo Lizama Paredes on 5/8/20.
 * Contact: lizama.enzo@gmail.com
 */

data class HotelResponse(val success: Boolean, val hotels: List<HotelModel>) {
    fun isSuccess(): Boolean = success
}
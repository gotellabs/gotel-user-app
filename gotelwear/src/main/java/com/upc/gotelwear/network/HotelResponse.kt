package com.upc.gotelwear.network

import com.gotellabs.domain.model.Hotel


/**
 * Created by Enzo Lizama Paredes on 5/8/20.
 * Contact: lizama.enzo@gmail.com
 */

data class HotelResponse(val success: Boolean, val data: List<Hotel>) {
    fun isSuccess(): Boolean = success
}
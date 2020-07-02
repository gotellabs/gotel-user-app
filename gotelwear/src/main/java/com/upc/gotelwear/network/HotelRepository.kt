package com.upc.gotelwear.network

import com.gotellabs.domain.model.Hotel


/**
 * Created by Enzo Lizama Paredes on 4/6/20.
 * Contact: lizama.enzo@gmail.com
 */


interface HotelRepository {

    fun retrieveHotels(callback: OperationCallback<Hotel>)
    fun cancel()

}
package com.example.upc.data.repository

import com.gotellabs.domain.core.Result
import com.gotellabs.domain.model.HotelModel


/**
 * Created by Enzo Lizama Paredes on 5/24/20.
 * Contact: lizama.enzo@gmail.com
 */

interface HotelDataSource {
    interface Remote {
        suspend fun getHotels(): Result<List<HotelModel>>
    }

    interface Local : Remote {
        fun saveHotels(hotels: List<HotelModel>)
    }


}
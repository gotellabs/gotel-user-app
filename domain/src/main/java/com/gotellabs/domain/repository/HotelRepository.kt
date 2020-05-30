package com.gotellabs.domain.repository

import com.gotellabs.domain.core.Result
import com.gotellabs.domain.model.Hotel


/**
 * Created by Enzo Lizama Paredes on 4/6/20.
 * Contact: lizama.enzo@gmail.com
 */


interface HotelRepository {
    suspend fun retrieveHotels(): Result<List<Hotel>>
}
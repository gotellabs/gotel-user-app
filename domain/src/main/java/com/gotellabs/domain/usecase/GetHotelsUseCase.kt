package com.gotellabs.domain.usecase

import com.gotellabs.domain.core.Result
import com.gotellabs.domain.model.Hotel
import com.gotellabs.domain.repository.HotelRepository


/**
 * Created by Enzo Lizama Paredes on 5/24/20.
 * Contact: lizama.enzo@gmail.com
 */

open class GetHotelsUseCase(private val hotelRepository: HotelRepository) {
    suspend fun execute(): Result<List<Hotel>> {
        return hotelRepository.retrieveHotels()
    }
}
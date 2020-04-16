package com.gotellabs.domain.usecases

import com.gotellabs.domain.repository.HotelRepository


/**
 * Created by Enzo Lizama Paredes on 4/14/20.
 * Contact: lizama.enzo@gmail.com
 */

class RetrieveHotelsUseCase(private val hotelsRepository: HotelRepository) {
    suspend operator fun invoke() = hotelsRepository.retrieveHotels()
}
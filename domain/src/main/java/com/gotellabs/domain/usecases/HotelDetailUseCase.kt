package com.gotellabs.domain.usecases

import com.gotellabs.domain.repository.HotelRepository


/**
 * Created by Enzo Lizama Paredes on 4/15/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelDetailUseCase(private val hotelsRepository: HotelRepository) {
    suspend operator fun invoke(hotelId: Int) =
        hotelsRepository.retrieveHotelDetail(hotelId = hotelId)
}
package com.gotellabs.domain.usecases

import com.gotellabs.domain.repository.HotelRepository


/**
 * Created by Enzo Lizama Paredes on 4/16/20.
 * Contact: lizama.enzo@gmail.com
 */

class SearchHotelsUseCase(private val hotelRepository: HotelRepository) {
    suspend operator fun invoke(params: String) = hotelRepository.searchHotel(params)
}
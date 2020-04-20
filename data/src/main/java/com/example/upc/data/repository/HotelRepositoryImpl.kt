package com.example.upc.data.repository

import com.gotellabs.domain.model.HotelModel
import com.gotellabs.domain.repository.HotelRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi


/**
 * Created by Enzo Lizama Paredes on 4/9/20.
 * Contact: lizama.enzo@gmail.com
 */

@ExperimentalCoroutinesApi
class HotelRepositoryImpl : HotelRepository {

    override suspend fun retrieveHotels(): List<HotelModel> {
        TODO("Not yet implemented")
    }

    override suspend fun searchHotel(params: String): List<HotelModel> {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveHotelDetail(hotelId: Int): HotelModel {
        TODO("Not yet implemented")
    }

}
package com.gotellabs.domain.repository

import com.gotellabs.domain.model.HotelModel


/**
 * Created by Enzo Lizama Paredes on 4/6/20.
 * Contact: lizama.enzo@gmail.com
 */


interface HotelRepository {

    suspend fun retrieveHotels(): List<HotelModel>

    suspend fun searchHotel(params: String): List<HotelModel>

    // TODO: Change the response model from the network call
    suspend fun retrieveHotelDetail(hotelId: Int): HotelModel
}
package com.example.upc.data.repository

import com.gotellabs.domain.model.HotelModel
import com.gotellabs.domain.repository.HotelRepository


/**
 * Created by Enzo Lizama Paredes on 4/9/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelRepositoryImpl : HotelRepository {

//    override fun retrieveHotels(callback: OperationCallback<HotelModel>) {
//        val mockHotels = MockData.mockHotelList
//        if (mockHotels.isNotEmpty()) {
//            callback.onSuccess(mockHotels)
//        } else {
//            callback.onError("No hay telos :(")
//        }
//    }

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
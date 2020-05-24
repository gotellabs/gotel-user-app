package com.example.upc.data.repository

import com.gotellabs.domain.core.Result
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.domain.repository.HotelRepository


/**
 * Created by Enzo Lizama Paredes on 4/9/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelRepositoryImpl(
    private val hotelRemoteDataSource: HotelRemoteDataSource,
    private val hotelLocalDataSource: HotelLocalDataSource
) : HotelRepository {


    override suspend fun retrieveHotels(): Result<List<HotelModel>> {
        return getHotelsFromLocalDataSource()
    }


    private suspend fun getHotelsFromLocalDataSource(): Result<List<HotelModel>> {
        return when (val result = hotelLocalDataSource.getHotels()) {
            is Result.Success -> {
                result
            }
            is Result.Error -> {
                getHotelsFromRemoteDataSource()
            }
        }
    }

    private suspend fun getHotelsFromRemoteDataSource(): Result<List<HotelModel>> {
        val result = hotelRemoteDataSource.getHotels()
        if (result is Result.Success) {
            updateLocalHotels(hotels = result.data)
        }
        return result
    }

    private fun updateLocalHotels(hotels: List<HotelModel>) {
        hotelLocalDataSource.saveHotels(hotels)
    }

}
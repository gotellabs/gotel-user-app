package com.example.upc.data.repository

import com.example.upc.data.exception.DataNotAvailableException
import com.example.upc.data.local.HotelDao
import com.example.upc.data.mapper.HotelMapper
import com.example.upc.data.util.DiskExecutor
import com.gotellabs.domain.core.Result
import com.gotellabs.domain.model.Hotel


/**
 * Created by Enzo Lizama Paredes on 5/24/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelLocalDataSource(private val hotelDao: HotelDao, private val executor: DiskExecutor) :
    HotelDataSource.Local {

    override fun saveHotels(hotels: List<Hotel>) {
        executor.execute {
            hotelDao.saveHotels(hotels = hotels.map { HotelMapper.toEntity(it) })
        }
    }

    override suspend fun getHotels(): Result<List<Hotel>> {
        val hotels = hotelDao.getHotels()
        return if (hotels.isNotEmpty()) {
            Result.Success(hotels.map { HotelMapper.toDomain(it) })
        } else {
            Result.Error(DataNotAvailableException())
        }
    }

}
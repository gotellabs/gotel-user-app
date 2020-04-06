package com.example.upc.data.local.database

import com.example.upc.data.local.dao.HotelDao
import com.gotellabs.domain.model.HotelModel


/**
 * Created by Enzo Lizama Paredes on 4/5/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelDatabaseClient(private val hotelDao: HotelDao) : HotelDatabase {
    override suspend fun getAll(): List<HotelModel> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(hotel: HotelModel) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(hotel: HotelModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }

}
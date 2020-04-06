package com.example.upc.data.local.database

import com.gotellabs.domain.model.HotelModel


/**
 * Created by Enzo Lizama Paredes on 4/5/20.
 * Contact: lizama.enzo@gmail.com
 */

interface HotelDatabase {
    suspend fun getAll(): List<HotelModel>
    suspend fun insert(hotel: HotelModel)
    suspend fun delete(hotel: HotelModel)
    suspend fun deleteAll()
}
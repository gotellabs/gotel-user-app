package com.example.upc.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * Created by Enzo Lizama Paredes on 5/24/20.
 * Contact: lizama.enzo@gmail.com
 */

@Dao
interface HotelDao {
    @Query("SELECT * FROM hotels")
    fun getHotels(): List<HotelEntity>

    @Query("DELETE FROM hotels")
    fun deleteHotels()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveHotels(hotels: List<HotelEntity>)
}
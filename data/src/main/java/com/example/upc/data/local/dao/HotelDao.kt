package com.example.upc.data.local.dao

import androidx.room.*
import com.example.upc.data.local.entity.HotelEntity


/**
 * Created by Enzo Lizama Paredes on 4/5/20.
 * Contact: lizama.enzo@gmail.com
 */

@Dao
abstract class HotelDao {

    @Query("SELECT * FROM hotel")
    abstract suspend fun getAll(): List<HotelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(hotel: HotelEntity)

    @Delete
    abstract suspend fun delete(hotel: HotelEntity)

    @Query("DELETE FROM hotel")
    abstract suspend fun deleteAll()
}
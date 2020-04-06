package com.example.upc.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.upc.data.local.dao.HotelDao
import com.example.upc.data.local.entity.HotelEntity


/**
 * Created by Enzo Lizama Paredes on 4/5/20.
 * Contact: lizama.enzo@gmail.com
 */

@Database(entities = [HotelEntity::class], version = 1, exportSchema = false)
abstract class GotelDatabase : RoomDatabase() {
    abstract val hotelDao: HotelDao
}
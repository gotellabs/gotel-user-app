package com.example.upc.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * Created by Enzo Lizama Paredes on 5/24/20.
 * Contact: lizama.enzo@gmail.com
 */

const val DATABASE_VERSION_CODE: Int = 2

@Database(entities = [HotelEntity::class], version = DATABASE_VERSION_CODE, exportSchema = false)
abstract class GotelDatabase : RoomDatabase() {
    abstract fun hotelDao(): HotelDao
}
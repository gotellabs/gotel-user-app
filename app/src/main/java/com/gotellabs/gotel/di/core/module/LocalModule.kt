package com.gotellabs.gotel.di.core.module

import android.content.Context
import androidx.room.Room
import com.example.upc.data.local.GotelDatabase
import com.example.upc.data.local.HotelDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Enzo Lizama Paredes on 5/28/20.
 * Contact: lizama.enzo@gmail.com
 */

@Module
class LocalModule {
    @Provides
    @Singleton
    fun providesGotelDatabase(context: Context): GotelDatabase {
        return Room.databaseBuilder(context, GotelDatabase::class.java, "gotel.db").build()
    }

    @Provides
    fun providesHotelDao(gotelDatabase: GotelDatabase): HotelDao {
        return gotelDatabase.hotelDao()
    }
}
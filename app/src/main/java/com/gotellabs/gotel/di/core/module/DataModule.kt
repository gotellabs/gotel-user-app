package com.gotellabs.gotel.di.core.module

import com.example.upc.data.local.HotelDao
import com.example.upc.data.remote.GotelService
import com.example.upc.data.repository.HotelDataSource
import com.example.upc.data.repository.HotelLocalDataSource
import com.example.upc.data.repository.HotelRemoteDataSource
import com.example.upc.data.repository.HotelRepositoryImpl
import com.example.upc.data.util.DiskExecutor
import com.gotellabs.domain.repository.HotelRepository
import com.gotellabs.domain.usecase.GetHotelsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Enzo Lizama Paredes on 5/28/20.
 * Contact: lizama.enzo@gmail.com
 */

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideHotelRepository(
        hotelRemote: HotelDataSource.Remote,
        hotelLocal: HotelDataSource.Local
    ): HotelRepository = HotelRepositoryImpl(hotelRemote, hotelLocal)

    @Provides
    @Singleton
    fun provideHotelLocalDataSource(
        executor: DiskExecutor,
        hotelDao: HotelDao
    ): HotelDataSource.Local = HotelLocalDataSource(hotelDao, executor)

    @Provides
    @Singleton
    fun provideHotelRemoteDataSource(hotelService: GotelService): HotelDataSource.Remote =
        HotelRemoteDataSource(hotelService)

    @Provides
    fun provideGetHotelsUseCase(hotelRepository: HotelRepository): GetHotelsUseCase =
        GetHotelsUseCase(hotelRepository)
}
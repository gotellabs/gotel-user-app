package com.gotellabs.gotel.di

import androidx.lifecycle.ViewModelProvider
import com.example.upc.data.repository.HotelRepositoryImpl
import com.gotellabs.domain.repository.HotelRepository
import com.gotellabs.gotel.core.ViewModelFactory


/**
 * Created by Enzo Lizama Paredes on 5/8/20.
 * Contact: lizama.enzo@gmail.com
 */
/**
 * A simple dependency injection approach. Easy than Dagger. Just for simplicity
 */
object ServiceLocator {
    private val hotelRepository: HotelRepository = HotelRepositoryImpl()
    private val museumViewModelFactory = ViewModelFactory(hotelRepository)

    fun providerRepository(): HotelRepository {
        return hotelRepository
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return museumViewModelFactory
    }
}
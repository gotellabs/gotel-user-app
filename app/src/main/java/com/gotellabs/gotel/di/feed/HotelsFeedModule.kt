package com.gotellabs.gotel.di.feed

import com.gotellabs.domain.usecase.GetHotelsUseCase
import com.gotellabs.gotel.core.DispatcherProvider
import com.gotellabs.gotel.ui.feed.HotelFeedViewModelFactory
import dagger.Module
import dagger.Provides


/**
 * Created by Enzo Lizama Paredes on 5/28/20.
 * Contact: lizama.enzo@gmail.com
 */


@Module
class HotelsFeedModule {
    @Provides
    fun provideHotelFeedViewModelFactory(
        getHotelsUseCase: GetHotelsUseCase,
        dispatcherProvider: DispatcherProvider
    ): HotelFeedViewModelFactory = HotelFeedViewModelFactory(getHotelsUseCase, dispatcherProvider)
}
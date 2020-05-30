package com.gotellabs.gotel.di.core

import com.gotellabs.gotel.di.core.module.AppModule
import com.gotellabs.gotel.di.core.module.DataModule
import com.gotellabs.gotel.di.core.module.LocalModule
import com.gotellabs.gotel.di.core.module.NetworkModule
import com.gotellabs.gotel.di.feed.HotelFeedSubComponent
import com.gotellabs.gotel.di.feed.HotelsFeedModule
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Enzo Lizama Paredes on 5/28/20.
 * Contact: lizama.enzo@gmail.com
 */

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        LocalModule::class,
        DataModule::class
    ]
)
interface CoreComponent {
    fun create(hotelsFeedModule: HotelsFeedModule): HotelFeedSubComponent
}
package com.gotellabs.gotel.di

import com.gotellabs.gotel.di.feed.HotelFeedSubComponent


/**
 * Created by Enzo Lizama Paredes on 5/27/20.
 * Contact: lizama.enzo@gmail.com
 */

interface DaggerInjector {
    fun createHotelFeedComponent(): HotelFeedSubComponent
}
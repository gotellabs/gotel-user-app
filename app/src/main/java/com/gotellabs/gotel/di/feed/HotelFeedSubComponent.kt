package com.gotellabs.gotel.di.feed

import com.gotellabs.gotel.ui.feed.HotelsActivity
import dagger.Subcomponent


/**
 * Created by Enzo Lizama Paredes on 5/28/20.
 * Contact: lizama.enzo@gmail.com
 */

@Subcomponent(modules = [HotelsFeedModule::class])
interface HotelFeedSubComponent {
    fun inject(hotelsActivity: HotelsActivity)
}
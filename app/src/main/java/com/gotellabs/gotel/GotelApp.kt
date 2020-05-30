package com.gotellabs.gotel

import android.app.Application
import com.gotellabs.gotel.di.DaggerInjector
import com.gotellabs.gotel.di.core.CoreComponent
import com.gotellabs.gotel.di.core.DaggerCoreComponent
import com.gotellabs.gotel.di.core.module.AppModule
import com.gotellabs.gotel.di.core.module.DataModule
import com.gotellabs.gotel.di.core.module.LocalModule
import com.gotellabs.gotel.di.core.module.NetworkModule
import com.gotellabs.gotel.di.feed.HotelFeedSubComponent
import com.gotellabs.gotel.di.feed.HotelsFeedModule


/**
 * Created by Enzo Lizama Paredes on 3/29/20.
 * Contact: lizama.enzo@gmail.com
 */

/**
 * Here if is necessary.
 *
 */
class GotelApp : Application(), DaggerInjector {

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule("https://us-central1-gotel-api.cloudfunctions.net"))
            .localModule(LocalModule())
            .dataModule(DataModule())
            .build()

    }

    override fun createHotelFeedComponent(): HotelFeedSubComponent {
        return coreComponent.create(HotelsFeedModule())
    }

}
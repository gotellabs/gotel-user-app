package com.gotellabs.gotel

import android.app.Application
import com.gotellabs.gotel.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 3/29/20.
 * Contact: lizama.enzo@gmail.com
 */

@ExperimentalCoroutinesApi
class GotelApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .create(this)
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}
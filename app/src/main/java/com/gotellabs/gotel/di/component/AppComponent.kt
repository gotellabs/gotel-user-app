package com.gotellabs.gotel.di.component

import android.app.Application
import com.gotellabs.gotel.GotelApp
import com.gotellabs.gotel.di.builder.ActivityBuilder
import com.gotellabs.gotel.di.module.ViewModelFactoryModule
import com.gotellabs.gotel.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


@ExperimentalCoroutinesApi
@Singleton
@Component(modules = [AndroidInjectionModule::class, ViewModelFactoryModule::class, ViewModelModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<GotelApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: GotelApp)
}
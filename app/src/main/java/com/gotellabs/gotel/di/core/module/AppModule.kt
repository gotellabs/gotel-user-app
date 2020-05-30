package com.gotellabs.gotel.di.core.module

import android.content.Context
import com.example.upc.data.util.DiskExecutor
import com.gotellabs.gotel.core.DispatcherProvider
import com.gotellabs.gotel.core.DispatcherProviderImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Enzo Lizama Paredes on 5/28/20.
 * Contact: lizama.enzo@gmail.com
 */

@Module
class AppModule constructor(context: Context) {
    private val appContext = context.applicationContext

    @Singleton
    @Provides
    fun providesAppContext(): Context = appContext

    @Provides
    fun providesDiskExecutor(): DiskExecutor = DiskExecutor()

    @Provides
    fun providesDispatcherProvider(): DispatcherProvider = DispatcherProviderImplementation()
}
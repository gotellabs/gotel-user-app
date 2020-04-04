package com.gotellabs.gotel.di.module

import androidx.lifecycle.ViewModelProvider
import com.gotellabs.gotel.di.ViewModelProviderFactory
import dagger.Binds
import dagger.Module


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}
package com.gotellabs.gotel.di.builder

import com.gotellabs.gotel.ui.hotels.HotelsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindHotelsActivity(): HotelsActivity

}
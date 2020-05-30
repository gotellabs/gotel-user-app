package com.gotellabs.gotel.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher


/**
 * Created by Enzo Lizama Paredes on 5/27/20.
 * Contact: lizama.enzo@gmail.com
 */

class DispatcherProviderImplementation : DispatcherProvider {

    override fun getIO(): CoroutineDispatcher = Dispatchers.IO

    override fun getMain(): MainCoroutineDispatcher = Dispatchers.Main

    override fun getDefault(): CoroutineDispatcher = Dispatchers.Default

}
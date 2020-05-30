package com.gotellabs.gotel.core

import kotlinx.coroutines.CoroutineDispatcher


/**
 * Created by Enzo Lizama Paredes on 5/27/20.
 * Contact: lizama.enzo@gmail.com
 */

interface DispatcherProvider {
    fun getIO(): CoroutineDispatcher
    fun getMain(): CoroutineDispatcher
    fun getDefault(): CoroutineDispatcher
}
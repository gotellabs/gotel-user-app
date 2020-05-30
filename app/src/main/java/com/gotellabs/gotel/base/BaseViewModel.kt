package com.gotellabs.gotel.base

import androidx.lifecycle.ViewModel
import com.gotellabs.gotel.core.DispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


/**
 * Created by Enzo Lizama Paredes on 5/27/20.
 * Contact: lizama.enzo@gmail.com
 */

abstract class BaseViewModel(
    private val dispatchers: DispatcherProvider
) : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = dispatchers.getMain() + SupervisorJob()

    fun execute(job: suspend () -> Unit) = launch {
        withContext(dispatchers.getIO()) { job.invoke() }
    }
}
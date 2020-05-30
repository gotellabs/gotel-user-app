package com.example.upc.data.util

import java.util.concurrent.Executor
import java.util.concurrent.Executors


/**
 * Created by Enzo Lizama Paredes on 5/27/20.
 * Contact: lizama.enzo@gmail.com
 */

class DiskExecutor : Executor {

    private val diskExecutor: Executor = Executors.newSingleThreadExecutor()
    override fun execute(command: Runnable) {
        diskExecutor.execute(command)
    }

}
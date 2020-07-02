package com.upc.gotelwear.network


/**
 * Created by Enzo Lizama Paredes on 4/9/20.
 * Contact: lizama.enzo@gmail.com
 */
interface OperationCallback<T> {
    fun onSuccess(data: List<T>)
    fun onError(error: String?)
}
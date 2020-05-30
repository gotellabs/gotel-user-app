package com.gotellabs.gotel.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gotellabs.domain.usecase.GetHotelsUseCase
import com.gotellabs.gotel.core.DispatcherProvider


/**
 * Created by Enzo Lizama Paredes on 5/29/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelFeedViewModelFactory(
    private val getHotelsUseCase: GetHotelsUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HotelsViewModel(getHotelsUseCase, dispatcherProvider) as T
    }

}
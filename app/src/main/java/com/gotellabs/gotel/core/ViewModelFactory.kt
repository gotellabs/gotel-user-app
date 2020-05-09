package com.gotellabs.gotel.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gotellabs.domain.repository.HotelRepository
import com.gotellabs.gotel.ui.hotels.HotelsViewModel


/**
 * Created by Enzo Lizama Paredes on 5/8/20.
 * Contact: lizama.enzo@gmail.com
 */

/**
 * Provides the [ViewModel] the necessary information to work
 *
 * @property repository
 */
class ViewModelFactory(private val repository: HotelRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HotelsViewModel(repository) as T
    }
}
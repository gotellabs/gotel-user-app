package com.gotellabs.gotel.ui.hotels

import androidx.recyclerview.widget.RecyclerView
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.databinding.HotelItemBinding


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


class HotelsViewHolder(private val binding: HotelItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(hotelModel: HotelModel, onItemClickListener: OnItemClickListener? = null) {

        binding.hotelName.text = hotelModel.name

        onItemClickListener?.let { listener ->
            binding.root.setOnClickListener {
                listener.onItemClicked(hotelModel, binding.imageView)
            }
        }
    }
}
package com.gotellabs.gotel.ui.hotels

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.databinding.HotelItemBinding


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


class HotelsViewHolder(private val binding: HotelItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        hotelModel: HotelModel,
        onItemClickListener: HotelsAdapter.OnItemClickListener? = null
    ) {
        binding.hotelName.text = hotelModel.name
        binding.hotelDescription.text = hotelModel.description
        Glide.with(binding.hotelItemImageView.context)
            .load("https://www.ahstatic.com/photos/9399_ho_00_p_1024x768.jpg")
            .into(binding.hotelItemImageView)
        binding.hotelCardView.setOnClickListener {
            onItemClickListener?.onItemClicked(hotelModel)
        }
    }
}
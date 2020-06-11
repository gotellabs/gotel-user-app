package com.gotellabs.gotel.ui.feed

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gotellabs.domain.model.Hotel
import com.gotellabs.gotel.databinding.HotelItemBinding


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


class HotelsViewHolder(private val binding: HotelItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        hotel: Hotel,
        onItemClickListener: HotelsAdapter.OnItemClickListener? = null
    ) {
        binding.hotelName.text = hotel.name
        binding.hotelDescription.text = hotel.description
        if (hotel.photos.isEmpty()) {
            Glide.with(binding.hotelItemImageView.context)
                .load("https://r-cf.bstatic.com/images/hotel/max1024x768/210/210875998.jpg")
                .centerCrop()
                .into(binding.hotelItemImageView)
        } else {
            Glide.with(binding.hotelItemImageView.context)
                .load(hotel.photos[0].imageUrl)
                .centerCrop()
                .into(binding.hotelItemImageView)
        }
        binding.hotelCardView.setOnClickListener {
            onItemClickListener?.onItemClicked(hotel)
        }
    }
}
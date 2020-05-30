package com.gotellabs.gotel.ui.feed

import androidx.recyclerview.widget.RecyclerView
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
//        if(hotel.hotelPhotos.isEmpty()){
//            Glide.with(binding.hotelItemImageView.context)
//                .load("https://www.ahstatic.com/hotelPhotos/9399_ho_00_p_1024x768.jpg")
//                .into(binding.hotelItemImageView)
//        }
//        else{
//            Glide.with(binding.hotelItemImageView.context)
//                .load(hotel.hotelPhotos[0].imageUrl)
//                .into(binding.hotelItemImageView)
//        }
        binding.hotelCardView.setOnClickListener {
            onItemClickListener?.onItemClicked(hotel)
        }
    }
}
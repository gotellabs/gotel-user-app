package com.gotellabs.gotel.ui.hotels

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.databinding.HotelItemBinding


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


class HotelsAdapter(
    private val hotels: List<HotelModel>,
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<HotelsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder =
        HotelsViewHolder(
            HotelItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = hotels.size

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) =
        holder.bind(hotels[position], onItemClickListener)

    interface OnItemClickListener {
        fun onItemClicked(hotel: HotelModel, imageView: ImageView)
    }


}


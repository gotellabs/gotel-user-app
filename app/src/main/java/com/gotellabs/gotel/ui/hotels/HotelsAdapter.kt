package com.gotellabs.gotel.ui.hotels

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.databinding.HotelItemBinding


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


class HotelsAdapter(private val onItemClickListener: OnItemClickListener) :
    ListAdapter<HotelModel, HotelsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder =
        HotelsViewHolder(
            HotelItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClickListener)

    interface OnItemClickListener {
        fun onItemClicked(hotel: HotelModel, imageView: ImageView)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HotelModel>() {
            override fun areItemsTheSame(oldItem: HotelModel, newItem: HotelModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HotelModel, newItem: HotelModel): Boolean {
                return oldItem == newItem
            }

        }
    }

}


package com.gotellabs.gotel.ui.hotels

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gotellabs.domain.model.HotelModel


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


class HotelsAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<HotelsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

interface OnItemClickListener {
    fun onItemClicked(hotel: HotelModel, imageView: ImageView)
}
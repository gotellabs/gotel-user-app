package com.upc.gotelwear.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gotellabs.domain.model.HotelModel
import com.upc.gotelwear.R
import kotlinx.android.synthetic.main.hotel_item.view.*

class HotelWearAdapter(
    private var hotels: List<HotelModel>, var context: Context
) :
    RecyclerView.Adapter<HotelWearAdapter.HotelsWearViewHolder>() {

    inner class HotelsWearViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.hotelImageView
        val hotelName= itemView.hotel_name
        val hotelDescription = itemView.hotel_description
        fun bindTo(hotel: HotelModel){
            hotelName.text = hotel.name
            hotelDescription.text = hotel.description
            if(hotel.image != null){
                Glide
                    .with(context)
                    .load(hotel.image)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageView)
            }else{
                Glide
                    .with(context)
                    .load("https://www.ahstatic.com/photos/9399_ho_00_p_1024x768.jpg")
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageView)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsWearViewHolder {
        return HotelsWearViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.hotel_item,parent,false))
    }

    override fun onBindViewHolder(holder: HotelsWearViewHolder, position: Int) {
        holder.bindTo(hotels[position])
    }

    override fun getItemCount(): Int {
        return hotels.size
    }


}

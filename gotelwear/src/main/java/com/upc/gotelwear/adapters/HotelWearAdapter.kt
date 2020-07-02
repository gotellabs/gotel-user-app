package com.upc.gotelwear.adapters
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gotellabs.domain.model.Hotel
import com.upc.gotelwear.R
import com.upc.gotelwear.controllers.HotelDetailActivity
import kotlinx.android.synthetic.main.hotel_item.view.*

class HotelWearAdapter(
    private var hotels: List<Hotel>, var context: Context
) :
    RecyclerView.Adapter<HotelWearAdapter.HotelsWearViewHolder>() {

    inner class HotelsWearViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.hotelImageView
        val hotelName= itemView.hotel_name
        val hotelDescription = itemView.hotel_description
        val hotelConstraint=itemView.constraint
        fun bindTo(hotel: Hotel){
            hotelName.text = hotel.name
            hotelDescription.text = hotel.description
            hotelConstraint.setOnClickListener {
                val intent= Intent(context,HotelDetailActivity::class.java)
                intent.putExtra("hotel", hotel)
                context.startActivity(intent)
            }
            if(hotel.photos.isNotEmpty()){
                Glide
                    .with(context)
                    .load(hotel.photos[0].imageUrl)
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

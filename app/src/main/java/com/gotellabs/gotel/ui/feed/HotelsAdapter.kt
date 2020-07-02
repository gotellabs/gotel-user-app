package com.gotellabs.gotel.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.gotellabs.domain.model.Hotel
import com.gotellabs.gotel.databinding.HotelItemBinding


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


class HotelsAdapter(
    private var hotels: List<Hotel>,
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<HotelsViewHolder>(), Filterable {

    lateinit var allHotels: ArrayList<Hotel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder =
        HotelsViewHolder(
            HotelItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = hotels.size

    fun update(data: List<Hotel>) {
        hotels = data
        allHotels = ArrayList(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        holder.bind(hotels[position], onItemClickListener)
    }


    interface OnItemClickListener {
        fun onItemClicked(hotel: Hotel)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {

                val filteredList = ArrayList<Hotel>()

                if (p0.toString().isEmpty()) {
                    filteredList.addAll(allHotels)
                } else {
                    for (h in allHotels) {
                        if (h.address.district.toLowerCase()
                                .contains(p0.toString().toLowerCase())
                        ) {
                            filteredList.add(h)
                        }
                    }
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList

                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                hotels = p1?.values as List<Hotel>

                notifyDataSetChanged()
            }
        }
    }
}


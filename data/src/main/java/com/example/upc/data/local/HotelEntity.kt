package com.example.upc.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Enzo Lizama Paredes on 5/27/20.
 * Contact: lizama.enzo@gmail.com
 */
@Entity(tableName = "hotels")
data class HotelEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String
)
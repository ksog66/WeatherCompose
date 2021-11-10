package com.notchdev.weathercompose.data.source.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.notchdev.weathercompose.data.source.remote.dto.ListItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@ProvidedTypeConverter
class DataConverter(
    private val moshi: Moshi
) {
    private val type  = Types.newParameterizedType(List::class.java,ListItem::class.java)
    private val moshiAdapter = moshi.adapter<List<ListItem>>(type)

    @TypeConverter
    fun fromListItemToList(list:List<ListItem>):String {
        return moshiAdapter.toJson(list)
    }

    @TypeConverter
    fun fromListToListItem(json:String?):List<ListItem> {
        return moshiAdapter.fromJson(json).orEmpty()
    }
}
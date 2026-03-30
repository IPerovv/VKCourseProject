package com.iperovv.vkcourseproject.data.local.util

import androidx.room.TypeConverter
import com.iperovv.vkcourseproject.domain.model.AppCategory
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun fromList(value: List<String>?): String? = value?.let { Json.Default.encodeToString(it) }

    @TypeConverter
    fun toList(value: String?): List<String>? =
        try {
            value?.let { Json.Default.decodeFromString<List<String>>(it) }
        } catch (e: SerializationException) {
            emptyList()
        }

    @TypeConverter
    fun fromCategory(category: AppCategory): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): AppCategory = AppCategory.valueOf(categoryName)
}

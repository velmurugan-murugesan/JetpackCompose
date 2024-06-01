package com.example.jetpackcomposetesting.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters


@Entity
data class User(@PrimaryKey(autoGenerate = true)val id: Int, val name: String, val age: Int, val email: String)


@Entity
data class Post(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String, val desc: String, val imageUrl: String,
    val tags: List<String>
)

class ListStringConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",").map { it.trim() } // Split by comma, trim spaces
    }

    @TypeConverter
    fun toString(list: List<String>): String {
        return list.joinToString(",") // Join with comma separator
    }
}
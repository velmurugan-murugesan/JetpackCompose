package com.example.jetpackcomposetesting.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetpackcomposetesting.data.dao.PostDao
import com.example.jetpackcomposetesting.data.model.ListStringConverter
import com.example.jetpackcomposetesting.data.model.Post

@Database(entities = [Post::class], version = 1)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
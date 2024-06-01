package com.example.jetpackcomposetesting.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackcomposetesting.data.AppDatabase
import com.example.jetpackcomposetesting.data.dao.PostDao
import com.example.jetpackcomposetesting.data.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "my_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePostDao(appDatabase: AppDatabase) = appDatabase.postDao()

    @Provides
    @Singleton
    fun provideUserRepository(postDao: PostDao) = PostRepository(postDao)



}
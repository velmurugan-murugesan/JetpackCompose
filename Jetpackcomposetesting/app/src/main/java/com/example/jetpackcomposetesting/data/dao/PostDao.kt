package com.example.jetpackcomposetesting.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jetpackcomposetesting.data.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    fun getPost(): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: Post)


    @Query("SELECT * FROM post WHERE id = :id")
    fun getPostById(id: Int): Flow<Post>

    @Query("DELETE FROM post WHERE id = :id")
    fun deletePostById(id: Int)

    @Query("DELETE FROM post")
    suspend fun deleteAll()

    @Query("SELECT COUNT(id) FROM post")
    suspend fun getCount(): Int


}
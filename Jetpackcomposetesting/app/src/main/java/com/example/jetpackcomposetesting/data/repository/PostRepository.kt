package com.example.jetpackcomposetesting.data.repository

import com.example.jetpackcomposetesting.data.dao.PostDao
import com.example.jetpackcomposetesting.data.model.Post
import javax.inject.Inject

class PostRepository @Inject constructor (private val postDao: PostDao){


    fun getPosts() = postDao.getPost()

    suspend fun insertPost(post: Post) = postDao.insertPost(post)


    suspend fun deletePostById(id: Int) = postDao.deletePostById(id)

    suspend fun updatePost(post: Post) = postDao.insertPost(post)


}
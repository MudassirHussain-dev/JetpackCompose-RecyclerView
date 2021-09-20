package com.example.jetpackcomposestarting.data.retrofit.repository


import com.example.jetpackcomposestarting.data.retrofit.Post
import com.example.jetpackcomposestarting.data.retrofit.network.ApiSerivice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiSerivice: ApiSerivice) {
    fun getPost(): Flow<List<Post>> = flow {
        emit(apiSerivice.getPost())
    }.flowOn(Dispatchers.IO)
}
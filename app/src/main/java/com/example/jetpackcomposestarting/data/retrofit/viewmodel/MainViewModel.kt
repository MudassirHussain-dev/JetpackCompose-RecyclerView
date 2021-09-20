package com.example.jetpackcomposestarting.data.retrofit.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposestarting.data.retrofit.Post
import com.example.jetpackcomposestarting.data.retrofit.repository.MainRepository
import com.example.jetpackcomposestarting.data.retrofit.state.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    val response: MutableState<ApiState> = mutableStateOf(ApiState.Empty)
    init {
        getPost()
    }

       fun getPost() = viewModelScope.launch {
           mainRepository.getPost().onStart {
               response.value = ApiState.Loading
           }.catch {
               response.value = ApiState.Failure(it)
           }.collect {
               response.value = ApiState.Success(it)
           }
       }


   /* val response: MutableState<ApiState<Post>> = mutableStateOf(ApiState.Empty())
    fun getPost() = viewModelScope.launch {
        mainRepository.getPost().onStart {
            response.value = ApiState.Loading()
        }.catch {
            response.value = ApiState.Failure(it)
        }.collect { data ->
            response.value = ApiState.Success()
        }
    }*/


}
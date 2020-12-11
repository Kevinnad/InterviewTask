package com.example.myapplication.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.ApiListResponse
import com.example.myapplication.model.ResultList
import com.example.myapplication.network.ResultWrapper
import com.example.myapplication.repositories.ApiRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel @ViewModelInject constructor(private val apiRepo: ApiRepo) : ViewModel() {

    val listResponseData = MutableLiveData<ApiListResponse>()
    val errorValue = MutableLiveData<String>()
    var selectedPositon = 0
    val apiList : ArrayList<ResultList> = ArrayList()

    fun fetchList(){

        viewModelScope.launch(Dispatchers.Default) {

            val listResponse = apiRepo.fetchList()

            when(listResponse){

                is ResultWrapper.Success ->{
                    listResponseData.postValue(listResponse.value)
                }
                is ResultWrapper.NetworkError -> {
                    errorValue.postValue(listResponse.value)
                }
                is ResultWrapper.GenericError -> {
                    errorValue.postValue(listResponse.value)
                }
            }
        }


    }
}
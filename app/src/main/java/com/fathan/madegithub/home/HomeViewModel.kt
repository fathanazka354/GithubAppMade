package com.fathan.madegithub.home

import androidx.lifecycle.*
import com.fathan.madegithub.core.data.Resource
import com.fathan.madegithub.core.domain.model.User
import com.fathan.madegithub.core.domain.usecase.UserUseCase

class HomeViewModel(private val userUseCase: UserUseCase):ViewModel() {
    private var username: MutableLiveData<String> = MutableLiveData()

    fun setSearch(query: String){
        if (username.value == query){
            return
        }
        username.value = query
    }

    val users:LiveData<Resource<List<User>>> = Transformations.switchMap(username){
        userUseCase.getAllUser(it).asLiveData()
    }
}
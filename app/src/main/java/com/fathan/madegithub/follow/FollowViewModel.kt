package com.fathan.madegithub.follow

import androidx.lifecycle.*
import com.fathan.madegithub.core.data.Resource
import com.fathan.madegithub.core.domain.model.User
import com.fathan.madegithub.core.domain.usecase.UserUseCase
enum class TypeView{
    FOLLOWER,
    FOLLOWING,
}
class FollowViewModel(private val userUseCase: UserUseCase):ViewModel() {
    private var username: MutableLiveData<String> = MutableLiveData()
    private lateinit var typeView:TypeView

    fun setFollow(user: String, type: TypeView){
        if (username.value == user){
            return
        }
        username.value = user
        typeView = type
    }

    val favoriteUsers: LiveData<Resource<List<User>>> = Transformations.switchMap(username){
        when(typeView){
            TypeView.FOLLOWER -> userUseCase.getFollowers(it).asLiveData()
            TypeView.FOLLOWING -> userUseCase.getFollowing(it).asLiveData()
        }
    }

}
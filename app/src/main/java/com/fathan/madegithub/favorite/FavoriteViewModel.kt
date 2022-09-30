package com.fathan.madegithub.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fathan.madegithub.core.domain.usecase.UserUseCase

class FavoriteViewModel(private val useCase: UserUseCase):ViewModel() {
    val favoriteUsers = useCase.getFavoriteUser().asLiveData()
}
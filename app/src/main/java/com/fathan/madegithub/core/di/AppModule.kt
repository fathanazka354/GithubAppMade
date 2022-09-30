package com.fathan.madegithub.core.di

import com.fathan.madegithub.core.domain.usecase.UserInteractor
import com.fathan.madegithub.core.domain.usecase.UserUseCase
import com.fathan.madegithub.detail.DetailViewModel
import com.fathan.madegithub.favorite.FavoriteViewModel
import com.fathan.madegithub.follow.FollowViewModel
import com.fathan.madegithub.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
val useCaseModule = module {
    factory <UserUseCase>{ UserInteractor(get()) }
}

val viewModelModule = module {
    viewModel{HomeViewModel(get())}
    viewModel{DetailViewModel(get())}
    viewModel{FollowViewModel(get())}
    viewModel{FavoriteViewModel(get())}
}
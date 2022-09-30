package com.fathan.madegithub.core.domain.usecase

import com.fathan.madegithub.core.data.Resource
import com.fathan.madegithub.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    fun getAllUser(query: String?): Flow<Resource<List<User>>>
    fun getFollowers(username: String): Flow<Resource<List<User>>>
    fun getFollowing(username: String): Flow<Resource<List<User>>>
    fun getDetailUser(username: String): Flow<Resource<User>>
    fun getFavoriteUser(): Flow<List<User>>
    fun getDetailState(username: String): Flow<User>?
    suspend fun insertUser(user: User)
    suspend fun deleteUser(user: User):Int
}
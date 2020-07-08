package com.example.users.domain

import com.example.core.interfaces.UserRepository
import com.example.model.User
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersInteractor @Inject constructor(
    private val userRepository: UserRepository
) {

    fun getUsers(): Observable<List<User>> {
        return userRepository.getUsers()
            .subscribeOn(Schedulers.io())
    }
}
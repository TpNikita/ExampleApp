package com.example.user.domain

import com.example.core.interfaces.UserRepository
import com.example.model.User
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val userRepository: UserRepository
) {

    fun getUser(id: Int): Observable<User> {
        return userRepository.getUser(id)
            .subscribeOn(Schedulers.io())
    }
}
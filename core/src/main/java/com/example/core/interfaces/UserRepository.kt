package com.example.core.interfaces

import com.example.model.User
import io.reactivex.Observable

interface UserRepository {

    fun getUser(id: Int): Observable<User>

    fun getUsers(): Observable<List<User>>
}
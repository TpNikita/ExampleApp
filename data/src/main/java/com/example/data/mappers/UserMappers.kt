package com.example.data.mappers

import com.example.data.db.model.UserLocal
import com.example.data.network.model.UserRemote
import com.example.model.User

fun mapUserToUserLocal(user: User): UserLocal {
    return with(user) {
        UserLocal(id, firstName, lastName)
    }
}

fun mapUserLocalToUser(user: UserLocal): User {
    return with(user) {
        User(id, firstName, lastName)
    }
}

fun mapUserRemoteToUser(user: UserRemote): User {
    return with(user) {
        User(id, firstName, lastName)
    }
}
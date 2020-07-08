package com.example.data.di

import com.example.core.di.ApplicationScope
import com.example.core.interfaces.UserRepository
import com.example.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds
    @ApplicationScope
    fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
}
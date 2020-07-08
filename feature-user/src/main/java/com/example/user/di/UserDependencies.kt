package com.example.user.di

import com.example.core.di.ComponentDependencies
import com.example.core.interfaces.UserRepository

interface UserDependencies : ComponentDependencies {

    fun provideUserRepository(): UserRepository
}
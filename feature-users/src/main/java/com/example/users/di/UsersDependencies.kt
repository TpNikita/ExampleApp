package com.example.users.di

import com.example.core.di.ComponentDependencies
import com.example.core.interfaces.UserRepository

interface UsersDependencies : ComponentDependencies {

    fun provideUserRepository(): UserRepository
}
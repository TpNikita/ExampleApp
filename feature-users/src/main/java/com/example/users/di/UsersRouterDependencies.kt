package com.example.users.di

import com.example.core.di.ComponentDependencies
import com.example.users.navigation.UsersRouter

interface UsersRouterDependencies : ComponentDependencies {

    fun provideRouter(): UsersRouter
}
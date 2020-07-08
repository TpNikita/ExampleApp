package com.example.splash.di

import com.example.core.di.ComponentDependencies
import com.example.splash.navigation.SplashRouter

interface SplashRouterDependencies : ComponentDependencies {

    fun provideSplashRouter(): SplashRouter
}

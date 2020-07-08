package com.example.app.di

import com.example.app.router.AppRouterImpl
import com.example.core.di.ActivityScope
import com.example.splash.navigation.SplashRouter
import com.example.users.navigation.UsersRouter
import dagger.Binds
import dagger.Module

@Module
abstract class RouterModule {

    @Binds
    @ActivityScope
    abstract fun bindUsersRouter(router: AppRouterImpl): UsersRouter

    @Binds
    @ActivityScope
    abstract fun bindSplashRouter(router: AppRouterImpl): SplashRouter
}
package com.example.app.di

import com.example.core.di.ComponentDependencies
import com.example.splash.di.SplashRouterDependencies
import com.example.users.di.UsersRouterDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RouterDependenciesModule private constructor() {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(SplashRouterDependencies::class)
    abstract fun provideSplashRouterDependencies(component: ActivityComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(UsersRouterDependencies::class)
    abstract fun provideAuthRouterDependencies(component: ActivityComponent): ComponentDependencies
}
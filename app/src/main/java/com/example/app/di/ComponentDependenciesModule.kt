package com.example.app.di

import com.example.core.di.ComponentDependencies
import com.example.splash.di.SplashDependencies
import com.example.user.di.UserDependencies
import com.example.users.di.UsersDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ComponentDependenciesModule private constructor() {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(UsersDependencies::class)
    abstract fun provideMainDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(UserDependencies::class)
    abstract fun provideSecondDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(SplashDependencies::class)
    abstract fun provideSplashDependencies(component: AppComponent): ComponentDependencies
}
package com.example.app.di

import com.example.app.App
import com.example.core.di.ApplicationScope
import com.example.data.di.ApiModule
import com.example.data.di.RepoModule
import com.example.splash.di.SplashDependencies
import com.example.user.di.UserDependencies
import com.example.users.di.UsersDependencies
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        RepoModule::class,
        ComponentDependenciesModule::class
    ]
)
interface AppComponent : UsersDependencies, UserDependencies, SplashDependencies {

    fun inject(app: App)
}
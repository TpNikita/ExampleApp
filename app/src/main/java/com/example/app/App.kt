package com.example.app

import android.app.Application
import com.example.app.di.AppModule
import com.example.app.di.DaggerAppComponent
import com.example.core.di.ComponentDependenciesProvider
import com.example.core.di.HasComponentDependencies
import javax.inject.Inject

open class App : Application(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider
        protected set

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
            .inject(this)
    }
}
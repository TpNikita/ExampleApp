package com.example.app.di

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.app.presentation.MainActivity
import com.example.core.di.ActivityScope
import com.example.splash.di.SplashRouterDependencies
import com.example.users.di.UsersRouterDependencies
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        RouterDependenciesModule::class,
        RouterModule::class
    ])
@ActivityScope
interface ActivityComponent : SplashRouterDependencies, UsersRouterDependencies {

    companion object {
        fun init(activity: AppCompatActivity, navController: NavController): ActivityComponent =
            DaggerActivityComponent.factory().create(activity, navController)
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: AppCompatActivity,
            @BindsInstance navController: NavController
        ): ActivityComponent
    }

    fun inject(activity: MainActivity)
}
package com.example.splash.di

import androidx.fragment.app.Fragment
import com.example.core.di.FeatureScope
import com.example.splash.presentation.SplashFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        SplashDependencies::class,
        SplashRouterDependencies::class
    ],
    modules = [
        SplashModule::class
    ]
)
@FeatureScope
interface SplashComponent {

    companion object {

        fun init(
                fragment: Fragment,
                deps: SplashDependencies,
                routerDeps: SplashRouterDependencies
        ): SplashComponent {
            return DaggerSplashComponent.factory().create(fragment, deps, routerDeps)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
                @BindsInstance fragment: Fragment,
                deps: SplashDependencies,
                routerDeps: SplashRouterDependencies
        ): SplashComponent
    }

    fun inject(fragment: SplashFragment)
}
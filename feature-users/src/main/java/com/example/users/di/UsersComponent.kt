package com.example.users.di

import androidx.fragment.app.Fragment
import com.example.core.di.FeatureScope
import com.example.users.presentation.UsersFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        UsersDependencies::class,
        UsersRouterDependencies::class
    ],
    modules = [
        UsersModule::class
    ]
)
@FeatureScope
interface UsersComponent {

    companion object {
        fun init(
                fragment: Fragment,
                deps: UsersDependencies,
                routerDeps: UsersRouterDependencies
        ): UsersComponent {
            return DaggerUsersComponent.factory().create(fragment, deps, routerDeps)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
                @BindsInstance fragment: Fragment,
                deps: UsersDependencies,
                routerDeps: UsersRouterDependencies
        ): UsersComponent
    }

    fun inject(fragment: UsersFragment)
}
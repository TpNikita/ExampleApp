package com.example.user.di

import androidx.fragment.app.Fragment
import com.example.core.di.FeatureScope
import com.example.user.presentation.UserFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        UserDependencies::class
    ],
    modules = [
        UserModule::class
    ]
)
@FeatureScope
interface UserComponent {

    companion object {

        fun init(fragment: Fragment, userId: Int, deps: UserDependencies): UserComponent {
            return DaggerUserComponent.factory().create(fragment, userId, deps)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment,
            @BindsInstance userId: Int,
            deps: UserDependencies
        ): UserComponent
    }

    fun inject(fragment: UserFragment)
}
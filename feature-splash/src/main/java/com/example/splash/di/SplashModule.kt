package com.example.splash.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.common.di.ViewModelKey
import com.example.common.di.ViewModelModule
import com.example.splash.navigation.SplashRouter
import com.example.splash.presentation.SplashViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
class SplashModule {

    @Provides
    internal fun provideScannerViewModel(fragment: Fragment, factory: ViewModelProvider.Factory): SplashViewModel {
        return ViewModelProviders.of(fragment, factory).get(SplashViewModel::class.java)
    }

    @Provides
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun provideSignInViewModel(router: SplashRouter): ViewModel {
        return SplashViewModel(router)
    }
}
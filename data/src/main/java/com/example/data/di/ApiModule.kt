package com.example.data.di

import com.example.core.di.ApplicationScope
import com.example.data.network.UserApi
import com.example.data.network.UserApiImpl
import dagger.Binds
import dagger.Module

@Module
interface ApiModule {

    @ApplicationScope
    @Binds
    fun bindUserApi(userApi: UserApiImpl): UserApi
}